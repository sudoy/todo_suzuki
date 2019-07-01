package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import todo.utils.DBUtils;

public class DeleteService {

	public void delete(String listId) throws ServletException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {

			//データベース接続
			con = DBUtils.getConnection();

			//SQL実行
			sql = "delete from list where list_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, listId); //削除するidの設定
			ps.executeUpdate();


		} catch (Exception e) {
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps);
		}
	}
}
