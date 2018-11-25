package frontend.ast;

import java.util.Vector;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: An abstract class for array dimensions</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public abstract class DimensionNode
    extends ASTNode {
	
	protected DimensionNode() {
		children = new Vector<ASTNode>();
	}

  @Override
public abstract String toString();

  public abstract int getRangeLength();
}
