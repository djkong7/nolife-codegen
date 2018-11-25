/**
 * 
 */
package frontend.visitor;

import frontend.ast.ASTNode;
import frontend.ast.AddExpressionNode;
import frontend.ast.AndExpressionNode;
import frontend.ast.ArrayReferenceNode;
import frontend.ast.ArrayTypeNode;
import frontend.ast.AssignmentStatementNode;
import frontend.ast.CaseElementListNode;
import frontend.ast.CaseElementNode;
import frontend.ast.CaseStatementNode;
import frontend.ast.CharacterDimensionNode;
import frontend.ast.CharacterNode;
import frontend.ast.CompoundStatementNode;
import frontend.ast.DivExpressionNode;
import frontend.ast.EqualExpressionNode;
import frontend.ast.ExpressionListNode;
import frontend.ast.FloatConstNode;
import frontend.ast.FunctionDeclNode;
import frontend.ast.FunctionInvocationNode;
import frontend.ast.GreaterEqualExpressionNode;
import frontend.ast.GreaterThanExpressionNode;
import frontend.ast.IfStatementNode;
import frontend.ast.IntegerConstNode;
import frontend.ast.IntegerDimensionNode;
import frontend.ast.InvocationNode;
import frontend.ast.LessEqualExpressionNode;
import frontend.ast.LessThanExpressionNode;
import frontend.ast.ModExpressionNode;
import frontend.ast.MultiplyExpressionNode;
import frontend.ast.NilNode;
import frontend.ast.NotEqualExpressionNode;
import frontend.ast.NotExpressionNode;
import frontend.ast.OrExpressionNode;
import frontend.ast.ParenthesisNode;
import frontend.ast.PointerDereferenceNode;
import frontend.ast.PointerTypeNode;
import frontend.ast.ProcedureDeclNode;
import frontend.ast.ProcedureInvocationNode;
import frontend.ast.ProgramNode;
import frontend.ast.ReadStatementNode;
import frontend.ast.RecordDeclListNode;
import frontend.ast.RecordDeclarationNode;
import frontend.ast.RecordElementListNode;
import frontend.ast.RecordElementNode;
import frontend.ast.RecordInstantiationNode;
import frontend.ast.RecordReferenceNode;
import frontend.ast.RecordTypeNode;
import frontend.ast.ReturnStatementNode;
import frontend.ast.ScalarReferenceNode;
import frontend.ast.StandardTypeNode;
import frontend.ast.StringNode;
import frontend.ast.SubProgramDeclListNode;
import frontend.ast.SubtractExpressionNode;
import frontend.ast.VariableDeclarationListNode;
import frontend.ast.VariableDeclarationNode;
import frontend.ast.WhileStatementNode;
import frontend.ast.WriteStatementNode;
import frontend.utils.SymbolTable;
import frontend.utils.SymbolTableEntry;

/**
 * @author carr
 *
 */
public class ByReferenceVisitor implements ASTVisitor<Void> {

	private SymbolTable symTable;

	/**
	 * 
	 */
	public ByReferenceVisitor() {
	}
	
	public ByReferenceVisitor addSymbolTable(SymbolTable symtab) {
		symTable = symtab;
		return this;
	}

	private Void propagateByReferenceInfo(ASTNode n) {

		for (ASTNode child : n.getChildren())
			child.accept(this);
		
		return null;
	}

	@Override
	public Void visit(AddExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ArrayReferenceNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(AndExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ArrayTypeNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(AssignmentStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CaseElementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CaseStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CharacterDimensionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CharacterNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CompoundStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(DivExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(EqualExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(FloatConstNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(FunctionDeclNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(FunctionInvocationNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(GreaterEqualExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(GreaterThanExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(IfStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(IntegerConstNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(IntegerDimensionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(InvocationNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(LessEqualExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(LessThanExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ModExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(MultiplyExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(NilNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(NotEqualExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(NotExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(OrExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ParenthesisNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(PointerDereferenceNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(PointerTypeNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ProcedureDeclNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ProcedureInvocationNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ProgramNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ReadStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordDeclarationNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordElementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordInstantiationNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordReferenceNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordTypeNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ReturnStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ScalarReferenceNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(StandardTypeNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(StringNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(SubtractExpressionNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(VariableDeclarationNode n) {
		for (String id : n.getVariableList()) {
			SymbolTableEntry entry = symTable.getEntry(id);

			if (frontend.Frontend.generateInterpreterCode)
				n.addIsInRegister(new Boolean(!entry.isPassedByReference()));
			else
				n.addIsInRegister(new Boolean(false));
		}
		return null;
	}

	@Override
	public Void visit(WhileStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(WriteStatementNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(ExpressionListNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(CaseElementListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(VariableDeclarationListNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordDeclListNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(SubProgramDeclListNode n) {
		return propagateByReferenceInfo(n);
	}

	@Override
	public Void visit(RecordElementListNode n) {
		return propagateByReferenceInfo(n);
	}

}
