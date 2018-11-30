package frontend.visitor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import frontend.ast.*;
import frontend.utils.VariableMeta;

public class CodeGenVisitor implements ASTVisitor {
	
	private int type;

	private HashMap<String, HashMap<String, VariableMeta>> funcSymTables;
	private HashMap<String, VariableMeta> curSymTable;
	
	private int compilerTempNext;
	private boolean compilerTempUsed;
	private int numCompilerTemps;
	private static final int compilerTempExtraSpace = 32;

	// Map holding the different registers that can be used and
	// whether or not they are being used.
	private Map<String, Boolean> register_map = new LinkedHashMap<String, Boolean>();
	
	private int continueCounter;
	private int lessCounter;
	private int greaterCounter;
	private int notCounter;
	private int equalCounter;
	private int falseCounter;
	private int trueCounter;
	private int whileCounter;
	

	public CodeGenVisitor(HashMap<String, HashMap<String, VariableMeta>> in) {
		funcSymTables = in;
		curSymTable = null;
		type = -1;
		
		// Initializer for the register map. No registers are being used at the
		// beginning.
		//register_map.put("%eax", false);
		register_map.put("%ebx", false);
		register_map.put("%ecx", false);
		register_map.put("%esi", false);
		register_map.put("%edi", false);
		//Put last to only be used as a last resort
		register_map.put("%edx",false);
		
		continueCounter = 0;
		lessCounter = 0;
		greaterCounter = 0;
		notCounter = 0;
		falseCounter = 0;
		trueCounter = 0;
		equalCounter = 0;
		whileCounter = 0;
		
		compilerTempNext = 0;
		compilerTempUsed = false;
		numCompilerTemps = 0;
	}
	
	/**
	*Gets a free register from the register map.
	*@return a string that is the name of the free register
	*/
	public String get_free_register() {
		for(Map.Entry<String,Boolean> entry : register_map.entrySet()) { 
			if(entry.getValue() == false) { 
				register_map.replace(entry.getKey(),true);
				return entry.getKey();
			}
		}
		throw new ArrayIndexOutOfBoundsException("No free registers");
	}

	/**
	*Frees a register being used by program
	*@param the name of the register to be freed
	*/
	public void free_register(String register) {
		if(register != null)
			register_map.replace(register,false);
	}
	
	public void print_free_registers() {
		System.out.println("##########FREE REGISTERS############");
		for(Map.Entry<String,Boolean> entry : register_map.entrySet()) { 
			if(entry.getValue() == false) { 
				System.out.printf("#%s is free\n", entry.getKey());
			}
		}
		System.out.println("####################################");
	}

	private void visitChildren(ASTNode n) {
		for (ASTNode child : n.getChildren()) {
			if (child != null)
				child.accept(this);
		}
	}

	@Override
	public Object visit(AddExpressionNode n) {
		
		String reg2 = null;
		String reg = null;
		reg = (String)n.getLeftOperand().accept(this);
		reg2 = (String)n.getRightOperand().accept(this);
		
		System.out.println("#ADD STATEMENT");
		if(n.getConvertedType() == 3) {
			System.out.printf("push %s\n", reg2);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.printf("push %s\n", reg);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.println("fadd %st, %st(1)");
			System.out.println("sub %esp, 4");
			System.out.println("fstp dword ptr [%esp]\n");
			System.out.printf("pop %s\n", reg);
		} else {
			System.out.printf("add %s, %s\n", reg, reg2);
			
		}
		
		free_register(reg2);
		type = n.getConvertedType();
		return reg;
	}

