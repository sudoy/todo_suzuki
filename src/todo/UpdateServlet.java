package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.UpdateForm;
import todo.services.UpdateService;
import todo.utils.HTMLUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//index.jspからlist_idの値を取得
		String listId = req.getParameter("listId");

		//update.jspにformを渡す
		UpdateForm form = new UpdateService().findListOf(listId);
		req.setAttribute("form", form);
		HTMLUtils htmlUtils = new HTMLUtils(form.getImportance());
		req.setAttribute("htmlUtils",htmlUtils);

		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}
}
