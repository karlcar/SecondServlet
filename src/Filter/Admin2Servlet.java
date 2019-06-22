package Filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin2Servlet
 */
@WebServlet("/admin/Admin2Servlet")
public class Admin2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("这是管理员页面2");
		
//		if ( session.getAttribute("username") == null) {
//			//用户不存在，回到登录页面
//			response.sendRedirect("../login.html");
//		}else {
//			String username = (String)session.getAttribute("username");
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().append(username + "欢迎回来Admin2页面!");
//		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		response.getWriter().append(username + "欢迎回来Admin2页面!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
