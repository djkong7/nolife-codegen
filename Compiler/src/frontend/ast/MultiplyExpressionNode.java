package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a multiplication operation</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class MultiplyExpressionNode extends BinaryExpressionNode {

	/*
	 * Create a new multiply expression.
	 */
	public MultiplyExpressionNode() {
		super();
	}

	@Override
	public String getOperatorString() {
		return "*";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
