package todo.forms;

public class EntryForm {

	private String title;
	private String detail;
	private String importance;
	private String limit_time;

	public EntryForm(String title, String detail, String importance, String limit_time) {
		super();
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.limit_time = limit_time;
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
	public String getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}

}
