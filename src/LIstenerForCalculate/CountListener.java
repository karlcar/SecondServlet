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
         System.out.println(request.getQueryString()); //�ʺź���ʵ�ʵĲ���
         Object obj = sre.getServletRequest().getAttribute("count");
         if(obj == null) {
        	 sre.getServletRequest().setAttribute("count",0);
        	 System.out.println("��һ�η���:0");
         }else {
        	 int count = (int)obj;
        	 count += 1;	
        	 sre.getServletRequest().setAttribute("count",count);
        	 System.out.println("��" + count +"�η��ʣ�");
         }
         
    }
	
}
