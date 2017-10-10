package oracleDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverUtility.ReadPropertiesFile;

public class DBConnection 
{
	protected Connection conn= null;
	protected Statement stmt= null;
	protected ResultSet rs= null;
	protected String query1= "select * from MERCURYDB WHERE ROWNUM<=2 MINUS select * from MERCURYDB WHERE ROWNUM<=1" ;
	protected String query2= "SELECT COUNT(*) AS COUNT FROM MERCURYDB";
	
	@BeforeTest
	public void oracleConnect()
	{
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
	}
			
	@Test
	public void test() throws SQLException
	{
			stmt=conn.createStatement(); 
			rs=stmt.executeQuery(query1); 
			while(rs.next()) 
			{
			    System.out.println(rs.getString("FIRSTNAME")+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+
			    				   rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));   
				
//				System.out.println("The count is :"+rs.getString("COUNT"));
				System.out.println("The current row :"+rs.getRow());
			}
	}
	
	@AfterTest
	public void oracleDisconnect() throws SQLException
	{
		if(conn!=null)
		{
			conn.commit();
			conn.close();
			System.out.println("Disconnected from Oracle11g Database");
		}
	}
}
