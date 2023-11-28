package p1;
import java.sql.*;
import java.util.*;
public class DBCon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			try 
			{
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##Vinay","password");
				PreparedStatement ps1 = con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from BookDetails52");
				PreparedStatement ps3 = con.prepareStatement("select * from Bookdetails52 where bcode=?");
				PreparedStatement ps4 = con.prepareStatement("update BookDetails52 set bprice=?,bqty=bqty+? where bcode=?");
				PreparedStatement ps5 = con.prepareStatement("delete from BookDetails52 where bcode=?");
				while(true)
				{
					System.out.println("Enter Choice:");
					System.out.println("\t1.AddBookDetails"+"\n\t2.ViewAllBookDetails"+"\n\t3.ViewBookByCode"+"\n\t4.UpdateBookByCode"+"\n\t5.DeleteBookByBookCode"+"\n\t6.Exit");
					int choice = Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("Enter BookCode");
						String bc = sc.nextLine();
						System.out.println("Enter BookName");
						String bn = sc.nextLine();
						System.out.println("Enter BookAuthor");
						String ba = sc.nextLine();
						System.out.println("Enter BookPrice");
						float bp = Float.parseFloat(sc.nextLine());
						System.out.println("Enter BookQuantity");
						int bq = Integer.parseInt(sc.nextLine());
						
						ps1.setString(1, bc);
						ps1.setString(2, bn);
						ps1.setString(3, ba);
						ps1.setFloat(4, bp);
						ps1.setInt(5, bq);
						int k = ps1.executeUpdate();
						if(k>0) {
							System.out.println("BookDetails inserted Succesfully...");
						}
						break;
					case 2:
						ResultSet rs = ps2.executeQuery();
						System.out.println("Book Details");
						while(rs.next()) {
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));	
						}
						break;
					case 3:
						System.out.println("Enter the BookCode:");
						String code = sc.nextLine();
						ps3.setString(1, code);
						ResultSet rs2 = ps3.executeQuery();
						if(rs2.next()) {
							System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
						}
						else
						{
							System.out.println("Invalid Book Code...");
						}
						break;
					case 4:
						System.out.println("Enter BookCode:");
						String code2 = sc.nextLine();
						ps3.setString(1, code2);
						ResultSet rs3 = ps3.executeQuery();
						if(rs3.next()) {
							System.out.println("Old Book Price:"+rs3.getString(4));
							System.out.println("Enter new Book price:");
							float nprice = Float.parseFloat(sc.nextLine());
							System.out.println("Old Book QTY:"+rs3.getInt(5));
							System.out.println("Enter the New QTY:");
							int nQty = Integer.parseInt(sc.nextLine());
							
							ps4.setFloat(1, nprice);
							ps4.setString(3, code2);
							int k2 = ps4.executeUpdate();
							if(k2>0) {
								System.out.println("Book Price and qty updated..."); 
								
							}
							else {
								System.out.println("Invalid BookCode...");
							}
						}
						break;
					case 5:
						System.out.println("Enter the BookCode:");
						String code3 = sc.nextLine();
						ps3.setString(1,code3);
						ResultSet rs4 = ps3.executeQuery();
						if(rs4.next()) {
							ps5.setString(1, code3);
							int k3 = ps5.executeUpdate();
							if(k3>0) {
								System.out.println("BookDetails deleted Successfully...");
							}
							else {
								System.out.println("Invalid BookCode...");
							}
						}
						break;
					case 6:
						System.out.println("Operations on DB has Stopped");
						System.exit(0);
					default:
						System.out.println("Invalid Choice...");
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
