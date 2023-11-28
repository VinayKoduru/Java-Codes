package p1;
import java.sql.*;
public class InsertBookDAO {
	public int k=0;
	public int insert(BookBean bb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("insert into Book52 values(?,?,?,?,?)");
			ps.setString(1, bb.getId());
			ps.setString(2, bb.getName());
			ps.setString(3, bb.getCategory());
			ps.setString(4, bb.getAuthor());
			ps.setInt(5, bb.getPrice());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
