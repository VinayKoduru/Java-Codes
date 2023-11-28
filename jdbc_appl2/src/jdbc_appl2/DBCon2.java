package jdbc_appl2;
import java.sql.*;
import java.sql.DriverManager;

public class DBCon2 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from product52");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"     "+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
