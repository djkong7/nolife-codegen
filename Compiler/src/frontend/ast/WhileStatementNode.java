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
public class WhileStatementNode extends StatementNode {

	private static final int numChildren = 2;
	private static final int expressionIndex = 0;
	private static final int statementIndex = 1;
	/*
	 * Create a new while statment
	 * 
	 * @param getWhileExpression() ExpressionNode
	 * 
	 * @param getControlledStatement() StatementNode
	 */
	public WhileStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public WhileStatementNode addWhileExpression(ExpressionNode exn) {
		return (WhileStatementNode) addChild(expressionIndex,exn);
	}
	
	public WhileStatementNode addControlledStatement(StatementNode sn) {
		return (WhileStatementNode) addChild(statementIndex,sn);
	}

	@Override
	public WhileStatementNode addLineNumber(int lineNum) {
		return (WhileStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the while expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getWhileExpression() {
		return (ExpressionNode) getChild(expressionIndex);
	}

	/*
	 * Get the controlled statement
	 * 
	 * @return StatementNode
	 */
	public StatementNode getControlledStatement() {
		return (StatementNode) getChild(statementIndex);
	}

	@Override
	public String getSource() {
		return (AbstractSyntaxTree.isNolife ? "WHILE " + getWhileExpression().getSource() + " DO"
				: "while (" + getWhileExpression().getSource() + ")");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
