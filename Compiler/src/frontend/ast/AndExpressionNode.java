package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an and expression</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class AndExpressionNode extends BinaryExpressionNode {


	public AndExpressionNode() {
		super();
	}
	
	@Override
	public String getOperatorString() {
		return AbstractSyntaxTree.isNolife ? "AND" : "&&";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
