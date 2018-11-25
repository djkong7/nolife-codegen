/**
 * 
 */
package frontend.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frontend.ast.AbstractSyntaxTree;
import frontend.ast.AddExpressionNode;
import frontend.ast.AndExpressionNode;
import frontend.ast.ArrayReferenceNode;
import frontend.ast.ArrayTypeNode;
import frontend.ast.AssignmentStatementNode;
import frontend.ast.BinaryComparisonNode;
import frontend.ast.BinaryExpressionNode;
import frontend.ast.CaseElementListNode;
import frontend.ast.CaseElementNode;
import frontend.ast.CaseStatementNode;
import frontend.ast.CharacterDimensionNode;
import frontend.ast.CharacterNode;
import frontend.ast.CompoundStatementNode;
import frontend.ast.ConstantNode;
import frontend.ast.DivExpressionNode;
import frontend.ast.EqualExpressionNode;
import frontend.ast.ExpressionListNode;
import frontend.ast.ExpressionNode;
import frontend.ast.FloatConstNode;
import frontend.ast.FunctionDeclNode;
import frontend.ast.FunctionInvocationNode;
import frontend.ast.GreaterEqualExpressionNode;
import frontend.ast.GreaterThanExpressionNode;
import frontend.ast.IfStatementNode;
import frontend.ast.IntegerConstNode;
import frontend.ast.IntegerDimensionNode;
import frontend.ast.InvocationNode;
import frontend.ast.LessEqualExpressionNode;
import frontend.ast.LessThanExpressionNode;
import frontend.ast.ModExpressionNode;
import frontend.ast.MultiplyExpressionNode;
import frontend.ast.NilNode;
import frontend.ast.NotEqualExpressionNode;
import frontend.ast.NotExpressionNode;
import frontend.ast.OrExpressionNode;
import frontend.ast.ParenthesisNode;
import frontend.ast.PointerDereferenceNode;
import frontend.ast.PointerTypeNode;
import frontend.ast.ProcedureDeclNode;
import frontend.ast.ProcedureInvocationNode;
import frontend.ast.ProgramNode;
import frontend.ast.ReadStatementNode;
import frontend.ast.RecordDeclListNode;
import frontend.ast.RecordDeclarationNode;
import frontend.ast.RecordElementListNode;
import frontend.ast.RecordElementNode;
import frontend.ast.RecordInstantiationNode;
import frontend.ast.RecordReferenceNode;
import frontend.ast.RecordTypeNode;
import frontend.ast.ReturnStatementNode;
import frontend.ast.ScalarReferenceNode;
import frontend.ast.StandardTypeNode;
import frontend.ast.StringNode;
import frontend.ast.SubProgramDeclListNode;
import frontend.ast.SubProgramDeclNode;
import frontend.ast.SubtractExpressionNode;
import frontend.ast.VariableDeclarationListNode;
import frontend.ast.VariableDeclarationNode;
import frontend.ast.WhileStatementNode;
import frontend.ast.WriteStatementNode;
import frontend.utils.RecordLayoutEntry;
import frontend.utils.SymbolTable;
import frontend.utils.SymbolTableEntry;
import frontend.utils.TypeTable;

/**
 * @author carr
 *
 */
public class TypeCheckVisitor implements ASTVisitor<Integer> {

	private SymbolTable symTable;

	/**
	 * 
	 */
	public TypeCheckVisitor() {
	}
	
	public TypeCheckVisitor addSymbolTable(SymbolTable symtab) {
		symTable = symtab;
		return this;
	}

