package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;

public class RegisterDao {
	// ユーザー登録
    public boolean register(String name, String email,String password) {

    	String sql = "INSERT INTO users (name, email, password) "
				+ "VALUES (?, ?, ?)";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password); 
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        
        return true;
    }
}
