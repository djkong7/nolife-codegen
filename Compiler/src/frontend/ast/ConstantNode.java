package frontend.ast;

import java.util.Vector;


/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Abstract class for a constant in a Nolife program</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class ConstantNode
    extends ExpressionNode {

	protected ConstantNode() {
		children = new Vector<ASTNode>();
	}
  /*
   * Need the address for lhs of assignment, read and
   * procedure and function calls
   * @return boolean
   */
  protected boolean addressNeeded() {
    return (parent instanceof InvocationNode);
  }
}
