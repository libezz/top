package top.param;

public class PageParam extends BaseParam {

	private int page;
	private int size;
	private int sortDir;
	private int sortBy;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSortDir() {
		return sortDir;
	}
	public void setSortDir(int sortDir) {
		this.sortDir = sortDir;
	}
	public int getSortBy() {
		return sortBy;
	}
	public void setSortBy(int sortBy) {
		this.sortBy = sortBy;
	}
}
