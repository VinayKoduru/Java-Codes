package p1;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBooksServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<BookBean> al = new ViewBooksDAO().retreve();
		if(al.size()==0)
		{
			pw.println("No Books Found....");
			RequestDispatcher rd = req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
		else
		{
			al.forEach((k)->
			{
				BookBean bb = (BookBean)k;
				pw.println(bb.getId()+"&nbsp&nbsp"+bb.getName()+"&nbsp&nbsp"+bb.getCategory()+"&nbsp&nbsp"+bb.getAuthor()+"&nbsp&nbsp"+bb.getPrice()+"<br>");
			});
			pw.println("<a href='choice.html'>Back</a>");
		}
	}
}