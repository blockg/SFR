package comm;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Getinfo {

	
	public void pt(HttpServletRequest request, HttpServletResponse response)
	{
		 String uri=request.getRequestURI();  
	        String rad = request.getRemoteAddr();  
	        String rh = request.getRemoteHost();  
	        String ru = request.getRemoteUser();  
	        int rp = request.getRemotePort();  
	        String cp = request.getContextPath();  
	        String la = request.getLocalAddr();  
	        String ce = request.getCharacterEncoding();  
	        String gm = request.getMethod();  
	        String qs = request.getQueryString();  

	        System.out.println(uri);  
	        System.out.println(rad);  
	        System.out.println(rh);  
	        System.out.println(ru);  
	        System.out.println(rp);  
	        System.out.println(cp);  
	        System.out.println(la);  
	        System.out.println(ce);  
	        System.out.println(gm);  
	        System.out.println(qs); 
	        
	        System.out.println(request.getHeader("method"));  
	        Enumeration e = request.getHeaderNames();  
	        while(e.hasMoreElements()){  
	            String name = (String)e.nextElement();  
	            String value = request.getHeader(name);  
	            System.out.println(name+":"+value);  
	        }  
		
		
	}
	
}
