package p1;

import java.util.*;
import java.sql.*;
public class DBCon5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Connection con = DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
				PreparedStatement ps1 = con.prepareStatement
						("insert into UserReg52 values(?,?,?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement
						("select * from UserReg52 where uname=? and pword=?");
				PreparedStatement ps3 = con.prepareStatement
						("update UserReg52 set addr=?,mid=?,phno=? where uname=?");
				int temp = 0;
				while(temp==0)
				{
				System.out.println("Select any of the following..../");
				System.out.println("\t1.Register"
								+ "\n\t2.Login"
								+ "\n\t3.Exit");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice)
				{
				case 1:
					System.out.println("Enter the Username...");
					String uN = sc.nextLine();
					System.out.println("Enter the Password...");
					String pW = sc.nextLine();
					System.out.println("Enter the First Name...");
					String fN = sc.nextLine();
					System.out.println("Enter the Last Name...");
					String lN =sc.nextLine();
					System.out.println("Enter the Address...");
					String aD = sc.nextLine();
					System.out.println("Enter the MailID...");
					String miD = sc.nextLine();
					System.out.println("Enter the Phone Number...");
					long pN = Long.parseLong(sc.nextLine());
					ps1.setString(1, uN);
					ps1.setString(2, pW);
					ps1.setString(3, fN);
					ps1.setString(4, lN);
					ps1.setString(5, aD);
					ps1.setString(6, miD);
					ps1.setLong(7, pN);
					int k = ps1.executeUpdate();
					if(k>0)
					{
						System.out.println("User Registration Process is Successfull");
					}
					break;
				case 2:
					System.out.println("Enter the UserName...");
					String uN2 = sc.nextLine();
					System.out.println("Enter the Password");
					String pwd = sc.nextLine();
					ps2.setString(1, uN2);
					ps2.setString(2, pwd);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
					{
						System.out.println("Enter the Choice...");
						System.out.println("\t1.View Profile"
								+ "\n\t2.Edit Profile"
								+ "\n\t3.Exit");
						
						int choice2 = Integer.parseInt(sc.nextLine());
						if(choice2==1)
						{
							System.out.println("User Details of "+ uN2);
							System.out.println("UserName: "+rs2.getString(1)+"\n"
									+"Password:"+rs2.getString(2)+"\n"
									+"Firstname:"+rs2.getString(3)+"\n"
									+"LastName:"+rs2.getString(4)+"\n"
									+"Address:"+rs2.getString(5)+"\n"
									+"MailID:"+rs2.getString(6)+"\n"
									+"PhoneNumber:"+rs2.getString(7));
							temp = 1;
						}
						else if(choice2==2)
						{
							System.out.println("Old Address:"+rs2.getString(5));
							System.out.println("Enter the new Address.../");
							String naddr = sc.nextLine();
							System.out.println("Old mailID:"+rs2.getString(6));
							System.out.println("Enter the new MailID.../");
							String nmid = sc.nextLine();
							System.out.println("Old PhoneNumber:"+rs2.getString(7));
							System.out.println("Enter the new PhoneNumber");
							long nphno = Long.parseLong(sc.nextLine());
							ps3.setString(1, naddr);
							ps3.setString(2, nmid);
							ps3.setLong(3, nphno);
							ps3.setString(4, uN2);
							int k2 = ps3.executeUpdate();
							if(k2>0)
							{
								System.out.println("Details updated successfully..../");
							}
						}
						else if(choice2==3)
						{
							System.out.println("Operations Stopped");
							temp = 1;
						}
						else if(choice2<1||choice2>3)
						{
							System.out.println("Invalid Option Selected,****Try again****");
						}
					}
					else 
					{
						System.out.println("Wrong Details Entered.../Try Again");
						
						break;
					}
				case 3:
					System.out.println("Operations are Stopped");
					temp = 1;
					break;
				default :
					System.out.println("Invalid options are selected.../");
					System.out.println("****TRY AGAIN****");
				}
			}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
