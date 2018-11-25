package frontend.ast;

import frontend.utils.SymbolTable;
import frontend.utils.SymbolTableEntry;
import frontend.utils.TypeTable;
import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Represents a function declaration</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class FunctionDeclNode extends SubProgramDeclNode {

	public FunctionDeclNode() {
		super();
	}
	
	@Override
	public void addToSymTable(SymbolTable symTable) {
		SymbolTableEntry entry = symTable.add(getName());

		if (entry == null) {
			System.err.println("Line " + lineNumber + ": Redeclaration of variable: " + getName());
			AbstractSyntaxTree.error = true;
			realType = TypeTable.ANY_TYPE;
		} else {
			int typeVal = TypeTable.getTypeVal(toString());
			entry.setDataType(typeVal);
			realType = typeVal;
		}
	}

	@Override
	public String toString() {
		return "func::" + buildParameterTypeString() + "->" + getReturnType().toString();
	}

	@Override
	public String getSource() {
		return AbstractSyntaxTree.isNolife
				? "FUNCTION " + getName() + "(" + getParameterSource() + ") : " + getReturnType().getSource()
				: getReturnType().getSource() + " " + getName() + "(" + getParameterSource() + ")";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
