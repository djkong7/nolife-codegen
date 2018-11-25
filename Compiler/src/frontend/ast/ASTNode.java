package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Abstract class for all abstract syntax tree nodes.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class ASTNode {

	protected int realType;
	protected int convertedType;
	protected int lineNumber = -1;
	protected ASTNode parent;
	protected String label;
	protected Vector<ASTNode> children;

	public ASTNode addChild(ASTNode n) {
		n.setParent(this);
		children.add(n);
		return this;
	}

	public ASTNode addChild(int index, ASTNode n) {
		n.setParent(this);
		children.set(index, n);
		return this;
	}

	public ASTNode addLabel(String l) {
		label = l;
		return this;
	}

	public ASTNode addParent(ASTNode p) {
		parent = p;
		return this;
	}

	public ASTNode addRealType(int rt) {
		realType = rt;
		return this;
	}

	public ASTNode addConvertedType(int ct) {
		convertedType = ct;
		return this;
	}

	public ASTNode addLineNumber(int ln) {
		lineNumber = ln;
		return this;
	}

	public ASTNode getChild(int index) {
		return children.elementAt(index);
	}

	public Vector<ASTNode> getChildren() {
		return children;
	}

	public String getLabel() {
		return label;
	}

	@SuppressWarnings("rawtypes")
	public abstract Object accept(ASTVisitor v);

	public abstract String getSource();

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void setParent(ASTNode parent) {
		this.parent = parent;
	}

	public ASTNode getParent() {
		return parent;
	}

	public boolean isParameterDecl() {
		return false;
	}

	public SubProgramDeclNode getContainingSubProgram() {
		ASTNode node;
		for (node = this; node != null && !(node instanceof SubProgramDeclNode)
				&& !(node instanceof ProgramNode); node = node.parent)
			;

		return (SubProgramDeclNode) node;
	}

	public ProgramNode getProgramNode() {
		ASTNode node;
		for (node = this; 
				node != null && !(node instanceof ProgramNode); 
				node = node.parent);

		return (ProgramNode) node;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getRealType() {
		return realType;
	}

	public int getConvertedType() {
		return convertedType;
	}

	public boolean containsReturnStatement() {
		if (this instanceof ReturnStatementNode)
			return true;
		else {
			Vector<ASTNode> vec = children;

			boolean contains = false;
			for (int i = 0; i < vec.size() && !contains; i++) {
				ASTNode n = vec.get(i);
				contains = contains || (n == null ? false : n.containsReturnStatement());
			}

			return contains;
		}
	}

}
