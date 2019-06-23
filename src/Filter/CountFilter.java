package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CountFilter
 */
@WebFilter("/*")
public class CountFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CountFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
        System.out.println(request.getRequestURL());
        System.out.println(request.getQueryString()); //问号后面实际的参数
        Object obj = request.getServletContext().getAttribute("counta");
        if(obj == null) {
        request.getServletContext().setAttribute("counta",0);
       	 System.out.println("filter第一次访问:0");
        }else {
       	 int count = (int)obj;
       	 count += 1;	
       	request.getServletContext().setAttribute("counta",count);
       	 System.out.println("filter第" + count +"次访问：");
        }
		chain.doFilter(request, rep);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
