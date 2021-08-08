
package atm;
import java.sql.*;
public class Database
{
	public static Connection con;
	public static Connection connect()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver ok");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anshika","root","1234");
		System.out.println("Connected");
		}
		catch(ClassNotFoundException|SQLException se){
			se.printStackTrace();
		}
		return con;
	}
	public static void main(String arg[]){
		connect();
		}
}