package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.services.DeleteService;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String listId = req.getParameter("listId");

		if(listId.isEmpty()) {
			//
		}else {
			new DeleteService().delete(listId);
		}
		resp.sendRedirect("index.html");
	}
}
