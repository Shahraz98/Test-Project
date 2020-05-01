package loginFiles;

public enum Option {
	Director, Employee;
	
	private Option() {
		
	}
	
	public String value() {
		return name();
	}
	public static Option fromvalue(String val) {
		
		return valueOf(val);
	}

}