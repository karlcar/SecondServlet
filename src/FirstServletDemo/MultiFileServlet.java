package FirstServletDemo;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MultiFileServlet
 */
@MultipartConfig
@WebServlet("/MultiFileServlet")
public class MultiFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> conn = request.getParts(); 
		for (Iterator iterator = conn.iterator(); iterator.hasNext();) {
			Part part = (Part) iterator.next();
			String fileName = part.getSubmittedFileName();
			String filePath = "d:\\学习文件\\" + fileName;
			try {
				this.writeToFile(filePath, part.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//写文件到磁盘的方法
	private void writeToFile(String filePath,InputStream is) throws Exception {
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] cache = new byte[1024*1024];
		int len = 0;
		while((len = is.read()) != -1) {
			os.write(cache,0,len);
			os.flush();
		}
		os.close();
	}

}
