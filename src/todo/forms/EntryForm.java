package todo.forms;

public class EntryForm {

	private String title;
	private String detail;
	private String importance;
	private String limit;

	public EntryForm(String title, String detail, String importance, String limit) {
		super();
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.limit = limit;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

}
