package frontend.ast;

import java.util.BitSet;
import java.util.Vector;

import frontend.utils.SymbolTable;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: An abstract class for subprogram declarations</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class SubProgramDeclNode extends ASTNode {

	protected int localSize = 0;
	protected int parameterSize = 0;
	protected int nestingLevel;
	protected BitSet stackLocationReserved = new BitSet();
	protected BitSet registerReserved = new BitSet();

	protected int paramSpace = 0;

	protected boolean containsFunctionCalls = false;

	protected static final int numChildren = 4;
	protected static final int paramIndex = 0;
	protected static final int typeIndex = 1;
	protected static final int varIndex = 2;
	protected static final int bodyIndex = 3;

	protected SubProgramDeclNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}

	public SubProgramDeclNode addName(String name) {
		return (SubProgramDeclNode) addLabel(name);
	}

	public SubProgramDeclNode addParamList(VariableDeclarationListNode iln) {
		return (SubProgramDeclNode) addChild(paramIndex, iln);
	}

	public SubProgramDeclNode addReturnType(TypeNode tn) {
		return (SubProgramDeclNode) addChild(typeIndex, tn);
	}

	public SubProgramDeclNode addVariableDeclList(VariableDeclarationListNode iln) {
		return (SubProgramDeclNode) addChild(varIndex, iln);
	}

	public SubProgramDeclNode addBody(CompoundStatementNode csn) {
		return (SubProgramDeclNode) addChild(bodyIndex, csn);
	}

	@Override
	public SubProgramDeclNode addLineNumber(int lineNum) {
		return (SubProgramDeclNode) super.addLineNumber(lineNum);
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public void setContainsFunctionCalls() {
		containsFunctionCalls = true;
	}

	public boolean subProgramContainsFunctionCalls() {
		return containsFunctionCalls;
	}

	public abstract void addToSymTable(SymbolTable symTable);

	public String buildParameterTypeString() {
		String typeString = new String();

		for (int i = 0; i < getParamList().size(); i++) {
			VariableDeclarationNode decl = getParamList().getVariableDecl(i);
			for (int j = 0; j < decl.getVariableList().size(); j++)
				typeString += ("&" + decl.getType().toString());
		}

		if (typeString.length() > 1)
			typeString = typeString.substring(1);

		return typeString;
	}

	public String getName() {
		return getLabel();
	}

	public CompoundStatementNode getBody() {
		return (CompoundStatementNode) getChild(bodyIndex);
	}

	public VariableDeclarationListNode getParamList() {
		return (VariableDeclarationListNode) getChild(paramIndex);
	}

	public VariableDeclarationListNode getVariableDeclarations() {
		return (VariableDeclarationListNode) getChild(varIndex);
	}

	public TypeNode getReturnType() {
		return (TypeNode) getChild(typeIndex);
	}

	public boolean isLastStatement(StatementNode stmt) {
		return (stmt == getBody().getLastStatement());
	}

	public void updateParamSpace(int bytes) {
		if (bytes > paramSpace)
			paramSpace = bytes;
	}

	protected String getParameterSource() {
		String paramSource = new String("");

		if (getParamList().size() > 0) {
			paramSource += getParamList().getVariableDecl(0).getSource();
			for (int i = 1; i < getParamList().size(); i++)
				paramSource += ((AbstractSyntaxTree.isNolife ? "; " : ", ")
						+ getParamList().getVariableDecl(i).getSource());
		}

		return paramSource;
	}

	public int getLocalSize() {
		return localSize;
	}

	public void setLocalSize(int localSize) {
		this.localSize = localSize;
	}

	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel = nestingLevel;
	}

	public int getParamSpace() {
		return paramSpace;
	}

	public void setParamSpace(int paramSpace) {
		this.paramSpace = paramSpace;
	}

	public int getParameterSize() {
		return parameterSize;
	}

	public void setParameterSize(int parameterSize) {
		this.parameterSize = parameterSize;
	}


}
