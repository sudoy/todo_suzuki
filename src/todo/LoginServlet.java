package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.services.LoginService;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ログインしてないときのエラーメッセージ
		HttpSession session = req.getSession();
		req.setAttribute("error", session.getAttribute("error"));
		session.invalidate();

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//入力情報
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");

		//ログインのチェック
		String username = new LoginService().login(mail,password);
		if(username != null){
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("index.html");
		}else{
			req.setAttribute("error", "メールアドレス、またはパスワードが間違っています。");
			req.setAttribute("inputMail", mail);
			getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
	}
}
