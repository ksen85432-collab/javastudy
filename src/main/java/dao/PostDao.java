package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import util.DBUtil;

public class PostDao {
	public List<Post> getPostDatalist() {
		List<Post> list = new ArrayList<>();
		String sql = "SELECT posts.id, name, content, posts.created_at "
				+ "FROM users INNER JOIN posts ON posts.user_id = users.id ORDER BY posts.created_at DESC";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					Post user = new Post();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setContent(rs.getString("content"));
					user.setCreatedAt(rs.getTimestamp("created_at"));
					list.add(user);					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
