package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.LoginDao;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// フォームの値を受け取る
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// DAO を呼び出す
		LoginDao dao = new LoginDao();
		User user = dao.findByEmailAndPassword(email, password);

		if (user != null) {
			// ログイン成功時の処理
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.setAttribute("message", "ログイン成功（仮状態。実装が進んだら掲示板ページへ）");
			response.sendRedirect("boardServlet");
		} else {
			// ログイン失敗
			request.setAttribute("message", "メールアドレスまたはパスワードが違います");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
