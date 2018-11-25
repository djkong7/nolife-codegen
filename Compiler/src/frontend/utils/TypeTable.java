package frontend.utils;

import java.util.*;
import java.util.regex.*;

/**
 * <p>Title: Nolife Compiler</p>
 *
 * <p>Description: Table for Nolife types</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Steve Carr
 * @version 1.0
 */
public final class TypeTable {

	private static Hashtable<String,Integer> table;
	private static Hashtable<String,RecordLayoutEntry> recordTable;

	public static final String ERROR_TYPE_STRING = "error";
	public static final String CHAR_TYPE_STRING = "char";
	public static final String INT_TYPE_STRING = "int";
	public static final String FLOAT_TYPE_STRING = "float";
	public static final String STRING_TYPE_STRING = "string";
	public static final String POINTER_INT_TYPE_STRING = "pointer::int";
	public static final String POINTER_FLOAT_TYPE_STRING = "pointer::float";
	public static final String POINTER_CHAR_TYPE_STRING = "pointer::char";
	public static final String POINTER_NO_TYPE_STRING = "pointer::no";
	public static final String ANY_TYPE_STRING = "any";
	public static final String NO_TYPE_STRING = "none";
	public static final String NIL_TYPE_STRING = "record::[a-zA-Z][a-zA-Z0-9]*";

	public static final String ERROR_WFORMAT_STRING = "error";

	public static final int ERROR_TYPE = 0;
	public static final int CHAR_TYPE = 1;
	public static final int INT_TYPE = 2;
	public static final int FLOAT_TYPE = 3;
	public static final int STRING_TYPE = 4;
	public static final int POINTER_INT_TYPE = 5;
	public static final int POINTER_FLOAT_TYPE = 6;
	public static final int POINTER_CHAR_TYPE = 7;
	public static final int POINTER_NO_TYPE = 8;
	public static final int ANY_TYPE = 9;
	public static final int NO_TYPE = 10;
	public static final int NIL_TYPE = 11;
	public static final int NUM_BASIC_TYPES = 12; /* does not include pointers as they are processed differently */

	public static final int INT_SIZE = 4;
	public static final int CHAR_SIZE = 4;
	public static final int FLOAT_SIZE = 4;
	public static final int POINTER_SIZE = 4;

