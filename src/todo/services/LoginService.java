package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import todo.utils.DBUtils;

public class LoginService {

	public String login(String inputMail, String inputPass) throws ServletException {

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String sql = null;
		String username = null;

		try{
			//データベース接続
			con = DBUtils.getConnection();

			//SQL…メールアドレスの確認
			sql = "SELECT count(id) AS user,name,password FROM account WHERE mail = ?";
			ps1 = con.prepareStatement(sql);
			ps1.setString(1, inputMail);
			rs1 = ps1.executeQuery();;
			rs1.next();

			if(rs1.getInt("user") == 1) { //メール一致する人がいたら以下実行

				//ユーザ情報
				String userPass = rs1.getString("password");
				String name = rs1.getString("name");

				//パスワードの確認
				sql = "SELECT SHA2(?,256) AS inputPass";
				ps2 = con.prepareStatement(sql);
				ps2.setString(1, inputPass);
				rs2 = ps2.executeQuery();
				rs2.next();
				if(rs2.getString("inputPass").equals(userPass)) {
					username = name;
				}

			}

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps1, rs1);
			DBUtils.close(ps2, rs2);
		}

		return username;
	}
}
