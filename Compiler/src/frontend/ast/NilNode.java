/**
 * 
 */
package frontend.ast;

import java.util.Vector;

import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class NilNode extends ConstantNode {

	/**
	 * 
	 */
	public NilNode() {
		children = new Vector<ASTNode>();
	}

	@Override
	public NilNode addLineNumber(int lineNum) {
		return (NilNode) super.addLineNumber(lineNum);
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife ? "NIL" : "NULL";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
