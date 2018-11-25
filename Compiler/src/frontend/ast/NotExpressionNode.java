package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class NotExpressionNode extends UnaryExpressionNode {

	/*
	 * Create a node that represents a NOT expression.
	 * 
	 * @param notExpr ExpressionNode
	 */
	public NotExpressionNode() {
		super();
	}

	@Override
	public String getSource() {
		return (AbstractSyntaxTree.isNolife ? "NOT " : "!") + getOperand().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
