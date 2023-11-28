package p1;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		UserBean ub = new UserBean();
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		int k = new RegisterDAO().register(ub);
		pw.println("value of k is "+k);
		if(k>0)
		{
			pw.println("user Regstered Successfully...<br>");
			pw.println(req.getParameter("uname"));
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}