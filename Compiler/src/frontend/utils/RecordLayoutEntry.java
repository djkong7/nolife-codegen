/**
 * 
 */
package frontend.utils;

import java.util.LinkedHashMap;
import java.util.Vector;

import frontend.ast.RecordElementNode;
import frontend.ast.TypeNode;

/**
 * @author carr
 *
 */
public class RecordLayoutEntry {

	
	private SymbolTable elementTable;
	private int recordSize;
	
	/**
	 * 
	 */
	public RecordLayoutEntry() {	
		elementTable = new SymbolTable();
		elementTable.beginScope();	
	}
	
	public boolean isElement(String name) {
		return elementTable.containsKey(name);	
	}
	
	public SymbolTable getElementSymbolTable() {
		return elementTable;
	}
	
	public int getRecordSize() {
		return recordSize;
	}
	
	public void setRecordSize(int size) {
		recordSize = size;
	}

}
