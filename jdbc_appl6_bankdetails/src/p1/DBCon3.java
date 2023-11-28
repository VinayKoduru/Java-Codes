package p1;
import java.util.Scanner;
import java.sql.*;
public class DBCon3 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
				PreparedStatement ps1 = con.prepareStatement("insert into bankdetails values(?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from bankdetails");
				while(true)
				{
					System.out.println("Available bank details....");
					System.out.println("\t1.Add Bank Details"+"\n\t2.View bank details"+"\n\t3.exit");
					System.out.println("select any number...");
					int choice = Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("Enter the Account Number:");
						String aN = sc.nextLine();
						System.out.println("Enter the Customer Name:");
						String aC = sc.nextLine();
						System.out.println("Enter the Balance Amount:");
						String bal = sc.nextLine();
						System.out.println("Enter the Accunt Type:");
						String aT = sc.nextLine();
						ps1.setString(1, aN);
						ps1.setString(2, aC);
						ps1.setString(3, bal);
						ps1.setString(4, aT);
						int k = ps1.executeUpdate();
						if(k>0)
						{
							System.out.println("Bank Details are inserted successfully");
						}
						break;
					case 2:
						ResultSet rs = ps2.executeQuery();
						System.out.println("Bank Details loaded...");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
						}
						break;
					case 3:
						System.out.println("operations are Stopped Successfully");
						System.exit(0);
					default :
						System.out.println("Invalid number Entered");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
