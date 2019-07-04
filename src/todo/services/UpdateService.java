package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			sql = "SELECT title,detail,importance,limit_time,status FROM list WHERE list_id = ? ORDER BY list_id";
			//SELECT命令の準備・実行
			ps = con.prepareStatement(sql);
			ps.setString(1, listId);
			rs = ps.executeQuery();


			//update.jspに渡すform用意
			String title = "";
			String detail = "";
			String importance = "";
			String limitTime = "";
			String status = "";
			while(rs.next()){
				title = rs.getString("title");
				detail = rs.getString("detail");
				importance = rs.getString("importance");
				limitTime = rs.getString("limit_time");
				//フォーマット変更
				limitTime = HTMLUtils.dateFormat(limitTime);
				status = rs.getString("status");
			}
			form = new UpdateForm(listId, title, detail, importance, limitTime, status);

		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			DBUtils.close(con, ps, rs);
		}

		return  form;
	}

	public void update(UpdateForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		try{
			//データベース接続
	        con = DBUtils.getConnection();

			sql = "UPDATE list SET title = ?, detail = ?, importance = ?, limit_time = ?, status = ? WHERE list_id = ?";
			//UPDATE命令の準備
			ps = con.prepareStatement(sql);

			//UPDATE命令にポストデータの内容をセット
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getDetail());
			ps.setString(3, form.getImportance());
				//期限が空欄の場合
			String LimitTime = form.getLimitTime();
			if(LimitTime.equals("")) {
				LimitTime = null;
			}
			ps.setString(4, LimitTime);
			ps.setString(5, form.getStatus());
			ps.setString(6, form.getListId());

			//UPDATE命令を実行
			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			DBUtils.close(con, ps);
		}
	}


	public List<String> updateStatus(String[] listId) {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String sql = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		try{
			//データベース接続
	        con = DBUtils.getConnection();

	        //変更前rs1
	        sql = "SELECT list_id, status FROM list ORDER BY list_id";
	        ps3 = con.prepareStatement(sql);
			rs1 = ps3.executeQuery();
			Map<Integer,Integer> before = new HashMap<>();
			while(rs1.next()) {
				before.put(rs1.getInt("list_id"), rs1.getInt("status"));
			}

	        if(listId != null) {

	        	/*配列内のidのtodoを完了にする（status = 1)*/
		        //SQLを準備
		        StringBuilder post = new StringBuilder();
		        for(int i = 0; i < listId.length - 1; i++) {
		        	post.append("?,");
		        }
		        post.append("?");
				sql = "UPDATE list SET status = 1 WHERE list_id in("+ post +")";

				//UPDATE命令にポストデータの内容をセット
				ps = con.prepareStatement(sql);
				for(int i = 0; i < listId.length; i++) {
					ps.setString((i + 1), listId[i]);
				}

				//UPDATE命令を実行
				ps.executeUpdate();


				/*それ以外のtodoを未完了にする（status = 0)*/
				sql = "UPDATE list SET status = 0 WHERE NOT list_id in("+ post +")";
				ps2 = con.prepareStatement(sql);
				for(int i = 0; i < listId.length; i++) {
					ps2.setString((i + 1), listId[i]);
				}

				//UPDATE命令を実行
				ps2.executeUpdate();

	        }else {
	        	//全部未完了にするとき
	        	sql = "UPDATE list SET status = 0";
	        	ps = con.prepareStatement(sql);
	        	ps.executeUpdate();
	        }

	        //変更後rs2
	        sql = "SELECT list_id, status FROM list ORDER BY list_id";
	        ps4 = con.prepareStatement(sql);
			rs2 = ps4.executeQuery();
			Map<Integer,Integer> after = new HashMap<>();
			while(rs2.next()) {
				after.put(rs2.getInt("list_id"), rs2.getInt("status"));
			}

	        //比較 //未完了…0 完了…1
			StringBuilder cn = new StringBuilder("");
			StringBuilder in = new StringBuilder("");
			for(Map.Entry<Integer, Integer> entryB : before.entrySet()) {
				for(Map.Entry<Integer, Integer> entryA : after.entrySet()) {
					if((entryB.getKey() == entryA.getKey()) && (entryB.getValue() < entryA.getValue())) {
						 cn.append(entryA.getKey());
					}else if((entryB.getKey() == entryA.getKey()) && (entryB.getValue() > entryA.getValue())) {
						in.append(entryA.getKey());
					}
				}
			}

			//メッセージをJSPへ渡す
			List<String> message = new ArrayList<>();

			String compNum = String.valueOf(cn);
			String incompNum = String.valueOf(in);
			DecimalFormat df = new DecimalFormat("#,#");

			if(!compNum.equals("")) {
				message.add("N0.["+ df.format(Integer.valueOf(compNum))+"]のTodoを完了にしました");
			}
			if(!incompNum.equals("")) {
				message.add("N0.["+  df.format(Integer.valueOf(incompNum)) +"]のTodoを未完了にしました");
			}

	        return message;


		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			DBUtils.close(con, ps);
			DBUtils.close(ps2,ps3,ps4);
			DBUtils.close(rs1);
			DBUtils.close(rs2);
		}
	}
}
