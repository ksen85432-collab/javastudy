package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォームの値を受け取る
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// UserModel を作成
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		// DAO を呼び出す
		RegisterDao dao = new RegisterDao();
		boolean result = dao.register(name, email, password);
		System.out.println(result);

		if (result) {
			
			request.setAttribute("message", "登録成功");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} else {
			// 登録失敗
			request.setAttribute("message", "登録失敗");
			
		}

		// register.jsp に戻す
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

}