	@Override
	public Object visit(ArrayReferenceNode n) {
		System.out.println("#ARRAY REFERENCE");
		String reg = get_free_register();
		String reg2;
		VariableMeta temp = curSymTable.get(n.getLabel());
		int offset = temp.offset;
		
		reg2 = (String)n.getChild(0).accept(this);
		System.out.printf("mov %s, %d\n", reg, temp.intMax);
		System.out.printf("sub %s, %s\n", reg, reg2);
		System.out.printf("imul %s, 4\n", reg);
		
		free_register(reg2);
		if(offset > 0) {
			reg2 = get_free_register();
			System.out.printf("mov %s, %d\n", reg2, offset);
			System.out.printf("add %s, %%ebp\n", reg2);
			System.out.printf("mov %s, dword ptr [%s]\n", reg2, reg2);
			System.out.printf("add %s, %s\n", reg, reg2);
			free_register(reg2);
		} else {
			System.out.printf("add %s, %d\n", reg, offset);
			System.out.printf("add %s, %%ebp\n", reg);
		}
		System.out.printf("mov %s, dword ptr [%s]\n", reg, reg);
		
		type = n.getConvertedType();
		return reg;
	}

	@Override
	public Object visit(AndExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#AND");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("je true%d\n", trueCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("true%d:\n", trueCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		trueCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = n.getConvertedType();
		return reg;
	}

