package frontend.visitor;

import java.util.HashMap;

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
import frontend.utils.VariableMeta;

public class CodeGenVisitor implements ASTVisitor{
	
	private HashMap<String,HashMap<String, VariableMeta>> funcSymTables;
	
	public CodeGenVisitor(HashMap<String,HashMap<String, VariableMeta>> in) {
		funcSymTables = in;
	}
	
	private void visitChildren(ASTNode n) {
		for(ASTNode child : n.getChildren()) {
			if(child != null)
				child.accept(this);
		}
	}

	@Override
	public Object visit(AddExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArrayTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignmentStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CaseElementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CharacterDimensionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CharacterNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FloatConstNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionDeclNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntegerDimensionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(InvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessThanExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ModExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NilNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		System.out.print(
						".intel_syntax\n"+
						".section .rodata\n");
		
		int strCount = 0;
		int fltCount = 0;
		for(HashMap<String, VariableMeta> table : funcSymTables.values()) {
			for(VariableMeta meta : table.values()) {
				if(meta.offset == -1) {
					if(meta.isString) {
						System.out.printf("__str%d: .string \"%s\"\n",strCount,meta.stringVal);
						meta.staticLocation = "__str" + strCount;
						strCount++;
					}else if(meta.isFloat) {
						System.out.printf("__flt%d: .string %f\n",fltCount,meta.floatVal);
						meta.staticLocation = "__str" + fltCount;
						fltCount++;
					}
				}
			}
		}
		
		System.out.println(
							".io_format:\n"+
							".string \"%d\\12\\0\"\n"+
							".text\n"+
							".globl main;\n"+
							".type main, @function\n"+
							"main:\n"+
							"push %ebp\n"+
							"mov %ebp, %esp\n"+
							"sub %esp, 64\n");
		
		
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ReadStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordDeclarationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ScalarReferenceNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StandardTypeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StringNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SubtractExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDeclarationNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WhileStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		// TODO Auto-generated method stub
		return null;
	}
}
