package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインのチェック
		HttpSession session = req.getSession();
		if(session.getAttribute("username") == null) {
			session.setAttribute("error", "ログインしてください");
			resp.sendRedirect("login.html");
			return;
		}

		//表示の切り替えの値をセッションに保存
		String display = req.getParameter("display");
		if(display != null) { //ボタンを押したときだけ更新
			session.setAttribute("display", display);
		}

		//ソートの値をセッションに保存
		String sort = req.getParameter("sort");
		if(sort != null) { //ボタンを押したときだけ更新
			session.setAttribute("sort", sort);
		}


		resp.sendRedirect("index.html");
	}
}
