package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.services.IndexService;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//formのリストを取得してJSPへ
		req.setAttribute("list", new IndexService().findTodoList());

		//メッセージを表示・リセット
		HttpSession session = req.getSession();
		req.setAttribute("complete", session.getAttribute("complete"));
		if(session.getAttribute("error").toString().contains("削除")) {
			req.setAttribute("error", session.getAttribute("error"));
		}
		session.setAttribute("complete", "");
		session.setAttribute("error", "");


		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
