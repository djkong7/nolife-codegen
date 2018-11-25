package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Node represent a floating-point constant.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class FloatConstNode extends ConstantNode {

	private float floatConst; // the floating point constant

	/*
	 * Create a node representing a floating-point constant.
	 */
	public FloatConstNode() {
		super();
	}
	
	public FloatConstNode addValue(float f) {
		floatConst = f;
		return this;
	}

	@Override
	public FloatConstNode addLineNumber(int lineNum) {
		return (FloatConstNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the floating-point constant value.
	 * 
	 * @return float
	 */
	public float getValue() {
		return floatConst;
	}

	@Override
	public String getSource() {
		return Float.toString(floatConst);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
