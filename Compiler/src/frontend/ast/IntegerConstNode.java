package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Node to represent an integer constant.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class IntegerConstNode extends ConstantNode {

	private int intValue; // the integer value

	/*
	 * Create a new integer constant node.
	 * 
	 * @param intValue int the value of the integer constant
	 */
	public IntegerConstNode() {
		super();
	}
	
	public IntegerConstNode addValue(int v) {
		intValue = v;
		return this;
	}

	@Override
	public IntegerConstNode addLineNumber(int lineNum) {
		return (IntegerConstNode) super.addLineNumber(lineNum);
	}

	public int getValue() {
		return intValue;
	}

	@Override
	public String getSource() {
		return Integer.toString(intValue);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
