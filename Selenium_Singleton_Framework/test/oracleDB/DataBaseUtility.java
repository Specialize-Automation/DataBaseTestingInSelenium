package oracleDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import driverUtility.DBConfig;

public class DataBaseUtility 
{
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	static ResultSetMetaData rsmd = null;
	static PreparedStatement preparedStatement = null;
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static Connection connectDB()
	{
		System.out.println("Connecting to Database..."+"\n"+df.format(new Date())+""
				+ "\n----------------------------------------------------------------------------------------");
		try 
		{
			Class.forName(DBConfig.getDriver());
			connection = DriverManager.getConnection(DBConfig.getConnectionString(),DBConfig.getUserName(),DBConfig.getPassword());
			System.out.println("Connected to Oracle11g Database");
		} 
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
		return connection;	
	}	
		
	public static Statement getStatement()
	{
		try
		{
			statement = connection.createStatement();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return statement;
	}
	
	public static void updateDataBase(String sql_Query)
	{
		try 
		{
			preparedStatement = connection.prepareStatement(sql_Query);
			int rows = preparedStatement.executeUpdate(sql_Query);
			System.err.println(rows+" rows updated Successfully Into Database");
		} 
		catch (SQLException e) 
		{e.printStackTrace();}
	}
	
	public static void insertDataBase(String sql_Query)
	{
		try 
		{
			preparedStatement = connection.prepareStatement(sql_Query);
			int rows = preparedStatement.executeUpdate(sql_Query);		
			System.err.println(rows+" rows inserted Successfully Into Database");
		} 
		catch (SQLException e)
		{e.printStackTrace();}
	}
	
	public static ResultSet getDataBase(String sql_Query)
	{
		try
		{
			resultSet = getStatement().executeQuery(sql_Query);
		}
		catch (SQLException e) 
		{e.printStackTrace();}
		return resultSet;
	}
	
	public static void deleteDataBase(String sql_Query)
	{
		try 
		{
			preparedStatement = connection.prepareStatement(sql_Query);
			int rows = preparedStatement.executeUpdate(sql_Query);
			System.err.println(rows+" rows deleted Successfully From Database");
		} 
		catch (SQLException e) 
		{e.printStackTrace();}
	}
	
	public static void showDataBase(String sql_Query)
	{
		try
		{
			System.out.println("********************showing records**********************");
			resultSet = getStatement().executeQuery(sql_Query);
			rsmd = resultSet.getMetaData();
			int columnNumber = rsmd.getColumnCount();  
			while(resultSet.next())
			{
				for(int i=1; i<= columnNumber; i++)
				{
					System.out.print(resultSet.getString(i) +"\t");
				}
					System.out.println(); //printing in next line
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void closeDB() throws SQLException
	{
		if(connection!=null && !connection.isClosed())
		{
			connection.commit();
			connection.close();
			System.out.println("\n----------------------------------------------------------------------------------------"+""
					+ "\n"+df.format(new Date()));
			System.out.println("Disconnected from Oracle11g Database");
		}
	}
}
