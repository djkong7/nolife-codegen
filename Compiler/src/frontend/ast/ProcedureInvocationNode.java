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
public class ProcedureInvocationNode extends StatementNode {

	private static final int numChildren = 1;
	private static final int invocationIndex = 0;

	/*
	 * Create a new procedure getInvocation()
	 */
	public ProcedureInvocationNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public ProcedureInvocationNode addInvocation(InvocationNode in) {
		return (ProcedureInvocationNode) addChild(invocationIndex,in);
	}

	@Override
	public ProcedureInvocationNode addLineNumber(int lineNum) {
		return (ProcedureInvocationNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the getInvocation() node
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
