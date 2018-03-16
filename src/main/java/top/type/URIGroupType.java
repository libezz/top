package top.type;

import top.global.UserRole;

public enum URIGroupType {

	MAIN(0, "index.html", false, null),
	DEFAULT(1, "default", true, null),
	HTML(101, "html", true, null),
	JS(102, "js", true, null),
	CSS(103, "css", true, null),
	IMG(104, "img", true, null),
	USER(201, "user", false, UserRole.SIGN_IN);
	
	private int value;
	private String name;
	private boolean logFilte;
	private Long needRole;
	
	private URIGroupType(int value, String name, boolean logFilte, Long needRole) {
		this.value = value;
		this.name = name;
		this.logFilte = logFilte;
		this.needRole = needRole;
	}
	
	public static URIGroupType getTypeByName(String name) {
		for(URIGroupType type : values()) {
			if(type.getName().equals(name)) {
				return type;
			}
		}
		return null;
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
	public boolean isLogFilte() {
		return logFilte;
	}
	public void setLogFilte(boolean logFilte) {
		this.logFilte = logFilte;
	}
	public Long getNeedRole() {
		return needRole;
	}
	public void setNeedRole(Long needRole) {
		this.needRole = needRole;
	}
}
