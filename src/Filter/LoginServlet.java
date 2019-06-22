package Filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("所有人都可以访问的页面");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//跳到Admin1Servlet
		HttpSession session = request.getSession();
		//用户的信息存到session里面
		session.setAttribute("username", username);
		//此时用户登录成功
		if(username.equalsIgnoreCase("admin1") && password.equalsIgnoreCase("1234")) {
			response.sendRedirect("admin/Admin1Servlet?username=" + username + "&password=" + password);
		}else if(username.equalsIgnoreCase("admin2") && password.equalsIgnoreCase("1234")){
			response.sendRedirect("admin/Admin2Servlet?username=" + username + "&password=" + password);
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
