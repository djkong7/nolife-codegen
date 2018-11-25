package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an or expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class OrExpressionNode extends BinaryExpressionNode {

	/*
	 * Create a new or expression
	 * 
	 */
	public OrExpressionNode() {
		super();
	}

	@Override
	public String getOperatorString() {
		return AbstractSyntaxTree.isNolife ? "OR" : "||";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
