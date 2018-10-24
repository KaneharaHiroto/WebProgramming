package Dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import Model.USER;



public class UserDao {
	public USER findByLoginInfo(String login_id, String Password)  {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();

			String sql="SELECT * FROM user WHERE login_id = ? and password = ?";

			String source = Password;
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";

			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

			PreparedStatement PS = conn.prepareStatement(sql);
			PS.setString(1, login_id);
			PS.setString(2, result);

			ResultSet re=PS.executeQuery();
			if(!re.next()){
				return null;
			}
			String login_idData= re.getString("login_id");
			String nameData= re.getString("name");
			return new USER(login_idData,nameData);

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	public List<USER> findAll(){
		Connection conn= null;
		List<USER> uslist=new ArrayList<USER>();

		try {
			conn= DBManager.getConnection();
			String sql="SELECT * FROM user WHERE login_id NOT IN ('admin')";

			Statement stmt= conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);

			while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                USER user = new USER(id, loginId, name, birthDate, password, createDate, updateDate);

                uslist.add(user);
			}

		}catch(SQLException e){
			return null;

		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return uslist;
	}
	public USER CheckByLoginId(String login_id) {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();

			String sql="SELECT * FROM user WHERE login_id = ?";
			PreparedStatement PS = conn.prepareStatement(sql);
			PS.setString(1, login_id);
			ResultSet re=PS.executeQuery();
			if(!re.next()){
				return null;
			}
			String name= re.getString("name");
			String loginid= re.getString("login_id");
			USER user=new USER(name,loginid);
			return user;
		}catch(SQLException e){
			return null;

		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
	public void cruser(String login_id,String Password,String name,String birthDate) {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();

			String sql="INSERT INTO user(login_id,password,name,birth_date,create_date,update_date) VALUES(?,?,?,?,now(),now())";
			String source = Password;
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";

			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

			PreparedStatement PS = conn.prepareStatement(sql);
			PS.setString(1, login_id);
			PS.setString(2, result);
			PS.setString(3, name);
			PS.setString(4, birthDate);
			PS.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public USER findSelect(String id){
		Connection conn= null;

		try {
			conn= DBManager.getConnection();
			String sql="SELECT * FROM user WHERE id = ?";

			PreparedStatement stmt= conn.prepareStatement(sql);

			stmt.setString(1, id);

			ResultSet rs=stmt.executeQuery();

			if (rs.next()) {
                int ID = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                USER user = new USER(ID, loginId, name, birthDate, password, createDate, updateDate);

                return user;
			}
		}catch(SQLException e){
			return null;

		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	public void PassUp(String Password, String name,String birthDate,String id) {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();

			String sql="UPDATE user SET password = ? , name = ? , birth_date = ? , update_date = now() WHERE id=?";
			String source = Password;
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";

			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

			PreparedStatement PS = conn.prepareStatement(sql);

			PS.setString(1,result);
			PS.setString(2, name);
			PS.setString(3, birthDate);
			PS.setString(4,id);
			PS.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	public void NoPassUp(String name,String birthDate,String id) {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();

			String sql="UPDATE user SET name = ?  , birth_date = ?  , update_date = now() WHERE id = ?";
			PreparedStatement PS = conn.prepareStatement(sql);
			PS.setString(1, name);
			PS.setString(2,birthDate);
			PS.setString(3,id);
			PS.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	public void Delete(String id) {
		Connection conn=null;
		try {
			conn=DBManager.getConnection();
			String sql="DELETE FROM user WHERE id=?";
			PreparedStatement PS = conn.prepareStatement(sql);
			PS.setString(1,id);
			PS.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public List<USER> search(String login_id, String name,String rowdate, String highdate){
		Connection conn= null;
		List<USER> uslist=new ArrayList<USER>();

		try {
			conn=DBManager.getConnection();
		String sql="SELECT * FROM user WHERE login_id NOT IN ('admin')";

		if(!login_id.equals("")) {
			sql += " AND login_id = '" + login_id + "'";
		}

		if(!name.equals("")) {
			sql += " AND name LIKE '%" + name + "%'";
		}
		if(!rowdate.equals("")) {
			sql += " AND birth_date >= '" + rowdate + "'";
		}
		if(!highdate.equals("")) {
			sql += " AND birth_date <= '" + highdate + "'";
		}

		Statement stmt= conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
	            int id = rs.getInt("id");
	            String loginId = rs.getString("login_id");
	            String Name = rs.getString("name");
	            Date birthDate = rs.getDate("birth_date");
	            String password = rs.getString("password");
	            String createDate = rs.getString("create_date");
	            String updateDate = rs.getString("update_date");
	            USER user = new USER(id, loginId, Name, birthDate, password, createDate, updateDate);
                uslist.add(user);
			}

		}catch(SQLException e){
			return null;

		}finally {
			if(conn !=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return uslist;

	}
}

