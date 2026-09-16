package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBUtil;

public class LoginDao {
	// ログインチェック
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT id, name, email, created_at "
				+ "FROM users WHERE email = ? AND password = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setString(2, password); 

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setCreatedAt(rs.getTimestamp("created_at"));
					return user;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
