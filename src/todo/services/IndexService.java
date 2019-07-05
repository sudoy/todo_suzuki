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

	public List<IndexForm> findTodoList(String display, String sort) throws ServletException{

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;
		List<IndexForm> list = new ArrayList<>();

		try{
			//データベース接続
			con = DBUtils.getConnection();

			//ソートの値に何も入ってないとき
			if(sort == null || sort.equals("")) {
				sort = "list_id";
			}

			//SQL
			sql = "SELECT list_id,title,importance,limit_time,status FROM list ORDER BY " + sort;
			//SELECT命令の準備・実行
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			//リストに追加
			while(rs.next()){
				String listId = rs.getString("list_id");
				String title = rs.getString("title");
				String importance = rs.getString("importance");
				String limitTime = rs.getString("limit_time");
				String status = rs.getString("status");
				//フォーマット変更
				importance = HTMLUtils.importanceFormat(importance);
				limitTime = HTMLUtils.dateFormat(limitTime);

				IndexForm f = new IndexForm(listId, title, importance, limitTime, status);

				//未完了のみ表示の時
				if(display != null && display.equals("incomp") && status.equals("1")) { //
					f = new IndexForm(listId, title, importance, limitTime, status,"hide");
				}

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
