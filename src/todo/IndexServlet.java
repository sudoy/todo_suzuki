package todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.services.IndexService;
import todo.services.UpdateService;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインのチェック
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			session.setAttribute("error", "ログインしてください");
			resp.sendRedirect("login.html");
			return;
		}

		//表示の切り替えの値を取得
		String display = req.getParameter("display");
		if(display != null) { //ボタンを押したときだけ更新
			session.setAttribute("display", display);
		}
		display = (String) session.getAttribute("display");

		//formのリストを取得してJSPへ
		req.setAttribute("list", new IndexService().findTodoList(display));

		//メッセージを表示・リセット
		req.setAttribute("complete", session.getAttribute("complete"));
		Object error = session.getAttribute("error");
		if(error != null && error.toString().contains("削除")) {
			req.setAttribute("error", error);
		}
		session.setAttribute("complete", "");
		session.setAttribute("error", "");


		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
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

		//完了・未完了の更新、メッセージ追加
		List<String> complete = new UpdateService().updateStatus(req.getParameterValues("status"));
		session.setAttribute("complete", complete);

		resp.sendRedirect("index.html");
	}
}
