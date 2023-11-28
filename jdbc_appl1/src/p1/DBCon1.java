package p1;
import java.sql.*;
import java.sql.DriverManager;

public class DBCon1 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Loading Driver
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password"); //Creating Connection
			Statement stm = con.createStatement(); //Preparing Statement
			ResultSet rs = stm.executeQuery("select * from Emp52"); //Executing Query
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			} //End of loop
			con.close(); //Closing Connection
		} //End of Try
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
