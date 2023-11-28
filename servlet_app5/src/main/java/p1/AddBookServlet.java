package p1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		BookBean bb = new BookBean();
		bb.setId(req.getParameter("id"));
		bb.setName(req.getParameter("name"));
		bb.setCategory(req.getParameter("category"));
		bb.setAuthor(req.getParameter("author"));
		int price = Integer.parseInt(req.getParameter("price"));
		bb.setPrice(price);
		int k = new InsertBookDAO().insert(bb);
		pw.println("k value : "+k+"<br>");
		if(k>0)
		{
			pw.println("Book Added to DataBase Successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
	}
}