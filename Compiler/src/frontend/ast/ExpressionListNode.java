/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class ExpressionListNode extends ASTNodeList {

	/**
	 * 
	 */
	public ExpressionListNode() {
		super();
	}
	
	public ExpressionListNode addExpression(ExpressionNode exn) {
		return (ExpressionListNode) addChild(exn);
	}
	
	public ExpressionNode getExpression(int index) {
		return (ExpressionNode) getChild(index);
	}

	@Override
	public ExpressionListNode addLineNumber(int lineNum) {
		return (ExpressionListNode) super.addLineNumber(lineNum);
	}

	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#accept(frontend.visitor.ASTVisitor)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#getSource()
	 */
	@Override
	public String getSource() {
		return "";
	}
	
}
