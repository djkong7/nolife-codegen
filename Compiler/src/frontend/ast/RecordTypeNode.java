/**
 * 
 */
package frontend.ast;

import frontend.utils.TypeTable;
import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class RecordTypeNode extends TypeNode {

	/**
	 * 
	 */
	public RecordTypeNode() {
		super();
	}

	public RecordTypeNode addRecordName(String name) {
		return (RecordTypeNode) addLabel(name);
	}
	
	@Override
	public RecordTypeNode addLineNumber(int lineNum) {
		return (RecordTypeNode) super.addLineNumber(lineNum);
	}

	public String getRecordName() {
		return getLabel();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see frontend.ast.TypeNode#getSize()
	 */
	@Override
	public int getSize() {
		return TypeTable.POINTER_SIZE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see frontend.ast.TypeNode#toString()
	 */
	@Override
	public String toString() {
		return "record::" + getRecordName();
	}

	@Override
	public String getSource() {
		return getRecordName();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
