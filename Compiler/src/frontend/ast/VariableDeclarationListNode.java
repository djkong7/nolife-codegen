/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class VariableDeclarationListNode extends ASTNodeList {

	/**
	 * 
	 */
	public VariableDeclarationListNode() {
		super();
	}
	
	public VariableDeclarationListNode addVariableDeclaration(VariableDeclarationNode vdn) {
		return (VariableDeclarationListNode) addChild(vdn);
	}
	
	public VariableDeclarationNode getVariableDecl(int index) {
		return (VariableDeclarationNode) getChild(index);
	}

	@Override
	public VariableDeclarationListNode addLineNumber(int lineNum) {
		return (VariableDeclarationListNode) super.addLineNumber(lineNum);
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

	@Override
	public boolean isParameterDecl() {
		return ((SubProgramDeclNode)parent).getParamList() == this;
	}
	
}
