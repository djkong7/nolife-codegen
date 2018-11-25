/**
 * 
 */
package frontend.ast;

import java.util.Vector;

/**
 * @author carr
 *
 */
public abstract class UnaryExpressionNode extends ExpressionNode {

	private static final int numChildren = 1;
	private static final int operandIndex = 0;
	
	/**
	 * 
	 */
	public UnaryExpressionNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public UnaryExpressionNode addOperand(ExpressionNode op) {
		return (UnaryExpressionNode) addChild(operandIndex,op);
	}

	@Override
	public UnaryExpressionNode addLineNumber(int lineNum) {
		return (UnaryExpressionNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the getOperand() of this expression.
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getOperand() {
		return (ExpressionNode) getChild(operandIndex);
	}


}
