package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a set of integer array dimensions</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class IntegerDimensionNode extends DimensionNode {

	private int lowerBound;
	private int upperBound;

	public IntegerDimensionNode() {
		super();
	}
	
	public IntegerDimensionNode addLowerBound(int lwb) {
		lowerBound = lwb;
		return this;
	}
	
	public IntegerDimensionNode addUpperBound(int upb) {
		upperBound = upb;
		return this;
	}

	@Override
	public IntegerDimensionNode addLineNumber(int lineNum) {
		return (IntegerDimensionNode) super.addLineNumber(lineNum);
	}

	@Override
	public int getRangeLength() {
		return upperBound - lowerBound + 1;
	}

	public int getLowerBound() {
		return lowerBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}

	@Override
	public String toString() {
		return "%int%" + lowerBound + ".." + upperBound;
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? lowerBound + ".." + upperBound : "" + upperBound;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