	private int typeCheckArithmetic(BinaryExpressionNode n) {
		int lhsType = (int) n.getLeftOperand().accept(this);
		int rhsType = (int) n.getRightOperand().accept(this);

		n.addRealType(TypeTable.getResultArithmeticType(lhsType, rhsType));

		if (n.getRealType() == TypeTable.ERROR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Type mismatch " + n.getSource());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else if (lhsType != rhsType) {
			if (n.getRealType() == lhsType)
				n.getLeftOperand().addConvertedType(lhsType);
			else if (lhsType == TypeTable.INT_TYPE)
				n.getLeftOperand().addConvertedType(TypeTable.FLOAT_TYPE);
			else
				n.getLeftOperand().addConvertedType(lhsType);

			if (n.getRealType() == rhsType)
				n.getRightOperand().addConvertedType(rhsType);
			else if (rhsType == TypeTable.INT_TYPE)
				n.getRightOperand().addConvertedType(TypeTable.FLOAT_TYPE);
			else
				n.getRightOperand().addConvertedType(rhsType);
		} else {
			n.getLeftOperand().addConvertedType(n.getRealType());
			n.getRightOperand().addConvertedType(n.getRealType());
		}

		return n.getRealType();

	}

	@Override
	public Integer visit(AddExpressionNode n) {
		return typeCheckArithmetic(n);
	}

