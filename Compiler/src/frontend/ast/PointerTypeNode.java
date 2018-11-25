/**
 * 
 */
package frontend.ast;

import java.util.Vector;

import frontend.utils.TypeTable;
import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class PointerTypeNode extends TypeNode {

	private static final int numChildren = 1;
	private static final int typeIndex = 0;
	/**
	 * 
	 */
	public PointerTypeNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public PointerTypeNode addBaseType(TypeNode tn) {
		return (PointerTypeNode) addChild(typeIndex,tn);
	}
	
	public TypeNode getBaseType() {
		return (TypeNode) getChild(typeIndex);
	}

	@Override
	public PointerTypeNode addLineNumber(int lineNum) {
		return (PointerTypeNode) super.addLineNumber(lineNum);
	}

/*
	 * (non-Javadoc)
	 * 
	 * @see frontend.ast.TypeNode#getSize()
	 */
	@Override
	public int getSize() {
		return TypeTable.POINTER_SIZE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see frontend.ast.TypeNode#toString()
	 */
	@Override
	public String toString() {
		return "pointer::" + getBaseType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see frontend.ast.ASTNode#getSource()
	 */
	@Override
	public String getSource() {
		return getBaseType().getSource() + "*";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
