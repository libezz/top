package top.type;

public enum ResultStatusType {

	SUCCEED(0, "请求成功"),
	MISSING(1, "路径失效"),
	UNROLE(2, "权限不足"),
	THROW(3, "参数异常"),
	EXCEPTION(4, "系统繁忙");
	
	private int value;
	private String name;
	
	private ResultStatusType(int value, String name) {
		this.value = value;
		this.name= name;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
