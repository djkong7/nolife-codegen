/**
 * 
 */
package frontend;

import java.io.FileNotFoundException;
import java.io.FileReader;

import frontend.ast.ProgramNode;
import frontend.parser.nolife.NolifeParser;
import frontend.parser.nolife.ParseException;

/**
 * @author carr
 * 
 */
public class NolifeFrontend extends Frontend {

	@Override
	public ProgramNode parseFile(String fileName) throws FileNotFoundException {
		
	    FileReader nolifeFile = new FileReader(fileName);
	    NolifeParser parser = new NolifeParser(nolifeFile);
		ProgramNode prog = null;

		try {
			prog = NolifeParser.program();
		} catch (ParseException e) {
			System.err.println("Syntax Error in " + fileName + ": " + e);
			System.exit(-1);
		}
		
		return prog;
	}

}
