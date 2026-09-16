package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;
import util.DBUtil;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		User value = (User) session.getAttribute("user");
		System.out.println(value);
		int userId = value.getId();
		String message = request.getParameter("message");

        
		String sql = "INSERT INTO posts (user_id, content) "
				   + "VALUES (?, ?)";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.setString(2, message);

			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
		
	}
}
