package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a set of parameter declarations</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class VariableDeclarationNode extends ASTNode {

	private static final int numChildren = 1;
	private static final int typeIndex = 0;

	private Vector<String> idList;
	private Vector<Boolean> isInRegister;

	public VariableDeclarationNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
		isInRegister = new Vector<Boolean>();
	}

	public VariableDeclarationNode addIdList(Vector<String> idl) {
		idList = idl;
		return this;
	}

	public VariableDeclarationNode addType(TypeNode tn) {
		return (VariableDeclarationNode) addChild(typeIndex, tn);
	}

	@Override
	public VariableDeclarationNode addLineNumber(int lineNum) {
		return (VariableDeclarationNode) super.addLineNumber(lineNum);
	}

	public Vector<String> getVariableList() {
		return idList;
	}

	public TypeNode getType() {
		return (TypeNode) getChild(typeIndex);
	}

	@Override
	public String getSource() {
		return (AbstractSyntaxTree.isNolife ? getIdListSource() + " : " + getType().getSource()
				: getType().getSource() + " " + getIdListSource());
	}

	public String getIdListSource() {
		String idSource = new String("");

		if (idList.size() > 0) {
			idSource += idList.elementAt(0);
			for (int i = 1; i < idList.size(); i++)
				idSource += ", " + idList.elementAt(i);
		}

		return idSource;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

	@Override
	public boolean isParameterDecl() {
		return parent.isParameterDecl();
	}
	
	public void addIsInRegister(Boolean b) {
		isInRegister.add(b);
	}

	public Boolean getIsInRegister(int i) {
		return isInRegister.get(i);
	}


}

