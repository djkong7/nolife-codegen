/**
 * 
 */
package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class RecordReferenceNode extends VariableReferenceNode {

	private static final int numChildren = 1;
	private static final int elementIndex = 0;
	/**
	 * 
	 */
	public RecordReferenceNode() {
		super();
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public RecordReferenceNode addElement(VariableReferenceNode vrn) {
		return (RecordReferenceNode) addChild(elementIndex,vrn);
	}
	
	@Override
	public RecordReferenceNode addLineNumber(int lineNum) {
		return (RecordReferenceNode) super.addLineNumber(lineNum);
	}

	@Override
	public RecordReferenceNode addName(String name) {
		return (RecordReferenceNode) super.addName(name);
	}
	
	public VariableReferenceNode getElement() {
		return (VariableReferenceNode) getChild(elementIndex);
	}

	@Override
	public String getSource() {
		return getName() + (AbstractSyntaxTree.isNolife ? "." : "->") + getElement().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
