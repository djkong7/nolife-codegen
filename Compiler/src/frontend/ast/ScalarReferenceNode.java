package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: A node to represent a scalar variable reference.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ScalarReferenceNode extends VariableReferenceNode {

	/*
	 * Create a new node for a scalar variable reference
	 * 
	 * @param name String the name of the scale variable
	 */
	public ScalarReferenceNode() {
		super();
	}

	@Override
	public ScalarReferenceNode addName(String name) {
		return (ScalarReferenceNode) super.addName(name);
	}
	
	@Override
	public String getSource() {
		return getName();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
