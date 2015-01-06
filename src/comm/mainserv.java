package comm;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import comm.BaseDao;
 

 
@Controller
public class mainserv {
	
@Autowired
private MainService ms;  

@RequestMapping(value="/mainserv")
		public ModelAndView text(){	
 	System.out.println("old:"+ms.lookUser());  
	// List<Object> sdsd=  ms.getcount();	
   return new ModelAndView("../cs","str","123123123");
		}

}
