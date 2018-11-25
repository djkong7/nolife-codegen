package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a MOD expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class DivExpressionNode extends BinaryExpressionNode {

	/*
	 * Create a new div expression
	 */
	public DivExpressionNode() {
		super();
	}

	@Override
	public String getOperatorString() {
		return "/";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
