package frontend.utils;

import java.util.Vector;
import frontend.ast.*;

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
public class SymbolTableEntry {

  private String name;
  private int dataType = TypeTable.ANY_TYPE;
  private int nestingLevel;
  private boolean referenced = false;
  private int offset = 0;
  private int virtualRegisterId = -1;
  private boolean isParam = false;
  private boolean localInRegister = false;
  private boolean passedByReference = false;

  public SymbolTableEntry(String name) {
    this.name = new String(name);
  }

  public void setDataType(int dataType) {
    this.dataType = dataType;
  }

  public void setNestingLevel(int level) {
    this.nestingLevel = level;
  }
  
  public void setReferenced() {
    referenced = true;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setVirtualRegisterId(int id) {
    virtualRegisterId = id;
  }

  public void setIsParameter() {
    isParam = true;
  }
  
  public void setLocalInRegister() {
	  localInRegister = true;
  }
  
  public void setPassedByReference() {
	  passedByReference = true;
  }

  public String getName() {
    return name;
  }

  public int getDataType() {
    return dataType;
  }

  public int getNestingLevel() {
    return nestingLevel;
  }
  
  public boolean isReferenced() {
    return referenced;
  }

  public int getOffset() {
    return offset;
  }

  public int getVirtualRegisterId() {
    return virtualRegisterId;
  }

  public boolean isParameter() {
    return isParam;
  }
  
  public boolean isLocalInRegister() {
	  return localInRegister;
  }
  
  public boolean isPassedByReference() {
	  return passedByReference;
  }
}
