package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * <p>
 * Title: Nolife Compiler
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class CharacterDimensionNode extends DimensionNode {

	private char lowerBound;
	private char upperBound;

	public CharacterDimensionNode() {
		super();
	}

	public CharacterDimensionNode addLowerBound(char lwb) {
		lowerBound = lwb;
		return this;
	}

	public CharacterDimensionNode addUpperBound(char upb) {
		upperBound = upb;
		return this;
	}

	@Override
	public CharacterDimensionNode addLineNumber(int lineNum) {
		return (CharacterDimensionNode) super.addLineNumber(lineNum);
	}

	@Override
	public int getRangeLength() {
		return (upperBound) - (lowerBound) + 1;
	}

	public char getLowerBound() {
		return lowerBound;
	}
	
	public char getUpperBound() {
		return upperBound;
	}

	@Override
	public String toString() {
		return "%char%" + lowerBound + ".." + upperBound;
	}

	@Override
	public String getSource() {
		return "'" + lowerBound + "'..'" + upperBound + "'";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
