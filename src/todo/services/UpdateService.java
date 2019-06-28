package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import todo.forms.UpdateForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class UpdateService {

	public UpdateForm findListOf(String listId) throws ServletException{

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		UpdateForm form;

		try{
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "SELECT title,detail,importance,limit_time FROM list WHERE list_id = ? ORDER BY list_id";
			//SELECT命令の準備・実行
			ps = con.prepareStatement(sql);
			ps.setString(1, listId);
			rs = ps.executeQuery();


			//update.jspに渡すform用意
			String title = "";
			String detail = "";
			String importance = "";
			String limitTime = "";
			while(rs.next()){
				title = rs.getString("title");
				detail = rs.getString("detail");
				importance = rs.getString("importance");
				limitTime = rs.getString("limit_time");
				//フォーマット変更
				limitTime = HTMLUtils.dateFormat(limitTime);
			}
			form = new UpdateForm(title, detail, importance, limitTime);

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps, rs);
		}

		return  form;
	}
}
