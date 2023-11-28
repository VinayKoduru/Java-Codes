package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/md")
public class ModulusServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try
		{
			int v1 = Integer.parseInt(req.getParameter("v1"));
			int v2 = Integer.parseInt(req.getParameter("v2"));
			int v3 = v1%v2;
			pw.println("Sum : "+v3+"<br>");
		}
		catch(Exception e)
		{
			pw.println("Enter Only Integer Values...<br>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
