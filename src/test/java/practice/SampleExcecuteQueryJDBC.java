package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class SampleExcecuteQueryJDBC  {
	
	public static void main(String[] args) throws SQLException {
		
	
	
	//create driver object and import Mysql
	Driver driverRef = new Driver();
			
	
	//Step 1: Register the Driver/database
	DriverManager.registerDriver(driverRef);
	
	//Step 2: Get the connection with the database
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/M4DB", "root", "root");
	
	//Step 3: Issue create statement
	Statement state = conn.createStatement();
	
	//Step 4: Execute the query
	ResultSet result = state.executeQuery("select * from customer_info");
	while(result.next())
	{
		System.out.println(result.getInt(1)+"-"+result.getString(2)+"-"+result.getString(3));
	}
	
    //Step 5: Close the DB	
	conn.close();

}
}
