package p1;
import java.sql.*;
import java.util.*;
public class ViewEmployeesDAO
{
	public ArrayList<EmployeeBean> al = new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrieve()
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from Employee52");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmployeeBean eb = new EmployeeBean();
				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setDesg(rs.getString(3));
				eb.setBsal(rs.getInt(4));
				eb.setTotsal(rs.getFloat(5));
				al.add(eb); //Adds bean object to ArrayList
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}