package p1;
import java.sql.*;
import java.util.*;
public class ViewBooksDAO 
{
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	public ArrayList<BookBean> retreve()
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from Book52");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BookBean bb = new BookBean();
				bb.setId(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setCategory(rs.getString(3));
				bb.setAuthor(rs.getString(4));
				bb.setPrice(rs.getInt(5));
				al.add(bb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
