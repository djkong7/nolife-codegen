/**
 * 
 */
package frontend.ast;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class SubProgramDeclListNode extends ASTNodeList {

	/**
	 * 
	 */
	public SubProgramDeclListNode() {
		super();
	}
	
	public SubProgramDeclListNode addSubProgram(SubProgramDeclNode spdn) {
		return (SubProgramDeclListNode) addChild(spdn);
	}

	@Override
	public SubProgramDeclListNode addLineNumber(int lineNum) {
		return (SubProgramDeclListNode) super.addLineNumber(lineNum);
	}

	public SubProgramDeclNode getSubProgram(int index) {
		return (SubProgramDeclNode)getChild(index);
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
