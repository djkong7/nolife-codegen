package frontend.utils;

import java.util.*;

import frontend.ast.AbstractSyntaxTree;

/**
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public class SymbolTable
    extends Hashtable<String,Stack<SymbolTableEntry>> {

  private final static int initialCapacity = 100;
  private int currentLevel = -1;

  private Stack<Vector<Stack<SymbolTableEntry>>> scopeList;

  public SymbolTable() {
    super(initialCapacity);

    scopeList = new Stack<Vector<Stack<SymbolTableEntry>>>();

  }

  public int getCurrentLevel() {
    return currentLevel;
  }

  public void beginScope() {
    scopeList.push(new Vector<Stack<SymbolTableEntry>>());
    currentLevel++;
  }

  public void endScope(String name) {
    Vector<Stack<SymbolTableEntry>> scope = (Vector<Stack<SymbolTableEntry>>)scopeList.pop();

    for (int i = 0; i < scope.size(); i++) {
      Stack nameStack = (Stack)scope.elementAt(i);
      SymbolTableEntry entry = (SymbolTableEntry)nameStack.pop();
//      if (!entry.isReferenced()) {
//        System.err.println("In function "+name+": Variable "+entry.getName()+
//                           " never referenced");
//      }
    }

    currentLevel--;
  }

  public SymbolTableEntry add(String name) {
    Stack<SymbolTableEntry> nameStack = (Stack<SymbolTableEntry>)get(name);

    if (nameStack != null) {
      if (!nameStack.isEmpty()) {
        SymbolTableEntry entry = (SymbolTableEntry) nameStack.peek();
        if (entry != null) {
          if (entry.getNestingLevel() == currentLevel)
            return null;
        }
      }
    }
    else {
      nameStack = new Stack<SymbolTableEntry>();
      put(name,nameStack);
    }
    SymbolTableEntry entry = new SymbolTableEntry(name);
    entry.setNestingLevel(currentLevel);
    nameStack.push(entry);
    Vector<Stack<SymbolTableEntry>> scope = (Vector<Stack<SymbolTableEntry>>)scopeList.peek();

    scope.add(nameStack);

    return entry;
  }

  public SymbolTableEntry getEntry(String name) {
    SymbolTableEntry entry = null;

    Stack nameStack = (Stack)get(name);

    if (nameStack != null && !nameStack.isEmpty())
      entry = (SymbolTableEntry)nameStack.peek();

    return entry;
  }

}
