package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
import comm.DBcooper;
import comm.DB.UserDao;
import comm.DB.wcdbmap;

/**
 * Servlet implementation class main
 */

@WebServlet("/main")
public class main extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	DBcooper dbcooper = new DBcooper();
	Getinfo gtf=new Getinfo();
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public main() {
		super();
	 	 

   
        System.out.print("asdasd");
        
        //	dbcooper.dbinit();
        
        
        
		
		
		
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		String fmn = request.getParameter("form");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (1 == 1) {

			response.getWriter().println(
					"------setSession() is ok--------" + un + "  " + pw + "  "
							+ fmn);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ////////

		// ////////

		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		String fmn = request.getParameter("form");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// //////////
		HttpSession session = request.getSession(false);

		if (session == null) {
			System.out.println("no session ");
			session = request.getSession(true);

		} else {
			session.setAttribute("username", request.getParameter("username"));

			System.out.println("session.getId--" + session.getId());

		}

		//if (request.getParameter("username") != null)
		gtf.pt(request,response);
	     ResultSet rs = 	dbcooper.getResult();
		
	     try {
			while(rs.next()){
  
   System.out.println(rs.getString("LOGINTM")); 
 
 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("≤È—Ø ß∞‹"); 
		}

		// //////////

	}

}
