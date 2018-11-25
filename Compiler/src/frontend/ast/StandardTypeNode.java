package frontend.ast;

import frontend.utils.TypeTable;
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
public class StandardTypeNode extends TypeNode {

	int basicType;

	public StandardTypeNode() {
		super();
	}
	
	public StandardTypeNode addBasicType(int bt) {
		basicType = bt;
		return this;
	}

	@Override
	public StandardTypeNode addLineNumber(int lineNum) {
		return (StandardTypeNode) super.addLineNumber(lineNum);
	}

	public int getBasicType() {
		return basicType;
	}

	@Override
	public int getSize() {
		return TypeTable.getDataSize(basicType);
	}

	@Override
	public String toString() {
		return TypeTable.getBasicTypeString(basicType);
	}

	@Override
	public String getSource() {
		return TypeTable.getBasicTypeString(basicType);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
