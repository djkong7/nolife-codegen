package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a write statement</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class WriteStatementNode extends StatementNode {

	private static final int numChildren = 1;
	private static final int expressionIndex = 0;

	/*
	 * Create a write statement
	 */
	public WriteStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	public WriteStatementNode addWriteExpression(ExpressionNode exn) {
		return (WriteStatementNode) addChild(expressionIndex, exn);
	}

	@Override
	public WriteStatementNode addLineNumber(int lineNum) {
		return (WriteStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the string or expression written
	 * 
	 * @return ASTNode
	 */
	public ExpressionNode getWriteExpression() {
		return (ExpressionNode) getChild(expressionIndex);
	}

	@Override
	public String getSource() {
		return "WRITE (" + getWriteExpression().getSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
