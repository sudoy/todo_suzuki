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

import todo.forms.UpdateForm;
import todo.services.UpdateService;
import todo.utils.HTMLUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインのチェック
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			session.setAttribute("error", "ログインしてください");
			resp.sendRedirect("login.html");
			return;
		}

		//index.jspからlist_idの値を取得
		String listId = req.getParameter("listId");

		//update.jspにformを渡す
		UpdateForm form = new UpdateService().findListOf(listId);
		req.setAttribute("form", form);

		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインのチェック
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			session.setAttribute("error", "ログインしてください");
			resp.sendRedirect("login.html");
			return;
		}

		//入力情報を取得
		req.setCharacterEncoding("UTF-8");
		String title = HTMLUtils.textEscape(req.getParameter("title"));
		String detail = HTMLUtils.textEscape(req.getParameter("detail"));
		String importance = req.getParameter("importance");
		if(importance == null) {importance = "";}
		String limitTime = req.getParameter("limitTime");
		String listId = req.getParameter("listId");
		String status = req.getParameter("status");
		UpdateForm f = new UpdateForm(listId, title, detail, importance, limitTime, status);


		//バリデーション
		List<String> error = validate(f);//エラーメッセージのリストを取得

		//insert
		if(error.isEmpty()) {//リストが空だったら実行
			new UpdateService().update(f);
			List<String> complete = new ArrayList<>();
			complete.add("No."+ listId +"のTodoを更新しました。");
			session.setAttribute("complete", complete);
			resp.sendRedirect("index.html");
		}else {
			session.setAttribute("error", error);
			req.setAttribute("form", f);
			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
		}
	}

	//バリデーション
	private List<String> validate(UpdateForm form) {

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
			error.add("重要度の選択でエラーが発生しました。");
		}

		//id
		if(form.getListId().isEmpty()) {
			error.add("エラーが発生しました。");
		}

		return error;
	}
}
