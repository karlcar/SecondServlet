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
		response.getWriter().append("�����˶����Է��ʵ�ҳ��");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����Admin1Servlet
		HttpSession session = request.getSession();
		//�û�����Ϣ�浽session����
		session.setAttribute("username", username);
		//��ʱ�û���¼�ɹ�
		if(username.equalsIgnoreCase("admin1") && password.equalsIgnoreCase("1234")) {
			response.sendRedirect("admin/Admin1Servlet?username=" + username + "&password=" + password);
		}else if(username.equalsIgnoreCase("admin2") && password.equalsIgnoreCase("1234")){
			response.sendRedirect("admin/Admin2Servlet?username=" + username + "&password=" + password);
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
