package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an equal expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class EqualExpressionNode
extends BinaryComparisonNode {

	/*
	 * Create a new equal expression.
	 */
	public EqualExpressionNode() {
		super();
	}
	  
	  @Override
	public String getOperatorString() {
		  return AbstractSyntaxTree.isNolife ? "=" : "==";
	  }

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
