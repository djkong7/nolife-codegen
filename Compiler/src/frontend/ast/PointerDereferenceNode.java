/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class PointerDereferenceNode extends UnaryExpressionNode {

	/**
	 * 
	 */
	public PointerDereferenceNode() {
		super();
	}

	@Override
	public String getSource() {
		return "*" + getOperand().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
