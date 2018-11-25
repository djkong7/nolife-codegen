package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: A node to reperesent parentheses.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ParenthesisNode extends UnaryExpressionNode {

	public ParenthesisNode() {
		super();
	}

	@Override
	public String getSource() {
		return "(" + getOperand().getSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