	private static final int[][] arithmeticTable = {
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, 
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, POINTER_INT_TYPE, POINTER_FLOAT_TYPE, POINTER_CHAR_TYPE, POINTER_NO_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, FLOAT_TYPE, FLOAT_TYPE, ERROR_TYPE, ERROR_TYPE, FLOAT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, POINTER_INT_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, ANY_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, POINTER_NO_TYPE, POINTER_FLOAT_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, ANY_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_CHAR_TYPE, POINTER_NO_TYPE, ANY_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, ANY_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		},
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		},
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}
	};

	private static final int[][] assignmentTable = {
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, CHAR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, CHAR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, FLOAT_TYPE, FLOAT_TYPE, ERROR_TYPE, FLOAT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, POINTER_INT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, POINTER_INT_TYPE, POINTER_INT_TYPE, POINTER_INT_TYPE, POINTER_INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, POINTER_FLOAT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, POINTER_FLOAT_TYPE, POINTER_FLOAT_TYPE, POINTER_FLOAT_TYPE, POINTER_FLOAT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, POINTER_CHAR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, POINTER_CHAR_TYPE, POINTER_CHAR_TYPE, POINTER_CHAR_TYPE, POINTER_CHAR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, POINTER_NO_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE, POINTER_NO_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ANY_TYPE, ANY_TYPE, ANY_TYPE, ERROR_TYPE, ANY_TYPE, ANY_TYPE, ANY_TYPE, ANY_TYPE, ANY_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}
	};

	private static final int[][] booleanTable = {
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, CHAR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, CHAR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, FLOAT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, CHAR_TYPE, INT_TYPE, FLOAT_TYPE, ERROR_TYPE, ANY_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}
	};

	private static final int[][] comparisonTable = {
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, INT_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, ERROR_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE, INT_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			ERROR_TYPE
		}, 
		{
			ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE, ERROR_TYPE,
			INT_TYPE
		}

	};

	private static int typeNumber = NUM_BASIC_TYPES;

	private static Vector<String> typeStringVec;

	public static void initTypeTable(int initialCapacity) {
		table = new Hashtable<String,Integer>(initialCapacity);
		recordTable = new Hashtable<String,RecordLayoutEntry>(initialCapacity);

		typeStringVec = new Vector<String>();

		// the order of the calls must not change unless the TYPE values change
		// this order must match the order of TYPE values

		putTypeVal(ERROR_TYPE_STRING, ERROR_TYPE);
		putTypeVal(CHAR_TYPE_STRING, CHAR_TYPE);
		putTypeVal(INT_TYPE_STRING, INT_TYPE);
		putTypeVal(FLOAT_TYPE_STRING, FLOAT_TYPE);
		putTypeVal(STRING_TYPE_STRING, STRING_TYPE);
		putTypeVal(POINTER_INT_TYPE_STRING,POINTER_INT_TYPE);
		putTypeVal(POINTER_FLOAT_TYPE_STRING,POINTER_FLOAT_TYPE);
		putTypeVal(POINTER_CHAR_TYPE_STRING,POINTER_CHAR_TYPE);
		putTypeVal(POINTER_NO_TYPE_STRING,POINTER_NO_TYPE);
		putTypeVal(ANY_TYPE_STRING, ANY_TYPE);
		putTypeVal(NO_TYPE_STRING, NO_TYPE);
		putTypeVal(NIL_TYPE_STRING, NIL_TYPE);

	}

	private static void putTypeVal(String typeString,
			int typeVal) {
		table.put(typeString, new Integer(typeVal));
		typeStringVec.add(typeString);
	}

	public static int getTypeVal(String typeString) {
		Integer typeVal = (Integer) table.get(typeString);

		if (typeVal == null) {
			typeVal = new Integer(typeNumber++);
			table.put(typeString, typeVal);
			typeStringVec.add(typeString);
		}

		return typeVal.intValue();
	}

	/**
	 * Return the type value for a type string. If it doesn't exist, return -1
	 * 
	 * @param typeString
	 * @return
	 */
	public static int queryTypeVal(String typeString) {
		Integer typeVal = (Integer) table.get(typeString);

		if (typeVal == null) {
			return -1;
		}

		return typeVal.intValue();

	}

	public static String getTypeString(int typeVal) {
		return (String) typeStringVec.elementAt(typeVal);
	}

	public static int getArrayBasicType(int arrayType) {

		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return ERROR_TYPE;
		}
		else {
			int index = typeString.lastIndexOf('$');

			if (index != -1) {
				return getBaseTypeFromString(typeString.substring(index + 1,
						typeString.length()));
			}
			else {
				return ERROR_TYPE;
			}
		}
	}

	public static int getArraySubscriptType(int arrayType) {
		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return ERROR_TYPE;
		}
		else {
			if (typeString.indexOf("%int%") != -1) {
				return INT_TYPE;
			}
			else if (typeString.indexOf("%char%") != -1) {
				return CHAR_TYPE;
			}
			else {
				return ERROR_TYPE;
			}
		}
	}

	public static int getArrayIntLowerBound(int arrayType) {
		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return Integer.MIN_VALUE;
		}
		else {
			if (typeString.indexOf("%int%") != -1) {
				int index = typeString.lastIndexOf('%');
				int rindex = typeString.indexOf("..");
				Integer lwb = new Integer(typeString.substring(index + 1, rindex));

				return lwb.intValue();
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
	}

	public static int getArrayIntUpperBound(int arrayType) {
		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return Integer.MIN_VALUE;
		}
		else {
			if (typeString.indexOf("%int%") != -1) {
				int index = typeString.lastIndexOf("..");
				int rindex = typeString.indexOf("$$");
				Integer upb = new Integer(typeString.substring(index + 2, rindex));

				return upb.intValue();
			}
			else {
				return Integer.MIN_VALUE;
			}
		}
	}

	public static char getArrayCharLowerBound(int arrayType) {
		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return Character.MIN_VALUE;
		}
		else {
			if (typeString.indexOf("%char%") != -1) {
				int index = typeString.lastIndexOf('%');

				return typeString.charAt(index + 1);
			}
			else {
				return Character.MIN_VALUE;
			}
		}
	}

	public static char getArrayCharUpperBound(int arrayType) {
		String typeString = getTypeString(arrayType);

		if (typeString.indexOf("array::") != 0) {
			return Character.MIN_VALUE;
		}
		else {
			if (typeString.indexOf("%char%") != -1) {
				int index = typeString.lastIndexOf("..");

				return typeString.charAt(index + 2);
			}
			else {
				return Character.MIN_VALUE;
			}
		}
	}

	public static int getArrayLowerBoundValue(int type) {
		String typeString = getTypeString(type);
		if (typeString.indexOf("array::") != 0) {
			return Integer.MIN_VALUE;
		}
		else if (typeString.indexOf("%char%") != -1) {
			char c_lwb = getArrayCharLowerBound(type);
			return ((int)c_lwb);
		}
		else
			return getArrayIntLowerBound(type);
	}

	public static int getFunctionReturnType(int funcType) {

		String typeString = getTypeString(funcType);

		if (typeString.indexOf("func::") != 0) {
			return ERROR_TYPE;
		}
		else {
			int index = typeString.lastIndexOf('>');

			if (index != -1) {
				return getBaseTypeFromString(typeString.substring(index + 1,
						typeString.length()));
			}
			else {
				return ERROR_TYPE;
			}
		}
	}

	public static boolean isRecordType(int recordType) {
		String typeString = getTypeString(recordType);

		if (typeString.indexOf("record::") != 0)
			return false;
		else
			return true;
	}
	
	public static boolean isPointerType(int type) {
		if (type >= POINTER_INT_TYPE && type <= POINTER_NO_TYPE)
			return true;
		else
			return false;
	}

	public static String getRecordNameFromType(int recordType) {
		String typeString = getTypeString(recordType);

		if (typeString.indexOf("record::") != 0)
			return "";
		else {
			int index = typeString.lastIndexOf(":");

			return typeString.substring(index+1);
		}
	}


	public static String getBasicTypeString(int type) {
		switch (type) {
		case INT_TYPE:
			return INT_TYPE_STRING;
		case CHAR_TYPE:
			return CHAR_TYPE_STRING;
		case FLOAT_TYPE:
			return FLOAT_TYPE_STRING;
		case STRING_TYPE:
			return STRING_TYPE_STRING;
		case POINTER_INT_TYPE:
			return POINTER_INT_TYPE_STRING;
		case POINTER_FLOAT_TYPE:
			return POINTER_FLOAT_TYPE_STRING;
		case POINTER_CHAR_TYPE:
			return POINTER_CHAR_TYPE_STRING;
		case POINTER_NO_TYPE:
			return POINTER_NO_TYPE_STRING;
		case ANY_TYPE:
			return ANY_TYPE_STRING;
		case NO_TYPE:
			return NO_TYPE_STRING;
		case NIL_TYPE:
			return NIL_TYPE_STRING;
		default:
			return ERROR_TYPE_STRING;
		}
	}

	public static int getDataSize(int type) {
		switch (type) {
		case INT_TYPE:
			return INT_SIZE;
		case CHAR_TYPE:
			return CHAR_SIZE;
		case FLOAT_TYPE:
			return FLOAT_SIZE;
		default:
			return POINTER_SIZE;
		}
	}

	public static int getBaseTypeFromString(String typeString) {
		if (typeString.compareTo(INT_TYPE_STRING) == 0) {
			return INT_TYPE;
		}
		else if (typeString.compareTo(CHAR_TYPE_STRING) == 0) {
			return CHAR_TYPE;
		}
		else if (typeString.compareTo(FLOAT_TYPE_STRING) == 0) {
			return FLOAT_TYPE;
		}
		else if (typeString.compareTo(STRING_TYPE_STRING) == 0) {
			return STRING_TYPE;
		}
		else if (typeString.compareTo(POINTER_INT_TYPE_STRING) == 0) {
			return POINTER_INT_TYPE;
		}
		else if (typeString.compareTo(POINTER_FLOAT_TYPE_STRING) == 0) {
			return POINTER_FLOAT_TYPE;
		}
		else if (typeString.compareTo(POINTER_CHAR_TYPE_STRING) == 0) {
			return POINTER_CHAR_TYPE;
		}
		else if (typeString.compareTo(POINTER_NO_TYPE_STRING) == 0) {
			return POINTER_NO_TYPE;
		}
		else if (typeString.compareTo(ANY_TYPE_STRING) == 0) {
			return ANY_TYPE;
		}
		else if (typeString.compareTo(NO_TYPE_STRING) == 0) {
			return NO_TYPE;
		}
		else if (typeString.compareTo(NIL_TYPE_STRING) == 0) {
			return NIL_TYPE;
		}
		else {
			int type = getTypeVal(typeString);

			if (type == -1)
				return ERROR_TYPE;
			else
				return type;
		}
	}

	public static int getResultAssignmentType(int lhsType,
			int rhsType) {
		if (lhsType >= NUM_BASIC_TYPES || rhsType >= NUM_BASIC_TYPES)
			if (isRecordType(lhsType) &&
					((lhsType == rhsType) || rhsType == NIL_TYPE))
				return lhsType;
			else
				return ERROR_TYPE;

		return assignmentTable[lhsType][rhsType];
	}

	public static int getResultArithmeticType(int lhsType,
			int rhsType) {
		if (lhsType >= NUM_BASIC_TYPES) {
			lhsType = NO_TYPE;
		}
		if (rhsType >= NUM_BASIC_TYPES) {
			rhsType = NO_TYPE;
		}

		return arithmeticTable[lhsType][rhsType];
	}

	public static int getResultBooleanType(int lhsType,
			int rhsType) {
		if (lhsType >= NUM_BASIC_TYPES) {
			lhsType = NO_TYPE;
		}
		if (rhsType >= NUM_BASIC_TYPES) {
			rhsType = NO_TYPE;
		}

		return booleanTable[lhsType][rhsType];
	}

	public static int getResultComparisonType(int lhsType,
			int rhsType) {
		if (lhsType >= NUM_BASIC_TYPES)
			if (isRecordType(lhsType) &&
					((lhsType == rhsType) || rhsType == NIL_TYPE))
				return INT_TYPE;
			else
				lhsType = NO_TYPE;
		if (rhsType >= NUM_BASIC_TYPES)
			if (isRecordType(rhsType) &&
					((lhsType == rhsType) || lhsType == NIL_TYPE))
				return INT_TYPE;
			else
				rhsType = NO_TYPE;

		return comparisonTable[lhsType][rhsType];
	}

	public static RecordLayoutEntry getRecordLayoutEntry(int recordType) {
		return recordTable.get(getRecordNameFromType(recordType));
	}

	public static RecordLayoutEntry getRecordLayoutEntry(String recordName) {
		return recordTable.get(recordName);
	}

	public static void putRecordLayoutEntry(String recordName,RecordLayoutEntry rlEntry) {
		recordTable.put(recordName,rlEntry);
	}
	
	public static int getBasePointerType(int type) {
	    switch (type) {
	    case POINTER_CHAR_TYPE:
	    	return CHAR_TYPE;
	    case POINTER_INT_TYPE:
	    	return INT_TYPE;
	    case POINTER_FLOAT_TYPE:
	    	return FLOAT_TYPE;
	    case POINTER_NO_TYPE:
	    	return NO_TYPE;
	    case ANY_TYPE:
	    	return ANY_TYPE;
	    default:
	    	return ERROR_TYPE;
	    }

	}
}
