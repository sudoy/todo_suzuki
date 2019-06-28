package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import todo.forms.EntryForm;
import todo.utils.DBUtils;

public class EntryService {

	public void insert(EntryForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		try{
			//データベース接続
	        con = DBUtils.getConnection();

			sql = "INSERT INTO list(title, detail, importance, limit_time) VALUES(?,?,?,?)";
			//INSERT命令の準備
			ps = con.prepareStatement(sql);

			//INSERT命令にポストデータの内容をセット
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getDetail());
			ps.setString(3, form.getImportance());
				//期限が空欄の場合
			String LimitTime = form.getLimitTime();
			if(LimitTime.equals("")) {
				LimitTime = null;
			}
			ps.setString(4, LimitTime);

			//INSERT命令を実行
			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			DBUtils.close(con, ps);
		}
	}
}
