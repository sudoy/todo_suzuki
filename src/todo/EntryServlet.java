package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.EntryForm;
import todo.services.EntryService;
import todo.utils.HTMLUtils;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインのチェック
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			session.setAttribute("error", "ログインしてください");
			resp.sendRedirect("login.html");
			return;
		}

		HTMLUtils htmlUtils = new HTMLUtils();
		req.setAttribute("htmlUtils",htmlUtils);
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//入力情報を取得
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String importance = req.getParameter("importance");
		if(importance == null) {importance = "";}
		String limitTime = req.getParameter("limitTime");
		EntryForm f = new EntryForm(title, detail, importance, limitTime);

		//バリデーション
		List<String> error = new ArrayList<>();
		error = validate(f);//エラーメッセージのリストを取得

		//insert
		HttpSession session = req.getSession();
		if(error.isEmpty()) {//リストが空だったら実行
			new EntryService().insert(f);
			session.setAttribute("complete", "新しいTodoを登録しました。");
			resp.sendRedirect("index.html");
		}else {
			session.setAttribute("error", error);
			req.setAttribute("form", f);
			HTMLUtils htmlUtils = new HTMLUtils(importance);
			req.setAttribute("htmlUtils",htmlUtils);
			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
		}
	}

	//バリデーション
	private List<String> validate(EntryForm form) {

		List<String> error = new ArrayList<>();

		//タイトル
		if(form.getTitle().equals("")) {
			error.add("題名は必須入力です。");
		}else if(100 < form.getTitle().length()) {
			error.add("題名は100文字以内にしてください。");
		}
		//期限
		String lt = form.getLimitTime();
		if(!lt.isEmpty()) {
			if(lt.matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}$")) {
				try {
					LocalDate.parse(lt.replace("/", "-"));
				} catch (Exception e) {
					error.add("入力した月日が不正です。");
				}
			}else {
				error.add("期限は「YYYY/MM/DD」形式で入力して下さい。");
			}
		}
		//重要度
		if(!form.getImportance().matches("^[1-3]$")) {
			error.add("重要度のチェックでエラーが発生しました。");
		}

		return error;
	}
}
