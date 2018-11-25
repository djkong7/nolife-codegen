package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a compound statement</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class CompoundStatementNode extends StatementNode {


	public CompoundStatementNode() {
		children = new Vector<ASTNode>();
	}
	
	public CompoundStatementNode addStatement(StatementNode sn) {
		return (CompoundStatementNode) addChild(sn);
	}
	
	public StatementNode getStatement(int index) {
		return (StatementNode) getChild(index);
	}

	public Vector<ASTNode> getStatementList() {
		return children;
	}

	@Override
	public CompoundStatementNode addLineNumber(int lineNum) {
		return (CompoundStatementNode) super.addLineNumber(lineNum);
	}

	public StatementNode getLastStatement() {
		return (StatementNode) getStatementList().lastElement();
	}

	@Override
	public String getSource() {
		return "";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
	
	public int size() {
		return children.size();
	}
}
