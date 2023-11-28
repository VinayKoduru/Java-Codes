package jdbc_appl3;
import java.sql.*;
import java.util.*;
public class DBCon2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			try
			{
				System.out.println("Enter the EmpId:");
				String id = sc.nextLine();
				System.out.println("Enter the empName:");
				String name = sc.nextLine();
				System.out.println("Enter the empDesg:");
				String desg = sc.nextLine();
				System.out.println("Enter the empSal:");
				int sal = sc.nextInt();
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##Vinay","password");
				Statement stm = con.createStatement();
				int k = stm.executeUpdate("insert into Emp52 values ('"+id+"','"+name+"','"+desg+"',"+sal+")");
				if(k>0)
				{
					System.out.println("Record inserted successfully...");
				}
				con.close();
				
				
			}
			catch(InputMismatchException ime)
			{
				System.out.println("Invalid input...");
			}
			catch(SQLIntegrityConstraintViolationException sicve)
			{
				System.out.println("Employee Details already available...");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}

}
