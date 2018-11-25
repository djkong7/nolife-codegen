package frontend.ast;

import java.util.Vector;

import frontend.utils.TypeTable;
import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a procedure or function invocation</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class InvocationNode extends ExpressionNode {

	private static final int numChildren = 1;
	private static final int paramIndex = 0;

	public InvocationNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public InvocationNode addName(String name) {
		return (InvocationNode) addLabel(name);
	}
	
	public InvocationNode addActualParameters(ExpressionListNode eln) {
		return (InvocationNode) addChild(paramIndex, eln);
	}

	@Override
	public InvocationNode addLineNumber(int lineNum) {
		return (InvocationNode) super.addLineNumber(lineNum);
	}

	public String getName() {
		return getLabel();
	}

	public ExpressionListNode getActualParameters() {
		return (ExpressionListNode) getChild(paramIndex);
	}

	private String buildParameterTypeString() {
		String typeString = new String();

		for (int i = 0; i < getActualParameters().size(); i++) {
			ExpressionNode expr = (ExpressionNode) getActualParameters().getChild(i);
			typeString += ("&" + TypeTable.getTypeString(expr.convertedType));
		}

		if (typeString.length() > 1)
			typeString = typeString.substring(1);

		return typeString;
	}

	@Override
	public String toString() {
		return "func::" + buildParameterTypeString() + "->";
	}

	@Override
	public String getSource() {
		return getName() + "(" + getParameterSource() + ")";
	}

	public String getParameterSource() {
		String paramSource = new String("");

		if (getActualParameters().size() > 0) {
			paramSource += getActualParameters().getChild(0).getSource();
			for (int i = 1; i < getActualParameters().size(); i++)
				paramSource += (", " + getActualParameters().getChild(i).getSource());
		}

		return paramSource;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
