package frontend.ast;

import frontend.visitor.ASTVisitor;

/*
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Node representing a character literal in a Nolife program.</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class CharacterNode extends ConstantNode {

	private char character; // character literal represented by this node.

	/*
	 * Create a new node for a character literal
	 * 
	 * @param character char a character literal
	 */
	public CharacterNode() {
		super();
	}
	
	public CharacterNode addValue(char c) {
		character = c;
		return this;
	}

	@Override
	public CharacterNode addLineNumber(int lineNum) {
		return (CharacterNode) super.addLineNumber(lineNum);
	}

	/*
	 * Return the character literal
	 * 
	 * @return char
	 */
	public char getValue() {
		return character;
	}

	public int getIntValue() {
		return (character);
	}

	@Override
	public String getSource() {
		return "'" + character + "'";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}
}
