/**
 * 
 */
package frontend.visitor;

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

/**
 * @author carr
 *
 */
public interface ASTVisitor<T> {

	T visit(AddExpressionNode n);

	T visit(ArrayReferenceNode n);

	T visit(AndExpressionNode n);

	T visit(ArrayTypeNode n);

	T visit(AssignmentStatementNode n);

	T visit(CaseElementNode n);

	T visit(CaseStatementNode n);

	T visit(CharacterDimensionNode n);

	T visit(CharacterNode n);

	T visit(CompoundStatementNode n);

	T visit(DivExpressionNode n);

	T visit(EqualExpressionNode n);

	T visit(FloatConstNode n);

	T visit(FunctionDeclNode n);

	T visit(FunctionInvocationNode n);

	T visit(GreaterEqualExpressionNode n);

	T visit(GreaterThanExpressionNode n);

	T visit(IfStatementNode n);

	T visit(IntegerConstNode n);

	T visit(IntegerDimensionNode n);

	T visit(InvocationNode n);

	T visit(LessEqualExpressionNode n);

	T visit(LessThanExpressionNode n);

	T visit(ModExpressionNode n);

	T visit(MultiplyExpressionNode n);

	T visit(NilNode n);

	T visit(NotEqualExpressionNode n);

	T visit(NotExpressionNode n);

	T visit(OrExpressionNode n);

	T visit(ParenthesisNode n);

	T visit(PointerDereferenceNode n);

	T visit(PointerTypeNode n);

	T visit(ProcedureDeclNode n);

	T visit(ProcedureInvocationNode n);

	T visit(ProgramNode n);

	T visit(ReadStatementNode n);

	T visit(RecordDeclarationNode n);

	T visit(RecordElementNode n);

	T visit(RecordInstantiationNode n);

	T visit(RecordReferenceNode n);

	T visit(RecordTypeNode n);

	T visit(ReturnStatementNode n);

	T visit(ScalarReferenceNode n);

	T visit(StandardTypeNode n);

	T visit(StringNode n);

	T visit(SubtractExpressionNode n);

	T visit(VariableDeclarationNode n);

	T visit(WhileStatementNode n);

	T visit(WriteStatementNode n);

	T visit(ExpressionListNode n);

	T visit(CaseElementListNode n);

	T visit(VariableDeclarationListNode n);

	T visit(RecordDeclListNode n);

	T visit(SubProgramDeclListNode n);

	T visit(RecordElementListNode n);

}
