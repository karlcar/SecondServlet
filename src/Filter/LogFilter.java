package Filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/admin/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//先打印用户访问的地址
		System.out.println("请求地址：" + req.getRequestURL());
		System.out.println("请求参数：");
		//打印所有的请求参数
		Enumeration<String> e = req.getParameterNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getParameter(key);
			System.out.println(key + "=" + value);
		}
		
		System.out.println("所有的头：");
		//打印所有的header
		Enumeration<String> headers = req.getHeaderNames();
		while(headers.hasMoreElements()) {
			String key = headers.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + "=" + value);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
