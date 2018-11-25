package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a less-than expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class LessThanExpressionNode extends BinaryComparisonNode {

	/*
	 * Create a new less-than expression
	 */
	public LessThanExpressionNode() {
		super();
	}

	@Override
	public String getOperatorString() {
		return "<";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
