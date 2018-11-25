package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a case element in a case statement</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class CaseElementNode extends ASTNode {

	private static final int numChildren = 2;
	private static final int caseListIndex = 0;
	private static final int statementIndex = 1;
	
	private int tempLocation;

	/*
	 * Create a node representing a case element
	 * 
	 * @param getCaseLabelList() Vector a set of case labels
	 * 
	 * @param stmtNode StatementNode the statement for this element
	 */
	public CaseElementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public CaseElementNode addCaseLabelList(ExpressionListNode eln) {
		return (CaseElementNode)addChild(caseListIndex,eln);
	}
	
	public CaseElementNode addStatement(StatementNode sn) {
		return (CaseElementNode)addChild(statementIndex,sn);
	}

	@Override
	public CaseElementNode addLineNumber(int lineNum) {
		return (CaseElementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the set of case labels
	 * 
	 * @return Vector
	 */
	public ExpressionListNode getCaseLabelList() {
		return (ExpressionListNode)getChild(caseListIndex);
	}

	/*
	 * Return the statement controlled by this element
	 * 
	 * @return StatementNode
	 */
	public StatementNode getStatementNode() {
		return (StatementNode)getChild(statementIndex);
	}

	public int getTempLocation() {
		return tempLocation;
	}

	@Override
	public String getSource() {

		String labelSource = new String("");

		if (AbstractSyntaxTree.isNolife) {
			for (int i = 0; i < getCaseLabelList().size(); i++)
				labelSource += getCaseLabelList().getChild(i).getSource();

			return labelSource + ":";
		} else {
			for (int i = 0; i < getCaseLabelList().size(); i++)
				labelSource += "case " + getCaseLabelList().getChild(i).getSource() + ": \n";

			return labelSource;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
