package todo.forms;

public class IndexForm {

	private String list_id;
	private String title;
	private String importance;
	private String limit_time;

	public IndexForm(String list_id, String title, String importance, String limit_time) {
		super();
		this.list_id = list_id;
		this.title = title;
		this.importance = importance;
		this.limit_time = limit_time;
	}

	public String getList_id() {
		return list_id;
	}
	public void setList_id(String list_id) {
		this.list_id = list_id;
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
	public String getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(String limit_time) {
		this.limit_time = limit_time;
	}


}
