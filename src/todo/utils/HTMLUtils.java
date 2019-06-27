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

	public static String dateFormat(String limit_time) {

		String date = limit_time;
		if(limit_time != null) {
			date = limit_time.replace("-", "/");
		}

		return date;
	}

}
