package p1;
import java.sql.*;
import java.util.Scanner;
public class DBCon3 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
				PreparedStatement ps1 = con.prepareStatement("insert into bookdetails values(?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from bookdetails");
				while(true)
				{
					System.out.println("Available stmts...");
					System.out.println("\t1.AddBookDetails"+"\n\t2.ViewAllBookDetails"+"\n\t3.exit");
					System.out.println("Select any number");
					int choice = Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("Enter the BookCode:");
						String bC = sc.nextLine();
						System.out.println("Enter the Book Name:");
						String bN = sc.nextLine();
						System.out.println("Enter the Book Author:");
						String bA = sc.nextLine();
						System.out.println("Enter the Book Price:");
						String bP = sc.nextLine();
						System.out.println("Enter the Book Quantity:");
						String bQ = sc.nextLine();
						ps1.setString(1, bC);
						ps1.setString(2, bN);
						ps1.setString(3, bA);
						ps1.setString(4, bP);
						ps1.setString(5, bQ);
						int k = ps1.executeUpdate();
						if(k>0) {
							System.out.println("Book Details Inserted Successfully");
						}
						break;
					case 2:
						ResultSet rs = ps2.executeQuery();
						System.out.println("BookDetails Loaded....");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"	"+"\t"+rs.getFloat(4)+"	"+"\t"+rs.getInt(5));
						}
						break;
					case 3:
						System.out.println("Operations are Stopped Successfully...");
						System.exit(0);
					default :
						System.out.println("Invalid Number Entered...");
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
