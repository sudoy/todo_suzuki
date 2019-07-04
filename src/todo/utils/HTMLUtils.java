package todo.utils;

public class HTMLUtils {

	public static String importanceFormat(String importance) {

		int num = Integer.parseInt(importance);
		String star = "";
		for(int i = 0; i < num; i++) {
			star += "★";
		}
		return star;
	}

	public static String dateFormat(String limitTime) {

		String date = limitTime;
		if(limitTime != null) {
			date = limitTime.replace("-", "/");
		}

		return date;
	}

	public static String createRadioTags(int num, String importance){ //重要度のラジオボタンタグ生成 (entry,update)

		String radioTag = "";
		String imp = (importance == null) ? "3" : importance;

		if(num == 3) {
			if(imp.isEmpty() || imp.equals("3")) {
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"3\" checked>";
			}else if(!imp.equals("3")){
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"3\">";
			}
		}else if(num == 2) {
			if(!imp.equals("2")) {
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"2\">";
			}else if(imp.equals("2")){
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"2\" checked>";
			}
		}else if(num == 1) {
			if(!imp.equals("1")) {
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"1\">";
			}else if(imp.equals("1")){
				radioTag = "<input type=\"radio\" name=\"importance\" value=\"1\" checked>";
			}
		}

		return radioTag;
	}

	public static String createStatusTags(int num, String status){ //ステータスのラジオボタンタグ生成（update)

		String statusTag = "";
		String sta = (status == null) ? "0" : status;

		if(num == 0) { //未完了…0
			if(sta.isEmpty() || sta.equals("0")) {
				statusTag = "<input type=\"radio\" name=\"status\" value=\"0\" checked>";
			}else if(!sta.equals("0")){
				statusTag = "<input type=\"radio\" name=\"status\" value=\"0\">";
			}
		}else if(num == 1) { //完了…1
			if(!sta.equals("1")) {
				statusTag = "<input type=\"radio\" name=\"status\" value=\"1\">";
			}else if(sta.equals("1")){
				statusTag = "<input type=\"radio\" name=\"status\" value=\"1\" checked>";
			}
		}

		return statusTag;
	}

	public static String createStatusCheckbox(String status, String listId) { //ステータスのチェックボックスタグ生成 (index)

		String checkbox = "";
		if(status.equals("0")) { //未完了…0
			checkbox = "<input type=\"checkbox\" name=\"status\" value=\""+ listId +"\">";
		}else if(status.equals("1")) { //完了…1
			checkbox = "<input type=\"checkbox\" name=\"status\" value=\""+ listId +"\" checked>";
		}

		return checkbox;
	}

	public static String createButtonClass(int num, String display) {

		String buttonClass = "class=\"btn btn-warning\"";
		if(num == 0) { //未完了ボタン
			if(display != null && display.equals("incomp")) {
				buttonClass = "class=\"btn btn-warning active\"";
			}
		}else if(num == 1) { //完了ボタン
			if(display == null || display.equals("all") || display.equals("")) {
				buttonClass = "class=\"btn btn-warning active\"";
			}
		}
		return buttonClass;
	}

	public static String textEscape(String text) {

		if(text.contains("<")) {
			text = text.replace("<", "&lt;");
		}
		if(text.contains(">")) {
			text = text.replace(">", "&gt;");
		}

		return text;
	}

}
