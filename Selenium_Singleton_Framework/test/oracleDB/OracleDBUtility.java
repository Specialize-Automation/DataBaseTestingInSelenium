package oracleDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import driverUtility.ReadPropertiesFile;

public class OracleDBUtility 
{
	protected static Connection conn= null;
	protected static Statement stmt= null;
	protected static ResultSet rs= null;
	protected static String query1= "select * from MERCURYDB";// WHERE ROWNUM<=2 MINUS select * from MERCURYDB WHERE ROWNUM<=1";
	public static String FirstName;
	public static String LastName;
	public static String phone;
	public static String email;
	public static String userName;
	public static String password;
	public static String confirmPass;
//	protected static String query2= "SELECT COUNT(*) AS COUNT FROM MERCURYDB";
	public static List<String> returnData() throws SQLException
	{
		List<String> list = new ArrayList<String>();
		try
		{
			Class.forName(ReadPropertiesFile.getDriver());
			conn=DriverManager.getConnection(ReadPropertiesFile.getConnectionString(),
													ReadPropertiesFile.getUserName(),
													ReadPropertiesFile.getPassword());
			System.out.println("Connected to Oracle11g Database");
		
		}
		catch(SQLException|IOException | ClassNotFoundException ex)
		{
			System.err.println("Failed to connect to DB/ Check properties file");
			ex.printStackTrace();
		}
		stmt=conn.createStatement();
		rs = stmt.executeQuery(query1);

//		ResultSetMetaData rsmd = rs.getMetaData();
//	    int columnsNumber = rsmd.getColumnCount();                     

		//iterate through table and show data
		while (rs.next()) 
		{         
/*			for(int i = 1 ; i <= columnsNumber; i++)
			{
				System.out.print(rs.getString(i) +"\t");
			}
				System.out.println();           //next line
		    }*/
		
/*		    System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+
		    				   rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)); */
			
/*		    FirstName =rs.getString(1);
		    LastName = rs.getString(2);
		    phone =Long.toString(rs.getLong(3));
		    email =rs.getString(4);
		    userName=rs.getString(5);
		    password=rs.getString(6);
		    confirmPass=rs.getString(7);
		    
		    return new String[]{FirstName,LastName,phone,email,userName,password,confirmPass};
*/		    
		    list.add(rs.getString(1));
		    list.add(rs.getString(2));
		    list.add(rs.getString(3));
		    list.add(rs.getString(4));
		    list.add(rs.getString(5));
		    list.add(rs.getString(6));
		    list.add(rs.getString(7));  
		}
		return list; 
	}
//			System.out.println("The count is :"+rs.getString("COUNT"));
		
	public static void closeDB() throws SQLException
		{
		if(conn!=null)
		{
			conn.commit();
			conn.close();
			System.out.println("Disconnected from Oracle11g Database");
		}
	}
}
