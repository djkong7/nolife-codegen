/**
 * 
 */
package frontend.ast;

import java.util.Vector;

import frontend.utils.RecordLayoutEntry;
import frontend.utils.SymbolTable;
import frontend.utils.SymbolTableEntry;
import frontend.utils.TypeTable;
import frontend.visitor.ASTVisitor;

/**
 * @author carr
 *
 */
public class RecordDeclarationNode extends ASTNode {

	private static final int numChildren = 1;
	private static final int elementIndex = 0;
	
	/**
	 * 
	 */
	public RecordDeclarationNode() {
		children = new Vector<ASTNode>();
		children.setSize(numChildren);
	}
	
	public RecordDeclarationNode addRecordName(String rn) {
		return (RecordDeclarationNode) addLabel(rn);
	}
	
	public RecordDeclarationNode addElements(RecordElementListNode eln) {
		return (RecordDeclarationNode) addChild(elementIndex,eln);
	}
	
	@Override
	public RecordDeclarationNode addLineNumber(int lineNum) {
		return (RecordDeclarationNode) super.addLineNumber(lineNum);
	}

	public String getRecordName() {
		return getLabel();
	}
	
	public RecordElementListNode getRecordElements() {
		return (RecordElementListNode) getChild(elementIndex);
	}

	public void addToSymTable(SymbolTable symTable) {
		SymbolTableEntry entry = symTable.add(getRecordName());

		if (entry == null) {
			System.err.println("Line " + lineNumber + ": Redeclaration of record: " + getRecordName());
			AbstractSyntaxTree.error = true;
			realType = TypeTable.NO_TYPE;
		} else {
			int typeVal = TypeTable.getTypeVal(toString());
			entry.setDataType(typeVal);
			realType = typeVal;
		}
	}

	public void setElementOffsets(RecordLayoutEntry recordInfo) {

		int offset = 0;
		SymbolTable elementTable = recordInfo.getElementSymbolTable();

		for (int i = 0; i < getRecordElements().size(); i++) {

			Vector<String> names = getRecordElements().getRecordElement(i).getNames();
			TypeNode typeN = getRecordElements().getRecordElement(i).getType();

			for (int j = 0; j < names.size(); j++) {
				SymbolTableEntry entry = elementTable.getEntry(names.elementAt(j));

				entry.setOffset(offset);

				offset += TypeTable.getDataSize(TypeTable.getTypeVal(typeN.toString()));
			}

		}

		recordInfo.setRecordSize(offset);

	}

	@Override
	public String toString() {
		return "record::" + getRecordName();
	}

	@Override
	public String getSource() {
		return "";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object accept(ASTVisitor v) {
		return v.visit(this);
	}

}
