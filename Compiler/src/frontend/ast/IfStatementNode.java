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
public class IfStatementNode extends StatementNode {

	private static final int numChildren = 3;
	private static final int testIndex = 0;
	private static final int thenIndex = 1;
	private static final int elseIndex = 2;
	/*
	 */
	public IfStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	public IfStatementNode addTestExpression(ExpressionNode exn) {
		return (IfStatementNode) addChild(testIndex, exn);
	}

	public IfStatementNode addThenStatement(StatementNode sn) {
		return (IfStatementNode) addChild(thenIndex, sn);
	}

	public IfStatementNode addElseStatement(StatementNode sn) {
		return (IfStatementNode) addChild(elseIndex, sn);
	}

	@Override
	public IfStatementNode addLineNumber(int lineNum) {
		return (IfStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the test expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getTestExpression() {
		return (ExpressionNode) getChild(testIndex);
	}

	/*
	 * Get the then statement
	 * 
	 * @return StatementNode
	 */
	public StatementNode getThenStatement() {
		return (StatementNode) getChild(thenIndex);
	}

	/*
	 * Get the else statement
	 * 
	 * @return StatementNode
	 */
	public StatementNode getElseStatement() {
		return (StatementNode) getChild(elseIndex);
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? "IF " + getTestExpression().getSource() + " THEN"
				: "if (" + getTestExpression().getSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
