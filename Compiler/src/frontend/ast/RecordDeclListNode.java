/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class RecordDeclListNode extends ASTNodeList {

	/**
	 * 
	 */
	public RecordDeclListNode() {
		super();
	}
	
	public RecordDeclListNode addRecordDecl(RecordDeclarationNode rdn) {
		return (RecordDeclListNode) addChild(rdn);
	}
	
	@Override
	public RecordDeclListNode addLineNumber(int lineNum) {
		return (RecordDeclListNode) super.addLineNumber(lineNum);
	}

	public RecordDeclarationNode getRecordDeclaration(int index) {
		return (RecordDeclarationNode) getChild(index);
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
