/**
 * 
 */
package frontend.ast;

/**
 * @author carr
 *
 */
public class ASTNodeFactory {

	/**
	 * 
	 */
	public ASTNodeFactory() {
	}
	
	public ASTNode makeASTNode(String nodeType) {
		ASTNode node;
		
		switch (nodeType) {
		case "AddExpressionNode":
			node = new AddExpressionNode();
			break;
		case "AndExpressionNode":
			node = new AndExpressionNode();
			break;
		case "ArrayReferenceNode":
			node = new ArrayReferenceNode();
			break;
		case "ArrayTypeNode":
			node = new ArrayTypeNode();
			break;
		case "AssignmentStatementNode":
			node = new AssignmentStatementNode();
			break;
		case "CaseElementListNode":
			node = new CaseElementListNode();
			break;
		case "CaseElementNode":
			node = new CaseElementNode();
			break;
		case "CaseStatementNode":
			node = new CaseStatementNode();
			break;
		case "CharacterDimensionNode":
			node = new CharacterDimensionNode();
			break;
		case "CharacterNode":
			node = new CharacterNode();
			break;
		case "CompoundStatementNode":
			node = new CompoundStatementNode();
			break;
		case "DivExpressionNode":
			node = new DivExpressionNode();
			break;
		case "EqualExpressionNode":
			node = new EqualExpressionNode();
			break;
		case "ExpressionListNode":
			node = new ExpressionListNode();
			break;
		case "FloatConstNode":
			node = new FloatConstNode();
			break;
		case "FunctionDeclNode":
			node = new FunctionDeclNode();
			break;
		case "FunctionInvocationNode":
			node = new FunctionInvocationNode();
			break;
		case "GreaterEqualExpressionNode":
			node = new GreaterEqualExpressionNode();
			break;
		case "GreaterThanExpressionNode":
			node = new GreaterThanExpressionNode();
			break;
		case "IfStatementNode":
			node = new IfStatementNode();
			break;
		case "IntegerConstNode":
			node = new IntegerConstNode();
			break;
		case "IntegerDimensionNode":
			node = new IntegerDimensionNode();
			break;
		case "InvocationNode":
			node = new InvocationNode();
			break;
		case "LessEqualExpressionNode":
			node = new LessEqualExpressionNode();
			break;
		case "LessThanExpressionNode":
			node = new LessThanExpressionNode();
			break;
		case "ModExpressionNode":
			node = new ModExpressionNode();
			break;
		case "MultiplyExpressionNode":
			node = new MultiplyExpressionNode();
			break;
		case "NilNode":
			node = new NilNode();
			break;
		case "NotEqualExpressionNode":
			node = new NotEqualExpressionNode();
			break;
		case "NotExpressionNode":
			node = new NotExpressionNode();
			break;
		case "OrExpressionNode":
			node = new OrExpressionNode();
			break;
		case "ParenthesisNode":
			node = new ParenthesisNode();
			break;
		case "PointerDereferenceNode":
			node = new PointerDereferenceNode();
			break;
		case "PointerTypeNode":
			node = new PointerTypeNode();
			break;
		case "ProcedureDeclNode":
			node = new ProcedureDeclNode();
			break;
		case "ProcedureInvocationNode":
			node = new ProcedureInvocationNode();
			break;
		case "ProgramNode":
			node = new ProgramNode();
			break;
		case "ReadStatementNode":
			node = new ReadStatementNode();
			break;
		case "RecordDeclarationNode":
			node = new RecordDeclarationNode();
			break;
		case "RecordDeclListNode":
			node = new RecordDeclListNode();
			break;
		case "RecordElementListNode":
			node = new RecordElementListNode();
			break;
		case "RecordElementNode":
			node = new RecordElementNode();
			break;
		case "RecordInstantiationNode":
			node = new RecordInstantiationNode();
			break;
		case "RecordReferenceNode":
			node = new RecordReferenceNode();
			break;
		case "RecordTypeNode":
			node = new RecordTypeNode();
			break;
		case "ReturnStatementNode":
			node = new ReturnStatementNode();
			break;
		case "ScalarReferenceNode":
			node = new ScalarReferenceNode();
			break;
		case "StandardTypeNode":
			node = new StandardTypeNode();
			break;
		case "StringNode":
			node = new StringNode();
			break;
		case "SubProgramDeclListNode":
			node = new SubProgramDeclListNode();
			break;
		case "SubtractExpressionNode":
			node = new SubtractExpressionNode();
			break;
		case "VariableDeclarationListNode":
			node = new VariableDeclarationListNode();
			break;
		case "VariableDeclarationNode":
			node = new VariableDeclarationNode();
			break;
		case "WhileStatementNode":
			node = new WhileStatementNode();
			break;
		case "WriteStatementNode":
			node = new WriteStatementNode();
			break;
		default:
			throw new RuntimeException("Invalid AST Type " + nodeType);
		}
		
		return node;
	}

}
