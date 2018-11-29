package frontend.visitor;

import java.util.HashMap;
import java.util.Stack;

import frontend.ast.*;
import frontend.utils.*;

public class StackAllocationVisitor implements ASTVisitor{
	
	private HashMap<String,HashMap<String, VariableMeta>> funcSymTables;
	private HashMap<String, VariableMeta> symTable;
	//private Stack<HashMap<String, VariableMeta>> symTableStack;
	private Stack<Integer> offsetStack;
	
	public StackAllocationVisitor() {
		//symTableStack = new Stack<HashMap<String, VariableMeta>>();
		funcSymTables = new HashMap<String,HashMap<String, VariableMeta>>();
		offsetStack = new Stack<Integer>();
	}
	
	private void addToOffsetStack(int size) {
		offsetStack.push(offsetStack.pop() - size*4);
	}
	
	private void visitChildren(ASTNode n) {
		for(ASTNode child : n.getChildren()) {
			if(child != null)
				child.accept(this);
		}
	}

	@Override
	public Object visit(AddExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArrayTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(AssignmentStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CaseElementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CharacterDimensionNode n) {
		// This is one less than the actual size because
		// the extra is allocated in VarDeclNode
		addToOffsetStack((n.getUpperBound() - n.getLowerBound()));
		for (VariableMeta var : symTable.values()) {
			if (var.type == -1) {
				var.intMin = n.getLowerBound();
				var.intMax = n.getUpperBound();
			}
		}
		return null;
	}

	@Override
	public Object visit(CharacterNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FloatConstNode n) {
		VariableMeta temp = new VariableMeta();
		temp.floatVal = n.getValue();
		temp.isFloat = true;
		symTable.put(Float.toString(n.getValue()), temp);
		return null;
	}

	@Override
	public Object visit(FunctionDeclNode n) {
		symTable = new HashMap<String, VariableMeta>();
		funcSymTables.put(n.getLabel(), symTable);
		offsetStack.push(-4);
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntegerDimensionNode n) {
		//This is one less than the actual size because
		//the extra is allocated in VarDeclNode
		addToOffsetStack((n.getUpperBound()-n.getLowerBound()));
		for(VariableMeta var : symTable.values()) {
			if(var.type == -1) {
				var.intMin = n.getLowerBound();
				var.intMax = n.getUpperBound();
			}
		}
		return null;
	}

	@Override
	public Object visit(InvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessThanExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ModExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NilNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		symTable = new HashMap<String, VariableMeta>();
		funcSymTables.put(n.getLabel(), symTable);
		offsetStack.push(-4);
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		symTable = new HashMap<String, VariableMeta>();
		funcSymTables.put("global", symTable);
		offsetStack.push(-4);
		visitChildren(n);
		return funcSymTables;
	}

	@Override
	public Object visit(ReadStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclarationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ScalarReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StandardTypeNode n) {
		for(VariableMeta var : symTable.values()) {
			if(var.type == -1) {
				var.type = n.getBasicType();
			}
		}
		return null;
	}

	@Override
	public Object visit(StringNode n) {
		VariableMeta temp = new VariableMeta();
		temp.isString = true;
		temp.stringVal = n.getString();
		symTable.put(n.getString(), temp);
		return null;
	}

	@Override
	public Object visit(SubtractExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationNode n) {
		for(String var : n.getVariableList()) {
			VariableMeta temp = new VariableMeta();
			symTable.put(var, temp);
			visitChildren(n);
			
			//Set offset value
			temp.offset = offsetStack.peek();
			addToOffsetStack(1);

			
			
			
		}
		
		
		
		return null;
	}

	@Override
	public Object visit(WhileStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

}
