package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an add expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class AddExpressionNode extends BinaryExpressionNode {

	/*
	 * Create a new add expression.
	 * 
	 * @param getRightOperand() the right operand of an add
	 */
	
	public AddExpressionNode() {
		super();
	}
	

	@Override
	public String getOperatorString() {
		return "+";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
