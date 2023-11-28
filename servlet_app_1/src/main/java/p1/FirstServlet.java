package p1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/first")
	public class FirstServlet implements Servlet
	{
		public void init(ServletConfig sc) throws ServletException
		{
			//NoCode
		}
		public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
		{
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			String name = req.getParameter("uname");
			String mailId = req.getParameter("mid");
			pw.println("*******Display From Servlet**********");
			pw.println("<br>UserName : "+name);
			pw.println("<br>MailID : "+mailId);
		}
		public void destroy()
		{
			//NoCode
		}
		public ServletConfig getServletConfig()
		{
			return this.getServletConfig();//DemoCode
		}
		public String getServletInfo()
		{
			return "FirstServletreading data from HTML";
		}
		
	}
