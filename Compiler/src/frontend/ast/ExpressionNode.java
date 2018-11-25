package frontend.ast;

import frontend.utils.TypeTable;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: An abstract class for expressions.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class ExpressionNode extends ASTNode {

	protected int tempRegisterId;
	protected int paramOffset = -1; // offset from fp to store temp
	// if this expression is used as an actual parameter

	protected boolean allowRegisterTemporary() {
		return (realType != TypeTable.FLOAT_TYPE && convertedType != TypeTable.FLOAT_TYPE
				&& !(parent instanceof InvocationNode));

	}

	public int getParamOffset() {
		return paramOffset;
	}

	public void setParamOffset(int paramOffset) {
		this.paramOffset = paramOffset;
	}

	public int getTempRegisterId() {
		return tempRegisterId;
	}

	public void setTempRegisterId(int tempRegisterId) {
		this.tempRegisterId = tempRegisterId;
	}
}
