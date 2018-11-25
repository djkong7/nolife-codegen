/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class CaseElementListNode extends ASTNodeList {

	/**
	 * 
	 */
	public CaseElementListNode() {
		super();
	}
	
	public CaseElementListNode addCaseElement(CaseElementNode cen) {
		return (CaseElementListNode) addChild(cen);
	}

	public CaseElementNode getCaseElement(int index) {
		return (CaseElementNode) getChild(index);
	}
	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#accept(frontend.visitor.ASTVisitor)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

	@Override
	public CaseElementListNode addLineNumber(int lineNum) {
		return (CaseElementListNode) super.addLineNumber(lineNum);
	}

	/* (non-Javadoc)
	 * @see frontend.ast.ASTNode#getSource()
	 */
	@Override
	public String getSource() {
		return "";
	}

}
