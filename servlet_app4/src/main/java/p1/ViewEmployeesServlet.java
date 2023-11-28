package p1;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeesServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<EmployeeBean> al = new ViewEmployeesDAO().retrieve();
		if(al.size()==0)
		{
			pw.println("No Employees Found...");
			RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
			rd.include(req, res);
		}
		else
		{
			al.forEach((k)->
			{
				EmployeeBean eb = (EmployeeBean)k;
				pw.println(eb.getId()+"&nbsp&nbsp"+eb.getName()+"&nbsp&nbsp"+eb.getDesg()+"&nbsp&nbsp"+eb.getBsal()+"&nbsp&nbsp"+eb.getTotsal()+"<br>");
			});
			pw.println("<a href='welcom.html'>Back</a>");
		}
	}
}