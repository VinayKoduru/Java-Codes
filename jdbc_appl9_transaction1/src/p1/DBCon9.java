package p1;
import java.util.*;
import java.sql.*;
public class DBCon9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
				System.out.println("Status of AutoCommit:"+con.getAutoCommit());
				con.setAutoCommit(false);
				System.out.println("Status of AutoCommit after setting false is :"+con.getAutoCommit());
				PreparedStatement ps1 = con.prepareStatement("select * from bank52 where accno=?");
				PreparedStatement ps2 = con.prepareStatement("update bank52 set bal=bal+? where accno=?");
				PreparedStatement ps3 = con.prepareStatement("update bank52 set bal=bal-? where accno=?");
				@SuppressWarnings("unused")
				Savepoint sp = con.setSavepoint();
				System.out.println("Enter the home accno:");
				long haccno = sc.nextLong();
				ps1.setLong(1, haccno);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next())
				{
					float b1 = rs1.getFloat(2);
					System.out.println("Entered haccno "+rs1.getLong(1)+" and balance "+b1);
					System.out.println("Enter the benificiery accno:");
					long baccno = sc.nextLong();
					ps1.setLong(1, baccno);
					ResultSet rs2 = ps1.executeQuery();
					if(rs2.next())
					{
						System.out.println("Enter amount to transfer:");
						float amt = sc.nextFloat();
						if(amt<=b1)
						{
							ps3.setFloat(1, amt);
							ps3.setLong(2, haccno);
							int i = ps3.executeUpdate();
							ps2.setFloat(1, amt);
							ps2.setLong(2, baccno);
							int j = ps2.executeUpdate();
							if(i==1 && j==1)
							{
								System.out.println("Transaction Successfull...");
								con.commit();
							}
							else
							{
								System.out.println("Transaction Failed...");
								con.rollback();
							}	
						}
						else
						{
							System.out.println("Insufficient fund...");
						}	
					}
					else
					{
						System.out.println("Invalid baccno...");
					}
				}
				else
				{
					System.out.println("Invalid home accno...");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
