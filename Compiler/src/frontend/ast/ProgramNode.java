package frontend.ast;

import java.util.Vector;

import frontend.utils.SymbolTable;
import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a Nolife program</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class ProgramNode extends SubProgramDeclNode {

	private static final int numChildren = SubProgramDeclNode.numChildren + 2;
	private static final int recordIndex = SubProgramDeclNode.numChildren;
	private static final int subProgramIndex = SubProgramDeclNode.numChildren + 1;
	private Vector<Float> floatConsts = new Vector<Float>();
	private Vector<String> stringConsts = new Vector<String>();

	private static int labelID = 0;

	public ProgramNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	@Override
	public ProgramNode addName(String name) {
		return (ProgramNode)super.addName(name);
	}
	
	@Override
	public ProgramNode addParamList(VariableDeclarationListNode vdln) {
		return (ProgramNode)super.addParamList(vdln);
	}
	
	@Override
	public ProgramNode addReturnType(TypeNode tn) {
		return (ProgramNode)super.addReturnType(tn);
	}
	
	@Override
	public ProgramNode addVariableDeclList(VariableDeclarationListNode vdln) {
		return (ProgramNode)super.addVariableDeclList(vdln);
	}
	
	@Override
	public ProgramNode addBody(CompoundStatementNode csn) {
		return (ProgramNode)super.addBody(csn);
	}
	
	public ProgramNode addRecordDeclList(RecordDeclListNode rdln) {
		return (ProgramNode) addChild(recordIndex,rdln);
	}

	public ProgramNode addSubProgramDeclList(SubProgramDeclListNode spdln) {
		return (ProgramNode) addChild(subProgramIndex,spdln);
	}
	
	@Override
	public ProgramNode addLineNumber(int lineNum) {
		return (ProgramNode) super.addLineNumber(lineNum);
	}

	@Override
	public String getName() {
		return getLabel() + "$$_main";
	}

	public RecordDeclListNode getRecordDecls() {
		return (RecordDeclListNode) getChild(recordIndex);
	}
	
	public SubProgramDeclListNode getSubProgramDecls() {
		return (SubProgramDeclListNode) getChild(subProgramIndex);
	}
	
	@Override
	public void addToSymTable(SymbolTable symTable) {

	}

	public int getFloatConstIndex(float val) {
		Float floatObj = new Float(val);
		return floatConsts.indexOf(floatObj);
	}

	public String getFloatConstLabel(float val) {
		return ".float_const_" + getFloatConstIndex(val);
	}

	public int getStringConstIndex(String val) {
		return stringConsts.indexOf(val);
	}

	public String getStringConstLabel(String val) {
		return ".string_const_" + getStringConstIndex(val);
	}

	public void addFloatConst(float val) {
		Float floatConst = new Float(val);

		if (floatConsts.indexOf(floatConst) == -1)
			floatConsts.add(floatConst);
	}

	public void addStringConst(String val) {
		if (stringConsts.indexOf(val) == -1)
			stringConsts.add(val);
	}

	public static int getNextLabel() {
		return labelID++;
	}

	public static String genLabelString(int label) {
		return ".L" + label;
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? "PROGRAM " + getName() + ";" : "int main(" + getParameterSource() + ")";
	}

	/**
	 * @return the floatConsts
	 */
	public Vector<Float> getFloatConsts() {
		return floatConsts;
	}

	/**
	 * @return the stringConsts
	 */
	public Vector<String> getStringConsts() {
		return stringConsts;
	}

	@Override
	public Object accept(@SuppressWarnings("rawtypes") ASTVisitor v) {
		return v.visit(this);
	}
}
