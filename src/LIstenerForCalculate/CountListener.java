package LIstenerForCalculate;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
         System.out.println(request.getRequestURL());
         System.out.println(request.getQueryString()); //问号后面实际的参数
         Object obj = sre.getServletRequest().getAttribute("count");
         if(obj == null) {
        	 sre.getServletRequest().setAttribute("count",0);
        	 System.out.println("第一次访问:0");
         }else {
        	 int count = (int)obj;
        	 count += 1;	
        	 sre.getServletRequest().setAttribute("count",count);
        	 System.out.println("第" + count +"次访问：");
         }
         
    }
	
}
