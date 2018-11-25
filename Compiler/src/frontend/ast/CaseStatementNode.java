package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class CaseStatementNode extends StatementNode {

	private static final int numChildren = 2;
	private static final int expressionIndex = 0;
	private static final int caseElementIndex = 1;
	private int caseExitLabel;

	/*
	 * Create a case statement node
	 * 
	 */
	public CaseStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public CaseStatementNode addCaseExpression(ExpressionNode exn) {
		return (CaseStatementNode) addChild(expressionIndex,exn);
	}

	public CaseStatementNode addCaseElementList(CaseElementListNode celn) {
		return (CaseStatementNode) addChild(caseElementIndex,celn);
	}

	@Override
	public CaseStatementNode addLineNumber(int lineNum) {
		return (CaseStatementNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the case test expression
	 * 
	 * @return ExpressionNode
	 */
	public ExpressionNode getCaseExpression() {
		return (ExpressionNode) getChild(expressionIndex);
	}

	/*
	 * Return the set of case elements
	 * 
	 * @return Vector
	 */
	public CaseElementListNode getCaseElements() {
		return (CaseElementListNode) getChild(caseElementIndex);
	}

	public int getCaseExitLabel() {
		return caseExitLabel;
	}

	/**
	 * @param caseExitLabel the caseExitLabel to set
	 */
	public void setCaseExitLabel(int caseExitLabel) {
		this.caseExitLabel = caseExitLabel;
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? "CASE " + getCaseExpression().getSource() + " OF"
				: "switch (" + getCaseExpression().getSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