	@Override
	public Object visit(ArrayTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(AssignmentStatementNode n) {
		System.out.println("#ASSIGNMENT");
		
		String reg = get_free_register();
		String reg2;
		VariableMeta temp = curSymTable.get(n.getLhs().getLabel());
		int offset = temp.offset;
		
		if(n.getLhs() instanceof ArrayReferenceNode) {
			System.out.println("#ARRAY REFERENCE");
			reg2 = (String)n.getLhs().getChild(0).accept(this);
			System.out.printf("mov %s, %d\n", reg, temp.intMax);
			System.out.printf("sub %s, %s\n", reg, reg2);
			System.out.printf("imul %s, 4\n", reg);
			
			
			free_register(reg2);
			if(offset > 0) {
				reg2 = get_free_register();
				System.out.printf("mov %s, %d\n", reg2, offset);
				System.out.printf("add %s, %%ebp\n", reg2);
				System.out.printf("mov %s, dword ptr [%s]\n", reg2, reg2);
				System.out.printf("add %s, %s\n", reg, reg2);
				free_register(reg2);
			} else {
				System.out.printf("add %s, %d\n", reg, offset);
				System.out.printf("add %s, %%ebp\n", reg);
			}
			
		} else {
			//Get the address of the variable and put
			//it in a register
			System.out.printf("mov %s, %d\n", reg, offset);
			System.out.printf("add %s, %%ebp\n", reg);
			
			if(offset > 0) {
				System.out.println("#TO PARAMETER");
				System.out.printf("mov %s, dword ptr [%s]\n", reg, reg);
			}
		}
		
		
		
		
		//Get the value to be assigned to the variable
		reg2 = (String)n.getRhs().accept(this);
		if(type == 3) {
			System.out.printf("push %s\n", reg2);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.printf("fstp dword ptr [%s]\n", reg);
		} else {
			System.out.printf("mov dword ptr [%s], %s\n", reg, reg2);
		}
		
		free_register(reg);
		free_register(reg2);
		return null;
	}

	@Override
	public Object visit(CaseElementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CaseStatementNode n) {
		System.out.println("#CASE STATEMENT");
		int caseCounter = 0;
		
		String reg = (String)n.getChild(0).accept(this);
		
		int finish = n.getChild(1).getChildren().size();
		for(ASTNode node : n.getChild(1).getChildren()) {
			System.out.printf("case%d:\n", caseCounter);
			node = (CaseElementNode)node;
			ExpressionListNode list = (ExpressionListNode)node.getChild(0);
			
			for(ASTNode temp : list.getChildren()) {
				String reg2 = (String)temp.accept(this);
				System.out.printf("cmp %s, %s\n", reg, reg2);
				System.out.printf("je case%dcode\n", caseCounter);
				
				free_register(reg2);
			}
			//Jump to the next cases if both fail
			System.out.printf("jmp case%d\n", caseCounter+1);
			//Run the case code
			System.out.printf("case%dcode:\n", caseCounter);
			node.getChild(1).accept(this);
			System.out.printf("jmp case%d\n", finish);
			caseCounter++;
			
			
		}
		System.out.printf("case%d:\n", caseCounter);
		
		free_register(reg);
		return null;
	}

	@Override
	public Object visit(CharacterDimensionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(CharacterNode n) {
		String reg = get_free_register();
		type = n.getConvertedType();
		System.out.printf("mov %s, %d\n", reg, (int)n.getValue());
		return reg;
	}

	@Override
	public Object visit(CompoundStatementNode n) {
		for (ASTNode child : n.getChildren()) {
			if (child != null) {
				child.accept(this);
				System.out.println("");
			}
		}
		return null;
	}

	@Override
	public Object visit(DivExpressionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(EqualExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#EQUAL");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("je equal%d\n", equalCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("equal%d:\n", equalCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		equalCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(FloatConstNode n) {
		type = n.getConvertedType();
		String reg = get_free_register();
		System.out.println("#FLOAT CONSTANT");
		
		//Find the info
		VariableMeta info = curSymTable.get(Float.toString(n.getValue()));
		if(info == null) {
			info = funcSymTables.get("global").get(Float.toString(n.getValue()));
		}
		
		System.out.printf("fld dword ptr %s\n", info.staticLocation);
		System.out.println("sub %esp, 4");
		System.out.println("fstp dword ptr [%esp]");
		System.out.printf("pop %s\n", reg);
		return reg;
	}

	@Override
	public Object visit(FunctionDeclNode n) {
		String funcName = n.getLabel();
		curSymTable = funcSymTables.get(funcName);
		
		int stackSpace = 0;
		for(VariableMeta meta : curSymTable.values()) {
			if(meta.offset < stackSpace) {
				stackSpace = meta.offset;
			}
		}
		compilerTempNext = stackSpace - 4;
		stackSpace -= compilerTempExtraSpace;
		stackSpace *= -1;

		System.out.printf( 
				".globl %s;\n" + 
				".type %s, @function\n" + 
				"%s:\n" + 
				"push %%ebp\n" + 
				"mov %%ebp, %%esp\n" + 
				"sub %%esp, " + (stackSpace) + "\n\n", funcName,funcName,funcName);

		visitChildren(n);
		System.out.println("leave\nret\n");
		return null;
	}

	@Override
	public Object visit(FunctionInvocationNode n) {
		System.out.println("#FUNCTION INVOCATION");
		System.out.println("#SAVE THOSE REGISTERS");
		//System.out.println("push %eax");
		System.out.println("push %ebx");
		System.out.println("push %ecx");
		System.out.println("push %edx");
		System.out.println("push %esi");
		System.out.println("push %edi");
		System.out.println("#DO THE OTHER STUFF");
		
		n.getChild(0).accept(this);
		
		System.out.println("#RESTORE THOSE REGISTERS");
		System.out.println("pop %edi");
		System.out.println("pop %esi");
		System.out.println("pop %edx");
		System.out.println("pop %ecx");
		System.out.println("pop %ebx");
		//System.out.println("pop %eax");
		System.out.println("#DO THE OTHER STUFF");
		
		String reg = get_free_register();
		System.out.printf("mov %s, %%eax\n", reg);
		
		
		return reg;
	}

	@Override
	public Object visit(GreaterEqualExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#GREATER THAN");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("jge greater%d\n", greaterCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("greater%d:\n", greaterCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		greaterCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(GreaterThanExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#GREATER THAN");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("jg greater%d\n", greaterCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("greater%d:\n", greaterCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		greaterCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(IfStatementNode n) {
		int falseCounterSave = falseCounter;
		int continueCounterSave = continueCounter;
		falseCounter++;
		continueCounter++;
		String reg = (String)n.getChild(0).accept(this);
		System.out.println("#IF STATEMENT");
		System.out.printf("cmp %s, 0\n", reg);
		System.out.printf("je false%d\n", falseCounterSave);
		
		n.getChild(1).accept(this);
		
		System.out.printf("jmp continue%d\n", continueCounterSave);
		
		
		System.out.printf("false%d:\n", falseCounterSave);
				
		if(n.getChildren().size() == 3 && n.getChild(2) != null) {
			n.getChild(2).accept(this);
		}
		
		System.out.printf("jmp continue%d\n", continueCounterSave);
		System.out.printf("continue%d:\n", continueCounterSave);
		
		
		return null;
	}

	@Override
	public Object visit(IntegerConstNode n) {
		String reg = get_free_register();
		type = n.getConvertedType();
		System.out.printf("mov %s, %d\n", reg, n.getValue());
		return reg;
	}

	@Override
	public Object visit(IntegerDimensionNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(InvocationNode n) {
		visitChildren(n);
		System.out.printf("call %s\n", n.getLabel());
		return null;
	}

	@Override
	public Object visit(LessEqualExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#LESS EQUAL THAN");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("jg less%d\n", lessCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("less%d:\n", lessCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		lessCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(LessThanExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#LESS THAN");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("jge less%d\n", lessCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("less%d:\n", lessCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		lessCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(ModExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#MOD");
		System.out.printf("mov %%eax, %s\n", reg);
		System.out.print("cdq\n");
		System.out.printf("idiv %s\n", reg2);
		System.out.printf("mov %s, %%edx\n", reg);
		
		free_register(reg2);
		return reg;
	}

	@Override
	public Object visit(MultiplyExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.printf("imul %s, %s\n", reg, reg2);
		free_register(reg2);
		return reg;
	}

	@Override
	public Object visit(NilNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(NotEqualExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#NOT EQUAL");
		System.out.printf("cmp %s, %s\n", reg, reg2);
		System.out.printf("je not%d\n", notCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("not%d:\n", notCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		notCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = n.getConvertedType();
		return reg;
	}

	@Override
	public Object visit(NotExpressionNode n) {
		String reg = (String)n.getChild(0).accept(this);
		System.out.println("#NOT");
		System.out.printf("cmp %s, 0\n", reg);
		System.out.printf("je false%d\n", falseCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("false%d:\n", falseCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		falseCounter++;
		continueCounter++;
		return reg;
	}

	@Override
	public Object visit(OrExpressionNode n) {
		String reg = (String)n.getLeftOperand().accept(this);
		String reg2 = (String)n.getRightOperand().accept(this);
		System.out.println("#OR");
		System.out.printf("cmp %s, 1\n", reg);
		System.out.printf("je true%d\n", trueCounter);
		System.out.printf("cmp %s, 1\n", reg2);
		System.out.printf("je true%d\n", trueCounter);
		System.out.printf("mov %s, 0\n", reg);
		System.out.printf("jmp continue%d\n", continueCounter);
		System.out.printf("true%d:\n", trueCounter);
		System.out.printf("mov %s, 1\n", reg);
		System.out.printf("continue%d:\n", continueCounter);
		trueCounter++;
		continueCounter++;
		free_register(reg2);
		
		type = 2;
		return reg;
	}

	@Override
	public Object visit(ParenthesisNode n) {
		type = n.getConvertedType();
		String reg = (String)n.getChild(0).accept(this);
		if(n.getRealType() != n.getConvertedType()) {
			System.out.println("#PAREN CONVERT");
			if(n.getConvertedType() == 3) {
				System.out.printf("push %s\n", reg);
				System.out.println("fild dword ptr [%esp]");
				System.out.println("add %esp, 4");
				System.out.println("sub %esp, 4");
				System.out.println("fstp dword ptr [%esp]");
				System.out.printf("pop %s\n", reg);
			}
		}
		return reg;
	}

	@Override
	public Object visit(PointerDereferenceNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(PointerTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ProcedureDeclNode n) {
		String funcName = n.getLabel();
		curSymTable = funcSymTables.get(funcName);
		
		int stackSpace = 0;
		for(VariableMeta meta : curSymTable.values()) {
			if(meta.offset < stackSpace) {
				stackSpace = meta.offset;
			}
		}
		compilerTempNext = stackSpace - 4;
		stackSpace -= compilerTempExtraSpace;
		stackSpace *= -1;

		System.out.printf( 
				".globl %s;\n" + 
				".type %s, @function\n" + 
				"%s:\n" + 
				"push %%ebp\n" + 
				"mov %%ebp, %%esp\n" + 
				"sub %%esp, " + (stackSpace) + "\n\n", funcName,funcName,funcName);

		visitChildren(n);
		System.out.println("leave\nret\n");
		return null;
	}

	@Override
	public Object visit(ProcedureInvocationNode n) {
		System.out.println("#FUNCTION INVOCATION");
		System.out.println("#SAVE THOSE REGISTERS");
		//System.out.println("push %eax");
		System.out.println("push %ebx");
		System.out.println("push %ecx");
		System.out.println("push %edx");
		System.out.println("push %esi");
		System.out.println("push %edi");
		System.out.println("#DO THE OTHER STUFF");
		
		n.getChild(0).accept(this);
		System.out.printf("add %%esp, %d\n", ((n.getChild(0).getChild(0).getChildren().size())*4));
		
		System.out.println("#RESTORE THOSE REGISTERS");
		System.out.println("pop %edi");
		System.out.println("pop %esi");
		System.out.println("pop %edx");
		System.out.println("pop %ecx");
		System.out.println("pop %ebx");
		//System.out.println("pop %eax");
		System.out.println("#DO THE OTHER STUFF");
		
		
	
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		curSymTable = funcSymTables.get("global");
		System.out.print(
				".intel_syntax\n" + 
				".section .rodata\n");

		int strCount = 0;
		int fltCount = 0;
		//Get and print all the string and float constants to the static data area.
		for (HashMap<String, VariableMeta> table : funcSymTables.values()) {
			for (VariableMeta meta : table.values()) {
				if (meta.offset == -1) {
					if (meta.isString) {
						System.out.printf(".__str%d: .string \"%s\"\n", strCount, meta.stringVal);
						meta.staticLocation = ".__str" + strCount;
						strCount++;
					} else if (meta.isFloat) {
						System.out.printf(".__flt%d: .float %f\n", fltCount, meta.floatVal);
						meta.staticLocation = ".__flt" + fltCount;
						fltCount++;
					}
				}
			}
		}
		
		int stackSpace = 0;
		for(VariableMeta meta : curSymTable.values()) {
			if(meta.offset < stackSpace) {
				stackSpace = meta.offset;
			}
		}
		compilerTempNext = stackSpace - 4;
		stackSpace -= compilerTempExtraSpace;
		stackSpace *= -1;

		System.out.println(
				".int_format:\n" + 
				"\t.string \"%d\\12\\0\"\n" + 
				".str_format:\n" + 
				"\t.string \"%s\\12\\0\"\n" + 
				".flt_format:\n" +
				"\t.string \"%f\\12\\0\"\n" +
				".char_format:\n" +
				"\t.string \"%c\\12\\0\"\n" +
				
				".int_in_format:\n" + 
				"\t.string \"%d\"\n" + 
				".flt_in_format:\n" +
				"\t.string \"%f\"\n" +
				".char_in_format:\n" +
				"\t.string \"%c\"\n" +
				
				".text\n" + 
				".globl main;\n" + 
				".type main, @function\n" + 
				"main:\n" + 
				"push %ebp\n" + 
				"mov %ebp, %esp\n" + 
				"sub %esp, " + (stackSpace) + "\n");

		n.getChild(2).accept(this);
		n.getChild(3).accept(this);
		System.out.println("leave\nret\n");
		n.getChild(5).accept(this);
		return null;
	}

	@Override
	public Object visit(ReadStatementNode n) {
		System.out.println("#READ STATEMENT");
		
		//Get the address of the variable and put
		//it in a register
		String reg = get_free_register();
		VariableMeta temp = curSymTable.get(n.getChild(0).getLabel());
		int offset = temp.offset;
		
		//Alter offset for array indexing
		if(n.getChild(0) instanceof ArrayReferenceNode) {
			int val;
			if(n.getChild(0).getChild(0) instanceof IntegerConstNode){
				val = ((IntegerConstNode)n.getChild(0).getChild(0)).getValue();
			} else {
				val = ((CharacterNode)n.getChild(0).getChild(0)).getValue();
			}
			int arrayOffset = (temp.intMax-val)*4;
			offset = offset-arrayOffset;
		}
		System.out.printf("mov %s, %d\n", reg, offset);
		System.out.printf("add %s, %%ebp\n", reg);
		System.out.printf("push %s\n", reg);
		
		if(n.getChild(0).getConvertedType() == 3){
			System.out.println("push offset flat:.flt_in_format");
		} else if(n.getChild(0).getConvertedType() == 2) {
			System.out.println("push offset flat:.int_in_format");
		} else if(n.getChild(0).getConvertedType() == 1) {
			System.out.println("push offset flat:.char_in_format");
		}
		free_register(reg);
		
		System.out.println("call scanf\n" +
							"add %esp,8");
		
		return null;
	}

	@Override
	public Object visit(RecordDeclarationNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordElementNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordInstantiationNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordReferenceNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(ReturnStatementNode n) {
		String reg = (String)n.getChild(0).accept(this);
		System.out.printf("mov %%eax, %s\n", reg);
		free_register(reg);
		return null;
	}

	@Override
	//Put the value of the variable in a register and
	//return that register string
	public Object visit(ScalarReferenceNode n) {
		//print_free_registers();
		System.out.println("#SCALAR REF");
		type = n.getConvertedType();
		String reg = get_free_register();
		int offset = curSymTable.get(n.getLabel()).offset;
		
		System.out.printf("mov %s, %d\n", reg, offset);
		System.out.printf("add %s, %%ebp\n", reg);
		System.out.printf("mov %s, dword ptr [%s]\n", reg, reg);
		
		//Parameter double dereference
		if(offset > 0) {
			System.out.println("#PARAMETER REFERENCE");
			System.out.printf("mov %s, dword ptr [%s]\n", reg, reg);
		}
		
		
		if(n.getRealType() != n.getConvertedType()) {
			if(n.getConvertedType() == 3) {
				System.out.printf("push %s\n", reg);
				System.out.println("fild dword ptr [%esp]");
				System.out.println("add %esp, 4");
				System.out.println("sub %esp, 4");
				System.out.println("fstp dword ptr [%esp]");
				System.out.printf("pop %s\n", reg);
			}
		}
		
		return reg;
	}

	@Override
	public Object visit(StandardTypeNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(StringNode n) {
		type = n.getConvertedType();
		System.out.printf("push offset flat:%s\n",curSymTable.get(n.getString()).staticLocation);
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(SubtractExpressionNode n) {
		String reg2 = null;
		String reg = null;
		reg2 = (String)n.getRightOperand().accept(this);
		reg = (String)n.getLeftOperand().accept(this);
		System.out.println("#SUBTRACT STATEMENT");
		if(n.getConvertedType() == 3) {
			System.out.printf("push %s\n", reg2);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.printf("push %s\n", reg);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.println("fsub %st, %st(1)");
			System.out.println("sub %esp, 4");
			System.out.println("fstp dword ptr [%esp]\n");
			System.out.printf("pop %s\n", reg);
		} else {
			System.out.printf("sub %s, %s\n", reg, reg2);
			
		}
		
		free_register(reg2);
		type = n.getConvertedType();
		return reg;
	}

	@Override
	public Object visit(VariableDeclarationNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(WhileStatementNode n) {
		int whileCounterSave = whileCounter;
		int continueCounterSave = continueCounter;
		int falseCounterSave = falseCounter;
		whileCounter++;
		continueCounter++;
		falseCounter++;

		System.out.println("#WHILE STATEMENT");
		System.out.printf("while%d:\n", whileCounterSave);
		
		String reg = (String)n.getChild(0).accept(this);
		System.out.printf("cmp %s, 0\n", reg);
		free_register(reg);
		
		System.out.printf("je false%d\n", falseCounterSave);
		
		n.getChild(1).accept(this);
		
		System.out.printf("jmp while%d\n", whileCounterSave);
		System.out.printf("false%d:\n", falseCounterSave);
		
		return null;
	}

	@Override
	public Object visit(WriteStatementNode n) {
		String reg;
		
		reg = (String)n.getChild(0).accept(this);
		
		System.out.println("#WRITE STATEMENT");
		if(type == 4) {
			System.out.println("push offset flat:.str_format");
		} else if(type == 3){
			System.out.printf("push %s\n", reg);
			System.out.println("fld dword ptr [%esp]");
			System.out.println("add %esp, 4");
			System.out.println("sub %esp, 8");
			System.out.println("fstp qword ptr [%esp]");
			System.out.println("push offset flat:.flt_format");
		} else if(type == 2) {
			System.out.printf("push %s\n", reg);
			System.out.println("push offset flat:.int_format");
		} else if(type == 1) {
			System.out.printf("push %s\n", reg);
			System.out.println("push offset flat:.char_format");
		}
		free_register(reg);
		
		if(type == 3){
			System.out.println("call printf\n" +
					"add %esp,12");
		} else {
			System.out.println("call printf\n" +
					"add %esp,8");
		}
		
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		String reg;
		if(n.getParent() instanceof InvocationNode) {
			System.out.println("#PUSH THE PARAMS");
			for(int i = n.getChildren().size() - 1; i >= 0; i--) {
				ASTNode temp = n.getChild(i);
				if(temp instanceof ScalarReferenceNode) {
					System.out.println("#SCALAR REF PARAM");
					ScalarReferenceNode node = (ScalarReferenceNode)temp;
					reg = get_free_register();
					VariableMeta varInfo = curSymTable.get(node.getLabel());
					int offset = varInfo.offset;
					//Get the address of the variable and put
					//it in a register
					System.out.printf("mov %s, %d\n", reg, offset);
					System.out.printf("add %s, %%ebp\n", reg);
					
					if(offset > 0) {
						System.out.println("#PARAM PASSED AS PARAM");
						System.out.printf("mov %s, dword ptr [%s]\n", reg, reg);
					}
					
					
					System.out.printf("push %s\n", reg);
					free_register(reg);
				} else if(temp instanceof ArrayReferenceNode){
					ArrayReferenceNode node = (ArrayReferenceNode)temp;
					reg = get_free_register();
					String reg2;
					VariableMeta temp2 = curSymTable.get(node.getLabel());
					int offset = temp2.offset;
					
					reg2 = (String)node.getChild(0).accept(this);
					System.out.printf("mov %s, %d\n", reg, temp2.intMax);
					System.out.printf("sub %s, %s\n", reg, reg2);
					System.out.printf("imul %s, 4\n", reg);
					
					free_register(reg2);
					if(offset > 0) {
						reg2 = get_free_register();
						System.out.printf("mov %s, %d\n", reg2, offset);
						System.out.printf("add %s, %%ebp\n", reg2);
						System.out.printf("mov %s, dword ptr [%s]\n", reg2, reg2);
						System.out.printf("add %s, %s\n", reg, reg2);
						free_register(reg2);
					} else {
						System.out.printf("add %s, %d\n", reg, offset);
						System.out.printf("add %s, %%ebp\n", reg);
					}
					System.out.printf("push %s\n", reg);
					
					type = node.getConvertedType();
					//return reg;
					
				} else {//IntegerConstNode, SubtractExpressionNode
					System.out.println("#OTHER PARAM");
					reg = (String)temp.accept(this);
					
					compilerTempUsed = true;
					numCompilerTemps++;
					String reg2 = get_free_register();
					System.out.printf("#compilerTempNext: %d\n", compilerTempNext);
					System.out.printf("mov %s, %d\n", reg2, compilerTempNext);
					System.out.printf("add %s, %%ebp\n", reg2);
					System.out.printf("mov dword ptr [%s], %s\n", reg2, reg);
					System.out.printf("push %s\n", reg2);
					
					compilerTempNext -= 4;
					free_register(reg2);
					free_register(reg);
				}
				
			}
		} else {
			visitChildren(n);
		}
		return null;
	}

	@Override
	public Object visit(CaseElementListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(VariableDeclarationListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordDeclListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(SubProgramDeclListNode n) {
		visitChildren(n);
		return null;
	}

	@Override
	public Object visit(RecordElementListNode n) {
		visitChildren(n);
		return null;
	}
}

/*12//
15//
18//
21//
24//
27//
30//
33//
36//
39*/


