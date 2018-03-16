package top.type;

import org.springframework.data.domain.Sort.Direction;

public enum SortDirType {

	DESC(0, Direction.DESC),
	ASC(1, Direction.ASC);
	
	private int value;
	private Direction sortDir;
	
	private SortDirType(int value, Direction sortDir) {
		this.value = value;
		this.sortDir = sortDir;
	}
	
	public static SortDirType getType(int value) {
		for(SortDirType type : values()) {
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
	public Direction getSortDir() {
		return sortDir;
	}
	public void setSortDir(Direction sortDir) {
		this.sortDir = sortDir;
	}
}
