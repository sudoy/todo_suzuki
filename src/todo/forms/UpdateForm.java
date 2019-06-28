package todo.forms;

public class UpdateForm {

	private String listId;
	private String title;
	private String detail;
	private String importance;
	private String limitTime;

	public UpdateForm(String listId, String title, String detail, String importance, String limitTime) {
		super();
		this.listId = listId;
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.limitTime = limitTime;
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

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

}
