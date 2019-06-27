package todo.forms;

public class IndexForm {

	private String id;
	private String title;
	private String importance;
	private String limit;

	public IndexForm(String id, String title, String importance, String limit) {
		super();
		this.id = id;
		this.title = title;
		this.importance = importance;
		this.limit = limit;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
