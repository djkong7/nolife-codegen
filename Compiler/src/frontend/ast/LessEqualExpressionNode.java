package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represent a less-than-or-equal expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class LessEqualExpressionNode extends BinaryComparisonNode {

	/*
	 * Create a new less-than-or-equal expression
	 * 
	 * @param rightOperand ExpressionNode the right operand
	 */
	public LessEqualExpressionNode() {
		super();
	}


	@Override
	public String getOperatorString() {
		return "<=";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
