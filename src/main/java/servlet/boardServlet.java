package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.postDao;
import model.post;

@WebServlet("/boardServlet")
public class boardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	postDao dao = new postDao();
	List<post> user = dao.getPostDatalist();

	
		// ログイン成功時の処理
		HttpSession session = request.getSession();
		
		request.setAttribute("postdate", user);
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
	
	}
}
