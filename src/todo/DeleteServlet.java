package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.services.DeleteService;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String listId = req.getParameter("listId");

		HttpSession session = req.getSession();
		if(listId.isEmpty()) {
			session.setAttribute("error", "No."+ listId +"の削除ができませんでした。");
		}else {
			int count = new DeleteService().delete(listId);
			if(count > 0) { //count…削除件数
				session.setAttribute("complete",  "No."+ listId +"のTodoを削除しました。");
			}else {
				session.setAttribute("error", "No."+ listId +"の削除ができませんでした。");
			}
		}
		resp.sendRedirect("index.html");
	}
}
