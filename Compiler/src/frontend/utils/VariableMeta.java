package frontend.utils;

public class VariableMeta {
	
	public int type;
	public int offset;
	public boolean isString;
	public boolean isFloat;
	public String stringVal;
	public Float floatVal;
	public String staticLocation;
	
	public VariableMeta() {
		type = -1;
		offset = -1;
		isString = false;
		isFloat = false;
		staticLocation = "";
	}
	
	

}
