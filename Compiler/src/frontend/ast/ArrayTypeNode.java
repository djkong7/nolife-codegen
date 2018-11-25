package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an array type</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ArrayTypeNode extends TypeNode {
	
	private static final int numChildren = 2;
	private static final int dimensionIndex = 0;
	private static final int baseTypeIndex = 1;
	
	public ArrayTypeNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public ArrayTypeNode addBaseType(TypeNode tn) {
		return (ArrayTypeNode) addChild(baseTypeIndex,tn);
	}
	
	public ArrayTypeNode addDimension(DimensionNode dn) {
		return (ArrayTypeNode) addChild(dimensionIndex,dn);
	}

	@Override
	public ArrayTypeNode addLineNumber(int lineNum) {
		return (ArrayTypeNode) super.addLineNumber(lineNum);
	}
	
	public TypeNode getBaseType() {
		return (TypeNode)getChild(baseTypeIndex);
	}
	
	public DimensionNode getDimension() {
		return (DimensionNode)getChild(dimensionIndex);
	}

	@Override
	public int getSize() {
		return getBaseType().getSize() * getDimension().getRangeLength();
	}
	
	
	@Override
	public String toString() {
		return "array::" + getDimension().toString() + "$$" + getBaseType().toString();
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? "ARRAY " + getDimension().getSource() + " OF " + getBaseType().getSource()
				: getBaseType().getSource() + "[" + getDimension().getSource() + "]";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
