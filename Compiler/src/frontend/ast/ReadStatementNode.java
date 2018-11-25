package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a read statement</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ReadStatementNode extends StatementNode {

	private static final int numChildren = 1;
	private static final int varIndex = 0;
	/*
	 * Create a new read statement
	 */
	public ReadStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public ReadStatementNode addVariable(VariableReferenceNode vn) {
		return (ReadStatementNode) addChild(varIndex,vn);
	}

	@Override
	public ReadStatementNode addLineNumber(int lineNum) {
		return (ReadStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Get the getVariable() read into
	 * 
	 * @return VariableReferenceNode
	 */
	public VariableReferenceNode getVariable() {
		return (VariableReferenceNode) getChild(varIndex);
	}

	@Override
	public String getSource() {
		return "READ(" + getVariable().getSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
