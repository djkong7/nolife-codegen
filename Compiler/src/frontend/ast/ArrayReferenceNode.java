package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an array reference.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ArrayReferenceNode extends VariableReferenceNode {

	private static final int numChildren = 1;
	private static final int subscriptIndex = 0;
	private int lowerBound;

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public ArrayReferenceNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	public ArrayReferenceNode addSubscript(ExpressionNode subscript) {
		return (ArrayReferenceNode) addChild(subscriptIndex, subscript);
	}

	@Override
	public ArrayReferenceNode addName(String name) {
		return (ArrayReferenceNode) super.addName(name);
	}

	@Override
	public ArrayReferenceNode addLineNumber(int lineNum) {
		return (ArrayReferenceNode) super.addLineNumber(lineNum);
	}

	public ExpressionNode getSubscript() {
		return (ExpressionNode) getChild(subscriptIndex);
	}

	@Override
	public String getSource() {
		return getName() + "[" + getSubscript().getSource() + "]";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
