package frontend;

import java.io.FileNotFoundException;
import java.util.HashMap;

import frontend.ast.*;
import frontend.utils.VariableMeta;
import frontend.visitor.CodeGenVisitor;
import frontend.visitor.PrintASTVisitor;
import frontend.visitor.SourceVisitor;
import frontend.visitor.StackAllocationVisitor;
import frontend.visitor.TypeCheckVisitor;

/**
 * This class contains the main routine for the Nolife compiler. It the scanner
 * and parser and then processes the input file.
 */

public abstract class Frontend {

	public static String fileName = "CodeGeneratorTestfiles/my-test.nl"; // the name of the input file

	public static boolean generateInterpreterCode = false;

	/**
	 * @return the input file name
	 */
	static String getFileName() {
		return fileName;
	}

	public static void compileFile(String[] args)
			throws java.io.FileNotFoundException, java.io.IOException, java.lang.InterruptedException {

		boolean generateSource = false;
		Frontend frontend = null;

		if(args.length > 0) {
			fileName = args[0];
		}

		
		frontend = new NolifeFrontend();

		// set up the parser and scanner with the appropriate file
		// name
		//
		// parse the input file and return the intermediate
		//

		ProgramNode prog = frontend.parseFile(fileName);

		AbstractSyntaxTree ast = new AbstractSyntaxTree(prog);

		if (generateSource) {
			System.out.println(ast.getRoot().accept(new SourceVisitor()));
			//return;
		}
		
		PrintASTVisitor print = new PrintASTVisitor();
		ast.getRoot().accept(print);
		//System.out.println(print.getSrc());

		ast.typeCheck();
		
		StackAllocationVisitor alloc = new StackAllocationVisitor();
		HashMap<String,HashMap<String, VariableMeta>> tables = (HashMap<String, HashMap<String, VariableMeta>>) ast.getRoot().accept(alloc);

		CodeGenVisitor gen = new CodeGenVisitor(tables);
		ast.getRoot().accept(gen);
		
		if (AbstractSyntaxTree.error)
			System.exit(-1);

	}

	/**
	 * The main routine for compiling and Nolife program
	 *
	 * @param args the command-line arguments
	 */

	public static void main(String[] args)
			throws java.io.FileNotFoundException, java.io.IOException, java.lang.InterruptedException {

		Frontend.compileFile(args);
	}

	public abstract ProgramNode parseFile(String fileName) throws FileNotFoundException;
}
