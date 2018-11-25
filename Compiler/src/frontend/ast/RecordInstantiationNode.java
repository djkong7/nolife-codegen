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
public class RecordInstantiationNode extends ExpressionNode {

	private int numBytesToAllocate;
	
	/**
	 * 
	 */
	public RecordInstantiationNode() {
		children = new Vector<ASTNode>();
	}
	
	public RecordInstantiationNode addRecordName(String name) {
		return (RecordInstantiationNode) addLabel(name);
	}
	
	@Override
	public RecordInstantiationNode addLineNumber(int lineNum) {
		return (RecordInstantiationNode) super.addLineNumber(lineNum);
	}

	public String getRecordName() {
		return getLabel();
	}
	
	@Override
	public String getSource() {
		return "NEW " + getRecordName();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

	public int getNumBytesToAllocate() {
		return numBytesToAllocate;
	}

	public void setNumBytesToAllocate(int numBytesToAllocate) {
		this.numBytesToAllocate = numBytesToAllocate;
	}
}
