package frontend.ast;

import java.util.Vector;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: An abstract node for a variable reference.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class VariableReferenceNode extends ExpressionNode {

	protected int stackOffset;
	protected int nestingLevel;
	
	public int getNestingLevel() {
		return nestingLevel;
	}

	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel = nestingLevel;
	}

	protected boolean isParameter = false;
	protected boolean isInRegister = false;
	protected int virtualRegisterId;

	protected VariableReferenceNode() {
		children = new Vector<ASTNode>();
	}

	@Override
	public VariableReferenceNode addLineNumber(int lineNum) {
		return (VariableReferenceNode) super.addLineNumber(lineNum);
	}

	/*
	 * Need the address for lhs of assignment, read and procedure and function calls
	 * 
	 * @return boolean
	 */
	public boolean addressNeeded() {
		return ((parent instanceof AssignmentStatementNode && ((AssignmentStatementNode) parent).getLhs() == this)
				|| parent instanceof ReadStatementNode || parent instanceof InvocationNode);

	}

	public boolean partOfRecordReference() {
		return (parent instanceof RecordReferenceNode || (parent instanceof VariableReferenceNode
				&& ((VariableReferenceNode) parent).partOfRecordReference()));
	}

	public VariableReferenceNode addName(String name) {
		return (VariableReferenceNode) addLabel(name);
	}

	public String getName() {
		return getLabel();
	}

	public int getVirtualRegisterId() {
		return virtualRegisterId;
	}

	public void setVirtualRegisterId(int virtualRegisterId) {
		this.virtualRegisterId = virtualRegisterId;
	}

	public boolean isParameter() {
		return isParameter;
	}

	public void setParameter(boolean isParameter) {
		this.isParameter = isParameter;
	}

	public int getStackOffset() {
		return stackOffset;
	}

	public void setStackOffset(int stackOffset) {
		this.stackOffset = stackOffset;
	}

	public boolean isInRegister() {
		return isInRegister;
	}

	public void setInRegister(boolean isInRegister) {
		this.isInRegister = isInRegister;
	}
}
