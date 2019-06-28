package todo.utils;

public class HTMLUtils {

	private String importance;

	public HTMLUtils() {}
	public HTMLUtils(String importance) {
		super();
		this.importance = importance;
	}


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

	public String creareRadioTags(int num){

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

}
