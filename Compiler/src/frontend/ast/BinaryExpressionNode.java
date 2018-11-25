package frontend.ast;

import java.util.Vector;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: An abstract class for a binary expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class BinaryExpressionNode extends ExpressionNode {

	private static final int numChildren = 2;
	private static final int leftOperandIndex = 0;
	private static final int rightOperandIndex = 1;

	public BinaryExpressionNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	/*
	 * Set the left operand of this binary expression.
	 * 
	 * @param leftOperand ExpressionNode
	 */
	public void setLeftOperand(ExpressionNode leftOperand) {
		children.set(leftOperandIndex, leftOperand);
	}

	public BinaryExpressionNode addLeftOperand(ExpressionNode lo) {
		return (BinaryExpressionNode) addChild(leftOperandIndex, lo);
	}

	public BinaryExpressionNode addRightOperand(ExpressionNode ro) {
		return (BinaryExpressionNode) addChild(rightOperandIndex, ro);
	}

	@Override
	public BinaryExpressionNode addLineNumber(int lineNum) {
		return (BinaryExpressionNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the left operand of this expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getLeftOperand() {
		return (ExpressionNode) getChild(leftOperandIndex);
	}

	/*
	 * Return the right operand of this expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getRightOperand() {
		return (ExpressionNode) getChild(rightOperandIndex);
	}

	public abstract String getOperatorString();

	@Override
	public String getSource() {
		return getLeftOperand().getSource() + " " + getOperatorString() + " " + getRightOperand().getSource();
	}

}
