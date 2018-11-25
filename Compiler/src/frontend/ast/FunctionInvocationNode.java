package frontend.ast;

import java.util.Vector;

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
public class FunctionInvocationNode extends ExpressionNode {

	private static final int numChildren = 1;
	private static final int invocationIndex = 0;

	/*
	 * Create a new function invocation
	 * 
	 * @param invocation InvocationNode
	 */
	public FunctionInvocationNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	public FunctionInvocationNode addInvocation(InvocationNode in) {
		return (FunctionInvocationNode) addChild(invocationIndex, in);
	}

	@Override
	public FunctionInvocationNode addLineNumber(int lineNum) {
		return (FunctionInvocationNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the invocation
	 * 
	 * @return InvocationNode
	 */
	public InvocationNode getInvocation() {
		return (InvocationNode) getChild(invocationIndex);
	}

	@Override
	public String getSource() {
		return getInvocation().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
