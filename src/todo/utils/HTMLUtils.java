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

	public static String dateFormat(String limit) {

		String date = limit;
		if(limit != null) {
			date = limit.replace("-", "/");
		}

		return date;
	}

}
