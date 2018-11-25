package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Node holding a string constant</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class StringNode extends ConstantNode {
	private String string;

	public StringNode() {
		super();
	}
	
	public StringNode addString(String s) {
		string = s;
		return this;
	}

	@Override
	public StringNode addLineNumber(int lineNum) {
		return (StringNode) super.addLineNumber(lineNum);
	}

	public String getString() {
		return string;
	}

	@Override
	public String getSource() {
		return (AbstractSyntaxTree.isNolife ? "'" : "\"") + string + (AbstractSyntaxTree.isNolife ? "'" : "\"");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
