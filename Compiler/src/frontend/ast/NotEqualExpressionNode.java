package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a not equal expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class NotEqualExpressionNode extends BinaryComparisonNode {

	/*
	 * Create a new not equal expression
	 */
	public NotEqualExpressionNode() {
		super();
	}

	@Override
	public String getOperatorString() {
		return AbstractSyntaxTree.isNolife ? "<>" : "!=";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
