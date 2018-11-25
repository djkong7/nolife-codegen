package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ReturnStatementNode extends StatementNode {

	private static final int numChildren = 1;
	private static final int expressionIndex = 0;
	
	/*
	 * Create a new return statement
	 * 
	 * @param getReturnExpression() ExpressionNode
	 */
	public ReturnStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public ReturnStatementNode addReturnExpression(ExpressionNode en) {
		return (ReturnStatementNode) addChild(expressionIndex,en);
	}

	@Override
	public ReturnStatementNode addLineNumber(int lineNum) {
		return (ReturnStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the return expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getReturnExpression() {
		return (ExpressionNode) getChild(expressionIndex);
	}

	@Override
	public String getSource() {
		return (AbstractSyntaxTree.isNolife ? "RETURN " : "return") + getReturnExpression().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
