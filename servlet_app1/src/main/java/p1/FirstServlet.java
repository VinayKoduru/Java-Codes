package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/first")
public class FirstServlet implements Servlet {
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	String name = req.getParameter("uname");
    	String mailId = req.getParameter("mid");
    	pw.println("****Display from Servlet****");
    	pw.println("<br>UserName : "+name);
    	pw.println("<br>MailID : "+mailId);

	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "FirstServlet reading data from HTMl"; 
	}



}
