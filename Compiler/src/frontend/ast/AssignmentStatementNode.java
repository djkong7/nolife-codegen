package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents an assignment statement</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class AssignmentStatementNode extends StatementNode {

	private static final int numChildren = 2;
	private static final int lhsIndex = 0;
	private static final int rhsIndex = 1;
	
	public AssignmentStatementNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public AssignmentStatementNode addLhs(VariableReferenceNode vrn) {
		return (AssignmentStatementNode) addChild(lhsIndex,vrn);
	}
	
	public AssignmentStatementNode addRhs(ExpressionNode exn) {
		return (AssignmentStatementNode)addChild(rhsIndex,exn);
	}

	@Override
	public AssignmentStatementNode addLineNumber(int lineNum) {
		return (AssignmentStatementNode) super.addLineNumber(lineNum);
	}
	
	public VariableReferenceNode getLhs() {
		return (VariableReferenceNode) getChild(lhsIndex);
	}

	public ExpressionNode getRhs() {
		return (ExpressionNode) getChild(rhsIndex);
	}

	@Override
	public String getSource() {
		return getLhs().getSource() + (AbstractSyntaxTree.isNolife ? " := " : " = ") + getRhs().getSource();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
