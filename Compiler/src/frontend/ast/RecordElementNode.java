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
public class RecordElementNode extends ASTNode {

	private static final int numChildren = 1;
	private static final int typeIndex = 0;
	private Vector<String> names;

	/**
	 * 
	 */
	public RecordElementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public RecordElementNode addNames(Vector<String> names) {
		this.names = names;
		return this;
	}

	public RecordElementNode addTypeNode(TypeNode tn) {
		return (RecordElementNode) addChild(typeIndex,tn);
	}

	@Override
	public RecordElementNode addLineNumber(int lineNum) {
		return (RecordElementNode) super.addLineNumber(lineNum);
	}

	public Vector<String> getNames() {
		return names;
	}

	public TypeNode getType() {
		return (TypeNode) getChild(typeIndex);
	}

	@Override
	public String getSource() {
		return "";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
