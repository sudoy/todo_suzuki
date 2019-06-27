package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		List<Map<String,String>> list = new ArrayList<>();

		try{
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "SELECT list_id,title,importance,limit_time FROM list ORDER BY list_id";
			//SELECT命令の準備・実行
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			//リストに追加
			while(rs.next()){
				HashMap<String, String> sm = new HashMap<>();
				sm.put("list_id",rs.getString("list_id"));
				sm.put("title",rs.getString("title"));
				sm.put("importance",rs.getString("importance"));
				sm.put("limit_time",rs.getString("limit_time"));
				list.add(sm);
			}

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps, rs);
		}

		req.setAttribute("list", list);

		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
