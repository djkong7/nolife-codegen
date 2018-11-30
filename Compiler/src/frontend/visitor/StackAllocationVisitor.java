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
		if(offsetStack.peek() > 0) {
			offsetStack.push(offsetStack.pop() + size*4);
		} else {
			offsetStack.push(offsetStack.pop() - size*4);
		}
	}
	
	private void visitChildren(ASTNode n) {
		for(ASTNode child : n.getChildren()) {
			if(child != null)
				child.accept(this);
		}
	}

	@Override
	public Object visit(AddExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		visitChildren(n);
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
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		visitChildren(n);
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
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		visitChildren(n);
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
		
		offsetStack.push(8);
		n.getChild(0).accept(this);
		offsetStack.pop();
		
		n.getChild(1).accept(this);
		n.getChild(2).accept(this);
		n.getChild(3).accept(this);
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(IfStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(IntegerDimensionNode n) {
		//Only do this if it isn't a parameter
		if(!(offsetStack.peek() > 0)) {
			//This is one less than the actual size because
			//the extra is allocated in VarDeclNode
			addToOffsetStack((n.getUpperBound()-n.getLowerBound()));
		}
		
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
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(LessThanExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ModExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(NilNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		symTable = new HashMap<String, VariableMeta>();
		funcSymTables.put(n.getLabel(), symTable);
		offsetStack.push(-4);
		
		offsetStack.push(8);
		n.getChild(0).accept(this);
		offsetStack.pop();
		
		n.getChild(2).accept(this);
		n.getChild(3).accept(this);
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		visitChildren(n);
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
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ScalarReferenceNode n) {
		visitChildren(n);
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
			/*if(temp.offset > 0) {
				addToOffsetStack(-1);
			} else {*/
				addToOffsetStack(1);
			//}
			
		}
		
		
		
		return null;
	}

	@Override
	public Object visit(WhileStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		visitChildren(n);
		return null;
	}

}
