package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import todo.forms.IndexForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class IndexService {

	public List<IndexForm> findTodoList() throws ServletException{

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		List<IndexForm> list = new ArrayList<>();;

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
				String list_id = rs.getString("list_id");
				String title = rs.getString("title");
				String importance = rs.getString("importance");
				String limit_time = rs.getString("limit_time");
				//フォーマット変更
				importance = HTMLUtils.importanceFormat(importance);
				limit_time = HTMLUtils.dateFormat(limit_time);
				IndexForm f = new IndexForm(list_id, title, importance, limit_time);
				list.add(f);
			}

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps, rs);
		}

		return  list;
	}
}
