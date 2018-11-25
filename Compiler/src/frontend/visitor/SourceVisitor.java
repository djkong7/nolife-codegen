/**
 * 
 */
package frontend.visitor;

import frontend.ast.ASTNode;
import frontend.ast.AbstractSyntaxTree;
import frontend.ast.AddExpressionNode;
import frontend.ast.AndExpressionNode;
import frontend.ast.ArrayReferenceNode;
import frontend.ast.ArrayTypeNode;
import frontend.ast.AssignmentStatementNode;
import frontend.ast.CaseElementListNode;
import frontend.ast.CaseElementNode;
import frontend.ast.CaseStatementNode;
import frontend.ast.CharacterDimensionNode;
import frontend.ast.CharacterNode;
import frontend.ast.CompoundStatementNode;
import frontend.ast.DivExpressionNode;
import frontend.ast.EqualExpressionNode;
import frontend.ast.ExpressionListNode;
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
import frontend.utils.TypeTable;

/**
 * @author carr
 *
 */
public class SourceVisitor implements ASTVisitor<String> {

	private String stmtPrefix = "";
	
	private String pushIndent() {
		stmtPrefix += "   ";
		return stmtPrefix;
	}
	
	private String popIndent() {
		stmtPrefix = stmtPrefix.substring(0,stmtPrefix.length()-3);
		return stmtPrefix;
	}
	/**
	 * 
	 */
	public SourceVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String visit(AddExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(ArrayReferenceNode n) {
		return n.getName() + "[" + n.getSubscript().accept(this) + "]";
	}

	@Override
	public String visit(AndExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(ArrayTypeNode n) {
		return AbstractSyntaxTree.isNolife
				? "ARRAY " + n.getDimension().accept(this) + " OF " + n.getBaseType().accept(this)
				: n.getBaseType().accept(this) + "[" + n.getDimension().accept(this);
	}

	@Override
	public String visit(AssignmentStatementNode n) {
		return n.getLhs().accept(this) + (AbstractSyntaxTree.isNolife ? " := " : " = ") + n.getRhs().accept(this);
	}

	@Override
	public String visit(CaseElementNode n) {
		return  (AbstractSyntaxTree.isNolife ? "\t" : "\t case ") +
				n.getCaseLabelList().accept(this) + ":\n\t\t" + 
				n.getStatementNode().accept(this);
	}

	@Override
	public String visit(CaseStatementNode n) {
		return (AbstractSyntaxTree.isNolife ? "CASE " + n.getCaseExpression().accept(this) + " OF"
				: "switch (" + n.getCaseExpression().accept(this) + ")") + n.getCaseElements().accept(this);
	}

	@Override
	public String visit(CharacterDimensionNode n) {
		return "['" + n.getLowerBound() + "'..'" + n.getUpperBound() + "']";
	}

	@Override
	public String visit(CharacterNode n) {
		return "'" + n.getValue() + "'";
	}

	@Override
	public String visit(CompoundStatementNode n) {
		String src = stmtPrefix + (AbstractSyntaxTree.isNolife ? "BEGIN\n" : "{\n");

		pushIndent();
		for (int i = 0; i < n.getStatementList().size() - 1; i++) {
			ASTNode sn = n.getStatementList().elementAt(i);
			src += stmtPrefix + sn.accept(this) + ";\n";
		}
		src += stmtPrefix + n.getLastStatement().accept(this);
		src += "\n" + popIndent() + (AbstractSyntaxTree.isNolife ? "END" : "}");

		return src;
	}

	@Override
	public String visit(DivExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(EqualExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(FloatConstNode n) {
		return Float.toString(n.getValue());
	}

	@Override
	public String visit(FunctionDeclNode n) {
		return AbstractSyntaxTree.isNolife
				? "FUNCTION " + n.getName() + "(" + n.getParamList().accept(this) + ") : " +
					n.getReturnType().accept(this) + ";\n"+ n.getBody().accept(this)
				: n.getReturnType().accept(this) + " " + n.getName() + "(" + 
					n.getParamList().accept(this) + ") "+ n.getBody().accept(this);
	}

	@Override
	public String visit(FunctionInvocationNode n) {
		return (String) n.getInvocation().accept(this);
	}

	@Override
	public String visit(GreaterEqualExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(GreaterThanExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(IfStatementNode n) {
		String src = (AbstractSyntaxTree.isNolife ? "IF " + n.getTestExpression().accept(this) + " THEN\n" :
			  "if (" + n.getTestExpression().accept(this) + ") \n") + 
				(n.getThenStatement() instanceof CompoundStatementNode ? n.getThenStatement().accept(this) :
					pushIndent() + n.getThenStatement().accept(this) + (popIndent().isEmpty() ? "" : ""));
		if (n.getElseStatement() != null) {
			src += "\n" + stmtPrefix + (AbstractSyntaxTree.isNolife ? "ELSE\n" : "else\n") + 
					pushIndent() + n.getElseStatement().accept(this);
			popIndent();
		}
		return src;
	}

	@Override
	public String visit(IntegerConstNode n) {
		return Integer.toString(n.getValue());
	}

	@Override
	public String visit(IntegerDimensionNode n) {
		return AbstractSyntaxTree.isNolife ? "[" +n.getLowerBound() + ".." + n.getUpperBound() + "]" :
			"[" + n.getUpperBound() + "]";
	}


	@Override
	public String visit(InvocationNode n) {
		return n.getName() + "(" + n.getActualParameters().accept(this) + ")";
	}

	@Override
	public String visit(LessEqualExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(LessThanExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(ModExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(MultiplyExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(NilNode n) {
		return AbstractSyntaxTree.isNolife ? "NIL" : "NULL";
	}

	@Override
	public String visit(NotEqualExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(NotExpressionNode n) {
		return (AbstractSyntaxTree.isNolife ? "NOT " : "!") + n.getOperand().accept(this);
	}

	@Override
	public String visit(OrExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	@Override
	public String visit(ParenthesisNode n) {
		return "("+n.getOperand().accept(this)+")";
	}

	@Override
	public String visit(PointerDereferenceNode n) {
		return "*" + n.getOperand().accept(this);
	}

	@Override
	public String visit(PointerTypeNode n) {
		return n.getBaseType().accept(this) + "*";
	}

	@Override
	public String visit(ProcedureDeclNode n) {
		return (AbstractSyntaxTree.isNolife ? "PROCEDURE " : "void ") + n.getName() + "(" + 
			n.getParamList().accept(this) + ")\n" + n.getBody().accept(this);

	}

	@Override
	public String visit(ProcedureInvocationNode n) {
		return (String) n.getInvocation().accept(this);
	}

	@Override
	public String visit(ProgramNode n) {
		return (AbstractSyntaxTree.isNolife ? "PROGRAM " + n.getName() + ";\n" : "int main(" +
					n.getParamList().accept(this) + ")\n") +
				n.getRecordDecls().accept(this) +
				n.getVariableDeclarations().accept(this) +
				n.getSubProgramDecls().accept(this) +
				n.getBody().accept(this);
	}

	@Override
	public String visit(ReadStatementNode n) {
		return "READ(" + n.getVariable().accept(this) + ")";
	}

	@Override
	public String visit(RecordDeclarationNode n) {
		return AbstractSyntaxTree.isNolife ? 
				"RECORD " + n.getRecordName() + " = \n" +
					n.getRecordElements().accept(this) +
					"END;\n" :
				"typedef struct " + n.getRecordName() + " {\n" +
					n.getRecordElements().accept(this) +
					"};\n";
	}

	@Override
	public String visit(RecordElementNode n) {
		String src = "";
		
		for (int i = 0; i < n.getNames().size()-1; i++)
			src += n.getNames().get(i) + ", ";
		
		return stmtPrefix + (AbstractSyntaxTree.isNolife ? 
				src + n.getNames().lastElement() + " : " + n.getType().accept(this) :
				n.getType().accept(this) + " " + src + n.getNames().lastElement());
	}

	@Override
	public String visit(RecordInstantiationNode n) {
		return "NEW " + n.getRecordName();
	}

	@Override
	public String visit(RecordReferenceNode n) {
		return n.getName() + (AbstractSyntaxTree.isNolife ? "." : "->") + n.getElement().accept(this);
	}

	@Override
	public String visit(RecordTypeNode n) {
		return n.getRecordName();
	}

	@Override
	public String visit(ReturnStatementNode n) {
		return (AbstractSyntaxTree.isNolife ? "RETURN " : "return") + n.getReturnExpression().accept(this);
	}

	@Override
	public String visit(ScalarReferenceNode n) {
		return n.getName();
	}

	@Override
	public String visit(StandardTypeNode n) {
		switch (n.getBasicType()) {
		case TypeTable.INT_TYPE:
			return AbstractSyntaxTree.isNolife ? "INTEGER" : "int";
		case TypeTable.FLOAT_TYPE:
			return AbstractSyntaxTree.isNolife ? "FLOAT" : "float";
		default:
			return AbstractSyntaxTree.isNolife ? "CHAR" : "char";
		}
	}

	@Override
	public String visit(StringNode n) {
		return (AbstractSyntaxTree.isNolife ? "'" : "\"") + n.getString() + 
				(AbstractSyntaxTree.isNolife ? "'" : "\"");
	}

	@Override
	public String visit(SubtractExpressionNode n) {
		return n.getLeftOperand().accept(this) + " " + n.getOperatorString() + " " + n.getRightOperand().accept(this);
	}

	private String getIdListSource(VariableDeclarationNode n) {
		String idSource = new String("");

		if (n.getVariableList().size() > 0) {
			idSource += (String) n.getVariableList().elementAt(0);
			for (int i = 1; i < n.getVariableList().size(); i++)
				idSource += ", " + (String) n.getVariableList().elementAt(i);
		}

		return idSource;
	}

	@Override
	public String visit(VariableDeclarationNode n) {
		return ((AbstractSyntaxTree.isNolife ? getIdListSource(n) + " : " + n.getType().accept(this)
				: n.getType().accept(this) + " " + getIdListSource(n)));
	}

	@Override
	public String visit(WhileStatementNode n) {
		return (AbstractSyntaxTree.isNolife ? "WHILE " + n.getWhileExpression().accept(this) + " DO\n"
				: "while (" + n.getWhileExpression().accept(this) + ")\n") + 
				 n.getControlledStatement().accept(this);
	}

	@Override
	public String visit(WriteStatementNode n) {
		return "WRITE ("+n.getWriteExpression().accept(this)+")";
	}

	@Override
	public String visit(ExpressionListNode n) {
		String src = "";
		
		for (int i = 0; i < n.size()-1; i++)
			src += n.getExpression(i).accept(this) + ", ";
		
		return src + (n.size() > 0 ? n.getExpression(n.size()-1).accept(this) : "");
	}

	@Override
	public String visit(CaseElementListNode n) {
		String src = "";
		for (int i = 0; i < n.size()-1; i++)
			src += n.getCaseElement(i).accept(this) + ";\n";
		
		return src + (n.size() > 0 ? n.getCaseElement(n.size()-1).accept(this) + "\n" + stmtPrefix + "END" : "");
	}

	@Override
	public String visit(VariableDeclarationListNode n) {
		String src = n.isParameterDecl() ? "" : "VAR\t";
		for (int i = 0; i < n.size()-1; i++)
			src += n.getVariableDecl(i).accept(this) + ";\n\t";
		
		return src + (n.size() > 0 ? n.getVariableDecl(n.size()-1).accept(this) +(n.isParameterDecl() ? "" : 
			";\n") : "");
	}

	@Override
	public String visit(RecordDeclListNode n) {
		String src = "";
		
		for (int i = 0; i < n.size(); i++)
			src += n.getRecordDeclaration(i).accept(this) + "\n";
		
		return src;
	}

	@Override
	public String visit(SubProgramDeclListNode n) {
		String src = "";
		
		for (int i = 0; i < n.size(); i++)
			src += n.getSubProgram(i).accept(this) + "\n";
		
		return src;
	}

	@Override
	public String visit(RecordElementListNode n) {
		String src = "";
		
		pushIndent();
		for (int i = 0; i < n.size()-1; i++)
			src += n.getRecordElement(i).accept(this) + ";\n";
		
		return src + (n.size() > 0 ? n.getRecordElement(n.size()-1).accept(this) : "") + popIndent() + "\n";
	}

}
