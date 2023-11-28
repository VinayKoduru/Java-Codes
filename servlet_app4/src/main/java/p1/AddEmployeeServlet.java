package p1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		EmployeeBean eb = new EmployeeBean();
		eb.setId(req.getParameter("id"));
		eb.setName(req.getParameter("name"));
		eb.setDesg(req.getParameter("desg"));
		int bsal = Integer.parseInt(req.getParameter("bsal"));
		eb.setBsal(bsal);
		float totsal = bsal + (0.93F*bsal)+(0.63F*bsal);
		eb.setTotsal(totsal);
		int k = new InsertEmployeeDAO().insert(eb);
		pw.println("value of k : "+k);
		if(k>0)
		{
			pw.println("Employee Added Successfully <br>");
			RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
			rd.include(req, res);
		}
	}
}