package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DatabasePage {
	
	
	
	public static String getData(String columnName) throws Throwable {
		
		//Set up properties for MySql
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//You need sqlUrl, sql Username, sql Password, then we need the Sql query
		//To find sqlUrl; go to MySql Workbench => click Database on top nav => click "Connect to Database"
		//Note: Here you will find "Hostname" and "Port"
		//Now use the Hostname and Port to enter in the syntax below
		//Hostname = localhost
		//Port = 3306
		//Database Name = feb2022
		String sqlUrl= "jdbc:mysql://localhost:3306/feb2022?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

//		String sqlUrl = "jdbc:mysql://localhost:3306/feb2022" ;
		String sqlUsername = "root";
		String sqlPassword = "rootroot";
		String sqlQuery = "Select * from users;";
		
		
		
		//Create connection to local database
		Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
		
		
		
		//Empowering "con" reference variable to execute queries
		Statement smt = con.createStatement();
		
		
		
		//Delivering queries
		ResultSet rs = smt.executeQuery(sqlQuery);
		
		while(rs.next()) {
		return	rs.getString(columnName);
		}
		
		
		return columnName;
		
		
		
	}
}
