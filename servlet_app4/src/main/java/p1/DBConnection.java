package p1;
import java.sql.*;
public class DBConnection
{
	private static Connection con = null;
	private DBConnection() {}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static Connection getCon() {
		// TODO Auto-generated method stub
		return con;
	}
}