	@Override
	public Integer visit(ArrayReferenceNode n) {
		int subscriptType = (int) n.getSubscript().accept(this);

		n.getSubscript().addConvertedType(subscriptType);

		SymbolTableEntry entry = symTable.getEntry(n.getName());

		if (entry == null) {
			System.err.println("Line " + n.getLineNumber() + ": Undeclared variable " + n.getName());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else {

			n.addRealType(TypeTable.getArrayBasicType(entry.getDataType()));

			if (n.getRealType() == TypeTable.ERROR_TYPE) {
				System.err.println("Line " + n.getLineNumber() + ": Subscript applied to non-array");
				AbstractSyntaxTree.error = true;
				n.addRealType(TypeTable.ANY_TYPE);
			} else {
				int arrayType = entry.getDataType();
				if (subscriptType != TypeTable.getArraySubscriptType(arrayType)) {
					System.err
							.println("Line " + n.getLineNumber() + ": subscripting type error on array " + n.getName());
					AbstractSyntaxTree.error = true;
				} else {
					n.setLowerBound(TypeTable.getArrayLowerBoundValue(arrayType));
					if (n.getSubscript() instanceof IntegerConstNode) {
						int upb = TypeTable.getArrayIntUpperBound(arrayType);
						int index = ((IntegerConstNode) n.getSubscript()).getValue();

						if (index < n.getLowerBound() || index > upb) {
							System.err.println("Line " + n.getLineNumber() + ": Constant index out of bounds on array "
									+ n.getName());
							AbstractSyntaxTree.error = true;
						}
					} else if (n.getSubscript() instanceof CharacterNode) {
						char c_lwb = TypeTable.getArrayCharLowerBound(arrayType);
						char c_upb = TypeTable.getArrayCharUpperBound(arrayType);
						char c_index = ((CharacterNode) n.getSubscript()).getValue();

						if (c_index < c_lwb || c_index > c_upb) {
							System.err.println("Line " + n.getLineNumber() + ": Constant index out of bounds on array "
									+ n.getName());
							AbstractSyntaxTree.error = true;
						}
					}
				}
			}
			entry.setReferenced();
			n.setNestingLevel(entry.getNestingLevel());
		}

		return n.getRealType();
	}

	private int typeCheckLogical(BinaryExpressionNode n) {
		int lhsType = (int) n.getLeftOperand().accept(this);
		int rhsType = (int) n.getRightOperand().accept(this);

		n.addRealType(TypeTable.getResultBooleanType(lhsType, rhsType));

		if (n.getRealType() == TypeTable.ERROR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Type mismatch " + n.getSource());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else if (lhsType != rhsType) {
			if (n.getRealType() == lhsType)
				n.getLeftOperand().addConvertedType(lhsType);
			else if (lhsType == TypeTable.FLOAT_TYPE)
				n.getLeftOperand().addConvertedType(TypeTable.INT_TYPE);
			else
				n.getLeftOperand().addConvertedType(lhsType);

			if (n.getRealType() == rhsType)
				n.getRightOperand().addConvertedType(rhsType);
			else if (rhsType == TypeTable.FLOAT_TYPE)
				n.getRightOperand().addConvertedType(TypeTable.INT_TYPE);
			else
				n.getRightOperand().addConvertedType(rhsType);
		} else {
			n.getLeftOperand().addConvertedType(n.getRealType());
			n.getRightOperand().addConvertedType(n.getRealType());
		}

		return n.getRealType();		
	}
	
	@Override
	public Integer visit(AndExpressionNode n) {
		return typeCheckLogical(n);
	}

	@Override
	public Integer visit(ArrayTypeNode n) {
		n.addRealType(TypeTable.NO_TYPE);
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(AssignmentStatementNode n) {
		int lhsType = (int) n.getLhs().accept(this);
		int rhsType = (int) n.getRhs().accept(this);

		int realType = TypeTable.getResultAssignmentType(lhsType, rhsType);

		if (realType == TypeTable.ERROR_TYPE) {
			System.err
					.println("Line " + n.getLineNumber() + ": Type mismatch in assignment statement " + n.getSource());
			AbstractSyntaxTree.error = true;
			n.addConvertedType(TypeTable.ANY_TYPE);
		} else
			n.addConvertedType(lhsType);

		n.getRhs().addConvertedType(n.getConvertedType());
		n.getLhs().addConvertedType(n.getConvertedType());

		realType = TypeTable.NO_TYPE;

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(CaseElementNode n) {
		ConstantNode constNode = (ConstantNode) n.getCaseLabelList().getExpression(0);

		n.addRealType((int) constNode.accept(this));
		n.addConvertedType(n.getRealType());

		for (int i = 1; i < n.getCaseLabelList().size(); i++) {
			constNode = (ConstantNode) n.getCaseLabelList().getExpression(i);

			if (constNode != null) {

				int labelType = (int) constNode.accept(this);
				constNode.addConvertedType(n.getRealType());

				if (labelType != n.getRealType()) {
					System.err.println("Line " + n.getLineNumber() + ": Multiple types in set of case labels");
					AbstractSyntaxTree.error = true;
				}
			}
		}

		n.getStatementNode().accept(this);

		return n.getRealType();
	}

	@Override
	public Integer visit(CaseStatementNode n) {
		int testType = (int) n.getCaseExpression().accept(this);

		n.getCaseExpression().addConvertedType(testType);

		for (int i = 0; i < n.getCaseElements().size(); i++) {
			CaseElementNode caseElement = (CaseElementNode) n.getCaseElements().getCaseElement(i);
			caseElement.accept(this);

			if (testType != caseElement.getRealType()) {
				System.err.println("Line " + caseElement.getLineNumber() + ": Type mismatch in case label");
				AbstractSyntaxTree.error = true;
			}
		}

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(CharacterDimensionNode n) {
		n.addRealType(TypeTable.NO_TYPE);
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(CharacterNode n) {
		n.addRealType(TypeTable.CHAR_TYPE);
		return TypeTable.CHAR_TYPE;
	}

	@Override
	public Integer visit(CompoundStatementNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getStatement(i).accept(this);

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(DivExpressionNode n) {
		int lhsType = (int) n.getLeftOperand().accept(this);
		int rhsType = (int) n.getRightOperand().accept(this);

		n.addRealType(TypeTable.getResultArithmeticType(lhsType, rhsType));

		if (n.getRealType() == TypeTable.ERROR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Type mismatch in divide operation");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else if (lhsType != rhsType) {
			if (n.getRealType() == lhsType)
				n.getLeftOperand().addConvertedType(lhsType);
			else if (n.getRealType() == TypeTable.INT_TYPE)
				n.getLeftOperand().addConvertedType(TypeTable.FLOAT_TYPE);
			else
				n.getLeftOperand().addConvertedType(lhsType);

			if (n.getRealType() == rhsType)
				n.getRightOperand().addConvertedType(rhsType);
			else if (rhsType == TypeTable.INT_TYPE)
				n.getRightOperand().addConvertedType(TypeTable.FLOAT_TYPE);
			else
				n.getRightOperand().addConvertedType(rhsType);
		} else {
			n.getLeftOperand().addConvertedType(n.getRealType());
			n.getRightOperand().addConvertedType(n.getRealType());
		}

		return n.getRealType();
	}

	public int typeCheckComparison(BinaryComparisonNode n) {

		int lhsType = (int) n.getLeftOperand().accept(this);
		int rhsType = (int) n.getRightOperand().accept(this);

		n.addRealType(TypeTable.getResultComparisonType(lhsType, rhsType));

		if (n.getRealType() == TypeTable.ERROR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Type mismatch in equal comparison");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else if (lhsType != rhsType) {
			if (lhsType == TypeTable.INT_TYPE) {
				n.getLeftOperand().addConvertedType(TypeTable.FLOAT_TYPE);
				n.getRightOperand().addConvertedType(n.getRightOperand().getRealType());
			} else if (rhsType == TypeTable.NIL_TYPE || lhsType == TypeTable.NIL_TYPE) {
				/* comparison of record and nil does not cause type conversion */
				n.getLeftOperand().addConvertedType(n.getLeftOperand().getRealType());
				n.getRightOperand().addConvertedType(n.getRightOperand().getRealType());
			} else { // rhsType is int
				n.getRightOperand().addConvertedType(TypeTable.FLOAT_TYPE);
				n.getLeftOperand().addConvertedType(n.getLeftOperand().getRealType());
			}
		} else {
			n.getLeftOperand().addConvertedType(n.getLeftOperand().getRealType());
			n.getRightOperand().addConvertedType(n.getRightOperand().getRealType());
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(EqualExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(FloatConstNode n) {
		n.addRealType(TypeTable.FLOAT_TYPE);

		return TypeTable.FLOAT_TYPE;
	}

	private int typeCheckSubProgram(SubProgramDeclNode n) {
		symTable.beginScope();

		n.setNestingLevel(symTable.getCurrentLevel());

		n.getParamList().accept(this);

		n.getVariableDeclarations().accept(this);

		n.getBody().accept(this);

		if (n instanceof FunctionDeclNode && n.getReturnType() instanceof StandardTypeNode
				&& ((StandardTypeNode) n.getReturnType()).getBasicType() != TypeTable.NO_TYPE
				&& !n.getBody().containsReturnStatement()) {
			System.err.println("Line " + n.getLineNumber() + ": missing return statement in function " + n.getName());
			AbstractSyntaxTree.error = true;
		}

		for (int i = 0; i < n.getVariableDeclarations().size(); i++) {
			VariableDeclarationNode decl = (VariableDeclarationNode) n.getVariableDeclarations().getVariableDecl(i);
			decl.accept(new ByReferenceVisitor().addSymbolTable(symTable));
		}

		symTable.endScope(n.getName());

		return symTable.getEntry(n.getName()).getDataType();

	}

	@Override
	public Integer visit(FunctionDeclNode n) {
		return typeCheckSubProgram(n);
	}

	@Override
	public Integer visit(FunctionInvocationNode n) {
		n.addRealType((int) n.getInvocation().accept(this));
		n.getInvocation().addConvertedType(n.getRealType());

		if (n.getRealType() == TypeTable.NO_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Procedure invoked as function");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(GreaterEqualExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(GreaterThanExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(IfStatementNode n) {
		int exprType = (int) n.getTestExpression().accept(this);

		if (exprType == TypeTable.CHAR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": if test expression of type char not allowed");
			AbstractSyntaxTree.error = true;
		}

		n.getTestExpression().addConvertedType(TypeTable.INT_TYPE);

		n.getThenStatement().accept(this);

		if (n.getElseStatement() != null)
			n.getElseStatement().accept(this);

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(IntegerConstNode n) {

		n.addRealType(TypeTable.INT_TYPE);

		return TypeTable.INT_TYPE;
	}

	@Override
	public Integer visit(IntegerDimensionNode n) {
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(InvocationNode n) {
		for (int i = 0; i < n.getActualParameters().size(); i++) {
			ExpressionNode expr = n.getActualParameters().getExpression(i);
			int paramType = (int) expr.accept(this);
			expr.addConvertedType(paramType);
			if (expr instanceof ScalarReferenceNode) {
				SymbolTableEntry entry = symTable.getEntry(((ScalarReferenceNode) expr).getName());
				if (entry != null)
					entry.setPassedByReference();
			}
		}

		SymbolTableEntry entry = symTable.getEntry(n.getName());

		if (entry == null) {
			System.err.println("Line " + n.getLineNumber() + ": Undeclared variable " + n.getName());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else {
			entry.setReferenced();
			int returnType = TypeTable.getFunctionReturnType(entry.getDataType());
			Pattern funcPattern = Pattern.compile(n.toString() + TypeTable.getTypeString(returnType));

			String typeString = TypeTable.getTypeString(entry.getDataType());
			Matcher funcMatcher = funcPattern.matcher(typeString);

			if (!funcMatcher.matches()) {
				System.err.println("Line " + n.getLineNumber() + ": Mismatched parameter types for function " +
						n.getName());
				AbstractSyntaxTree.error = true;
			}
			n.addRealType(returnType);
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(LessEqualExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(LessThanExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(ModExpressionNode n) {
		int lhsType = (int) n.getLeftOperand().accept(this);
		int rhsType = (int) n.getRightOperand().accept(this);

		n.getLeftOperand().addConvertedType(TypeTable.INT_TYPE);
		n.getRightOperand().addConvertedType(TypeTable.INT_TYPE);

		if (lhsType != TypeTable.INT_TYPE || rhsType != TypeTable.INT_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": MOD requires integer operands");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else
			n.addRealType(TypeTable.INT_TYPE);

		return n.getRealType();
	}

	@Override
	public Integer visit(MultiplyExpressionNode n) {
		return typeCheckArithmetic(n);
	}

	@Override
	public Integer visit(NilNode n) {
		n.addRealType(TypeTable.NIL_TYPE);
		
		return TypeTable.NIL_TYPE;
	}

	@Override
	public Integer visit(NotEqualExpressionNode n) {
		return typeCheckComparison(n);
	}

	@Override
	public Integer visit(NotExpressionNode n) {
		n.addRealType((int) n.getOperand().accept(this));
		n.getOperand().addConvertedType(TypeTable.INT_TYPE);

		if (n.getRealType()!= TypeTable.INT_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": NOT requires an integer operand");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(OrExpressionNode n) {
		return typeCheckLogical(n);
	}

	@Override
	public Integer visit(ParenthesisNode n) {
		n.addRealType((int) n.getOperand().accept(this));
		n.getOperand().addConvertedType(n.getRealType());

		return n.getRealType();
	}

	@Override
	public Integer visit(PointerDereferenceNode n) {
		int type = (int) n.getOperand().accept(this);
		n.getOperand().addConvertedType(type);
		n.addRealType(TypeTable.getBasePointerType(type));

		if (n.getRealType() == TypeTable.ERROR_TYPE) {
			System.err.println("Line " + n.getLabel() + ": Dereferencing non-pointer " + n.getOperand().getSource());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(PointerTypeNode n) {
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(ProcedureDeclNode n) {
		return typeCheckSubProgram(n);
	}

	@Override
	public Integer visit(ProcedureInvocationNode n) {
		n.addRealType((int)n.getInvocation().accept(this));
		n.getInvocation().addConvertedType(TypeTable.NO_TYPE);

		if (n.getRealType() != TypeTable.NO_TYPE && n.getRealType() != TypeTable.ANY_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": Function invoked as a procedure");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.NO_TYPE);
		}

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(ProgramNode n) {
		symTable.beginScope();

		for (int i = 0; i < n.getRecordDecls().size(); i++) {
			RecordDeclarationNode decl = n.getRecordDecls().getRecordDeclaration(i);
			decl.addToSymTable(symTable);
		}

		n.getRecordDecls().accept(this);

		n.getVariableDeclarations().accept(this);

		for (int i = 0; i < n.getSubProgramDecls().size(); i++) {
			SubProgramDeclNode subProg = n.getSubProgramDecls().getSubProgram(i);
			subProg.addToSymTable(symTable);
		}

		n.getSubProgramDecls().accept(this);

		n.getBody().accept(this);

		if (n.getBody().containsReturnStatement()) {
			System.err.println("Line " + n.getLineNumber() + ": main body contains return statement");
		}

		for (int i = 0; i < n.getVariableDeclarations().size(); i++) {
			VariableDeclarationNode decl = n.getVariableDeclarations().getVariableDecl(i);
			decl.accept(new ByReferenceVisitor().addSymbolTable(symTable));
		}

		symTable.endScope(n.getName());

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(ReadStatementNode n) {
		n.getVariable().addConvertedType((int) n.getVariable().accept(this));

		n.addRealType(TypeTable.NO_TYPE);

		if (n.getVariable() instanceof ScalarReferenceNode) {
			SymbolTableEntry entry = symTable.getEntry(((ScalarReferenceNode) n.getVariable()).getName());
			entry.setPassedByReference();

		}

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(RecordDeclarationNode n) {
		SymbolTableEntry entry = symTable.getEntry(n.getRecordName());

		int typeVal = TypeTable.getTypeVal(n.toString());

		RecordLayoutEntry recordInfo = new RecordLayoutEntry();

		n.getRecordElements().accept(this);

		entry.setDataType(typeVal);
		entry.setNestingLevel(symTable.getCurrentLevel());

		TypeTable.putRecordLayoutEntry(n.getRecordName(), recordInfo);

		n.addRealType(typeVal);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(RecordElementNode n) {
		int typeVal = TypeTable.getTypeVal(n.getType().toString());

		for (int i = 0; i < n.getNames().size(); i++) {
			String id = (String) n.getNames().elementAt(i);

			SymbolTableEntry entry;
			if ((entry = symTable.add(id)) == null) {
				System.err.println("Line " + n.getLineNumber() + ": Duplicate record element declaration: " + id);
				AbstractSyntaxTree.error = true;
			} else {
				entry.setDataType(typeVal);
				entry.setNestingLevel(symTable.getCurrentLevel());
				n.getType().addRealType(typeVal);
			}
		}

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(RecordInstantiationNode n) {
		SymbolTableEntry entry = symTable.getEntry(n.getRecordName());
		int type = entry.getDataType();
		
	    if (TypeTable.isRecordType(type))
	    	n.addRealType(type);
	    else {
			System.err.println("Line " + n.getLineNumber()
					+ ": Tyring to instantiate a non-record type: " + n.getRecordName());
			AbstractSyntaxTree.error = true;
			type = TypeTable.ANY_TYPE;
	    }

		return type;
	}

	@Override
	public Integer visit(RecordReferenceNode n) {
		SymbolTableEntry entry = symTable.getEntry(n.getName());

		if (entry == null) {
			System.err.println("Line " + n.getLineNumber() + ": Undeclared variable " + n.getName());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else if (!TypeTable.isRecordType(entry.getDataType())) {
			System.err.println("Line " + n.getLineNumber() + ": Undeclared variable " + n.getName());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else {
			RecordLayoutEntry rlEntry = TypeTable.getRecordLayoutEntry(entry.getDataType());
			TypeCheckVisitor tcv = new TypeCheckVisitor()
					.addSymbolTable(rlEntry.getElementSymbolTable());
			n.addRealType((int) n.getElement().accept(tcv));
		}

		n.setNestingLevel(entry.getNestingLevel());

		return n.getRealType();
	}

	@Override
	public Integer visit(RecordTypeNode n) {
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(ReturnStatementNode n) {
		int returnType = (int) n.getReturnExpression().accept(this);
		SubProgramDeclNode subDecl = n.getContainingSubProgram();

		if (returnType != TypeTable.getFunctionReturnType(subDecl.getRealType())) {
			System.err.println("Line " + n.getLineNumber() + ": return type does not match declaration");
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else {
			n.getReturnExpression().addConvertedType(returnType);
			n.addRealType(returnType);
		}

		return n.getRealType();
	}

	@Override
	public Integer visit(ScalarReferenceNode n) {
		SymbolTableEntry entry = symTable.getEntry(n.getName());

		if (entry == null) {
			System.err.println("Line " + n.getLineNumber() + ": Undeclared variable " + n.getName());
			AbstractSyntaxTree.error = true;
			n.addRealType(TypeTable.ANY_TYPE);
		} else {
			n.addRealType(entry.getDataType());
			entry.setReferenced();
			n.setNestingLevel(entry.getNestingLevel());
		}

		SubProgramDeclNode subProg = n.getContainingSubProgram();

		//
		// if this is a global variable accessed outside the main procedure
		// then it must be allocated to the stack
		//

		if (entry != null && n.getNestingLevel() == 0 && subProg.getNestingLevel() > 0)
			entry.setPassedByReference();
		return n.getRealType();
	}

	@Override
	public Integer visit(StandardTypeNode n) {
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(StringNode n) {
		n.addRealType(TypeTable.STRING_TYPE);

		return TypeTable.STRING_TYPE;
	}

	@Override
	public Integer visit(SubtractExpressionNode n) {
		return typeCheckArithmetic(n);
	}

	@Override
	public Integer visit(VariableDeclarationNode n) {
		int typeVal = TypeTable.getTypeVal(n.getType().toString());

		for (int i = 0; i < n.getVariableList().size(); i++) {
			String id = n.getVariableList().get(i);

			SymbolTableEntry entry;
			if ((entry = symTable.add(id)) == null) {
				System.err.println("Line " + n.getLineNumber() + ": Duplicate variable declaration: " + id);
				AbstractSyntaxTree.error = true;
			} else {
				entry.setDataType(typeVal);
				entry.setNestingLevel(symTable.getCurrentLevel());
				n.getType().addRealType(typeVal);
			}
		}

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(WhileStatementNode n) {
		int exprType = (int) n.getWhileExpression().accept(this);

		if (exprType == TypeTable.CHAR_TYPE) {
			System.err.println("Line " + n.getLineNumber() + ": while expression of type char not allowed");
			AbstractSyntaxTree.error = true;
		}

		n.getWhileExpression().addConvertedType(TypeTable.INT_TYPE);

		n.getControlledStatement().accept(this);

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;	
	}

	@Override
	public Integer visit(WriteStatementNode n) {
		n.getWriteExpression().addConvertedType((int) n.getWriteExpression().accept(this));

		n.addRealType(TypeTable.NO_TYPE);

		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(ExpressionListNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getExpression(i).accept(this);
	
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(CaseElementListNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getCaseElement(i).accept(this);
		
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(VariableDeclarationListNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getVariableDecl(i).accept(this);
		
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(RecordDeclListNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getRecordDeclaration(i).accept(this);
		
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(SubProgramDeclListNode n) {
		for (int i = 0; i < n.size(); i++) 
			n.getSubProgram(i).accept(this);
		
		return TypeTable.NO_TYPE;
	}

	@Override
	public Integer visit(RecordElementListNode n) {
		for (int i = 0; i < n.size(); i++)
			n.getRecordElement(i).accept(this);
		
		return TypeTable.NO_TYPE;
	}

}
