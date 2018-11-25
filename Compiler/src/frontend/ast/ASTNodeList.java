/**
 * 
 */
package frontend.ast;

import java.util.Vector;

/**
 * @author carr
 *
 */
public abstract class ASTNodeList extends ASTNode {

	/**
	 * 
	 */
	public ASTNodeList() {
		children = new Vector<ASTNode>();
	}
	
	public int size() {
		return children.size();
	}
	
	public void remove(int index) {
		children.remove(index);
	}

}
