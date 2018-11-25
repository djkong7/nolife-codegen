package frontend.ast;

import frontend.utils.SymbolTable;
import frontend.utils.TypeTable;
import frontend.visitor.TypeCheckVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Holds the root of the abstract syntax tree for a
 * Nolife program.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public final class AbstractSyntaxTree {

	public static boolean error = false;
	public static boolean isNolife = true;

	private ProgramNode root; // root of the abstract syntax tree

	SymbolTable symTable;

	/*
	 * Create the abstract syntax tree and set the root
	 * 
	 * @param root ProgramNode root node of an abstract syntax tree
	 */
	public AbstractSyntaxTree(ProgramNode root) {
		this.root = root;
		symTable = new SymbolTable();
		TypeTable.initTypeTable(100);
	}

	/*
	 * Return the root of the abstract syntax tree.
	 * 
	 * @return ASTNode
	 */
	public ASTNode getRoot() {
		return root;
	}

	public void typeCheck() {
		TypeCheckVisitor tcv = new TypeCheckVisitor()
				.addSymbolTable(symTable);
		
		root.accept(tcv);
	}

}
