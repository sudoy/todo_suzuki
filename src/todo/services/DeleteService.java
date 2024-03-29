package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import todo.utils.DBUtils;

public class DeleteService {

	public int delete(String listId) throws ServletException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;
		String sql = null;
		ResultSet rs = null;

		try {

			//データベース接続
			con = DBUtils.getConnection();

			//SQL実行
			sql = "DELETE FROM list WHERE list_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, listId); //削除するidの設定
			int i = ps.executeUpdate();


			//idを連番にしたいとき
			sql = "SET @i := 0";
			ps2 = con.prepareStatement(sql);
			ps2.executeUpdate();

			sql = "UPDATE list SET list_id = (@i := @i +1) ORDER BY list_id";
			ps3 = con.prepareStatement(sql);
			ps3.executeUpdate();

			sql = "SELECT count(list_id) AS cnt FROM list";
			ps4 = con.prepareStatement(sql);
			rs = ps4.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");

			sql = "ALTER table list auto_increment = ?";
			ps5 = con.prepareStatement(sql);
			ps5.setInt(1, cnt + 1);
			ps5.executeUpdate();

			return i;

		} catch (Exception e) {
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps, rs);
			DBUtils.close(ps2,ps3,ps4,ps5);

		}
	}
}
