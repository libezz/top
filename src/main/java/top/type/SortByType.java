package top.type;

public enum SortByType {

	ID(0, "id"),
	CREATE_DATE(1, "create_date"),
	LAST_MODIFIED_DATE(2, "last_modified_date");
	
	private int value;
	private String sortBy;
	
	private SortByType(int value, String sortBy) {
		this.value = value;
		this.sortBy = sortBy;
	}
	
	public static SortByType getType(int value) {
		for(SortByType type : values()) {
			if(type.getValue() == value) {
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
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
