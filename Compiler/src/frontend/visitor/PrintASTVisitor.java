package frontend.visitor;

import frontend.ast.*;

public class PrintASTVisitor implements ASTVisitor{
	
	private String src;
	private String tabStack;
	
	public PrintASTVisitor() {
		super();
		src = "";
		tabStack = "";
	}
	
	public String getSrc() {
		return src;
	}
	
	private void addToSrc(ASTNode astNode){
		src += tabStack + astNode.getClass().getSimpleName()+ ": " + astNode.getLabel() + ": " + astNode.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : astNode.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
	}

	@Override
	public Object visit(AddExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ArrayTypeNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(AssignmentStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseElementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CharacterDimensionNode n) {
		src += tabStack + n.getClass().getSimpleName()+ ": " + n.getLowerBound() + "," + n.getUpperBound() + ": " + n.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : n.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		return null;
	}

	@Override
	public Object visit(CharacterNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FloatConstNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FunctionDeclNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(IfStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(IntegerDimensionNode n) {
		src += tabStack + n.getClass().getSimpleName()+ ": " + n.getLowerBound() + "," + n.getUpperBound() + ": " + n.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : n.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		return null;
	}

	@Override
	public Object visit(InvocationNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
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
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NilNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ReadStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclarationNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ScalarReferenceNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(StandardTypeNode n) {
		src += tabStack + n.getClass().getSimpleName()+ ": " + n.getBasicType() + "," + n.toString() + ": " + n.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : n.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		return null;
	}

	@Override
	public Object visit(StringNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(SubtractExpressionNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationNode n) {
		// TODO Auto-generated method stub
		src += tabStack + n.getClass().getSimpleName()+ ": " + n.getIdListSource() + ": " + n.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : n.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
		return null;
	}

	@Override
	public Object visit(WhileStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		// TODO Auto-generated method stub
		addToSrc(n);
		return null;
	}

}
