package todo.forms;

public class IndexForm {

	private String listId;
	private String title;
	private String importance;
	private String limitTime;
	private String status;
	private String display;

	public IndexForm(String listId, String title, String importance, String limitTime, String status, String display) {
		super();
		this.listId = listId;
		this.title = title;
		this.importance = importance;
		this.limitTime = limitTime;
		this.status = status;
		this.display = display;
	}

	public IndexForm(String listId, String title, String importance, String limitTime, String status) {
		super();
		this.listId = listId;
		this.title = title;
		this.importance = importance;
		this.limitTime = limitTime;
		this.status = status;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
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

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
