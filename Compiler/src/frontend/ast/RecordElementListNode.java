/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class RecordElementListNode extends ASTNodeList {

	/**
	 * 
	 */
	public RecordElementListNode() {
		super();
	}
	
	public RecordElementListNode addRecordElement(RecordElementNode ren) {
		return (RecordElementListNode) addChild(ren);
	}
	
	@Override
	public RecordElementListNode addLineNumber(int lineNum) {
		return (RecordElementListNode) super.addLineNumber(lineNum);
	}

	public RecordElementNode getRecordElement(int index) {
		return (RecordElementNode) getChild(index);
	}

	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#accept(frontend.visitor.ASTVisitor)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#getSource()
	 */
	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
