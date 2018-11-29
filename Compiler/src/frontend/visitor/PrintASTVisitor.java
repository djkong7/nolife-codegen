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
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ArrayTypeNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(AssignmentStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseElementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		
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
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FloatConstNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FunctionDeclNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(IfStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		src += tabStack + n.getClass().getSimpleName()+ ": " + n.getValue() + ": " + n.getLineNumber() + "\n";
		tabStack += "\t";
		for (ASTNode node : n.getChildren()) {
			if(null != node)
				node.accept(this);
		}
		tabStack = tabStack.substring(0, tabStack.length() - 1);
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
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(LessThanExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ModExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NilNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ReadStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclarationNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ScalarReferenceNode n) {
		
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
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(SubtractExpressionNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationNode n) {
		
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
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		
		addToSrc(n);
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		
		addToSrc(n);
		return null;
	}

}
