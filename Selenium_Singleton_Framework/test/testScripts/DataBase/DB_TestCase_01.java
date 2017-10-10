package testScripts.DataBase;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import oracleDB.DataBaseUtility;

public class DB_TestCase_01 
{
	@Test(enabled = false)
	public void testDataBase() throws SQLException
	{
		DataBaseUtility.connectDB();
		ResultSet rs =DataBaseUtility.getDataBase("SELECT * FROM MERCURYDB");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		while(rs.next())
		{
			for(int i=1; i<= columns ;i++)
			{
				System.out.print(" "+rsmd.getColumnName(i));
				System.out.println(" "+rs.getString(i));
			}
				System.out.println();
		}
		DataBaseUtility.closeDB();
	}
	
	
	@Test(description="show database", enabled=false)
	public void showDataBase() throws SQLException
	{
		DataBaseUtility.connectDB();
		DataBaseUtility.showDataBase("select * from MERCURYDB");	
		DataBaseUtility.closeDB();
	}
	
	
	@Test(description="Insert Database", enabled=false)
	public void insertDataBase() throws SQLException
	{
		DataBaseUtility.connectDB();
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		System.out.println("\n\n\n\n");
		
		DataBaseUtility.insertDataBase("INSERT INTO MERCURYDB VALUES('MANDY','LUCIFR',2274875698,'MANDY@LCFR.COM','MANDY_LCR','TEST123','TEST123')");
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		DataBaseUtility.closeDB();
	}
	
	
	@Test(description="Insert Database", enabled=false)
	public void insertIntoDataBase() throws SQLException
	{
		String FIRSTNAME = "VIRAT";
		String LASTNAME = "KOHLI";
		int PHONE = 2123473586;
		String EMAIL = "KOHLI.VIRAT@GMAIL.COM";
		String USERNAME = "KOHLI_ind";
		String PASSWORD = "KOHLI";
		String CNFPASS = "KOHLI";
		
		DataBaseUtility.connectDB();
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		System.out.println("\n\n\n\n");
		
//		DataBaseUtility.insertDataBase("INSERT INTO MERCURYDB VALUES(\'"+FIRSTNAME+"\',\'"+LASTNAME+"\',"+PHONE+",\'"+EMAIL+"\',"
//				  														+ "\'"+USERNAME+"\',\'"+PASSWORD+"\',\'"+CNFPASS+"\')");
		
		ResultSet rs =DataBaseUtility.getDataBase("SELECT * FROM MERCURYDB WHERE USERNAME='KOHLI_ind'");
		try
		{
			System.out.println("Asserting values with Database");
			Assert.assertEquals(rs.getString("FIRSTNAME"), FIRSTNAME);
			Assert.assertEquals(rs.getString("LASTNAME"), LASTNAME);
			Assert.assertEquals(rs.getString("PHONES"), PHONE);
			Assert.assertEquals(rs.getString(4), EMAIL);
			Assert.assertEquals(rs.getString(5), USERNAME);
			Assert.assertEquals(rs.getString(6), PASSWORD);
			Assert.assertEquals(rs.getString(7), CNFPASS);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
			System.out.println("DataBase verification completed");
		}	
		DataBaseUtility.closeDB();
	}


	@Test(description="Delete Database", enabled=false)
	public void deleteDataBase() throws SQLException
	{
		DataBaseUtility.connectDB();
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		DataBaseUtility.deleteDataBase("DELETE FROM MERCURYDB WHERE USERNAME='KOHLI_ind'");
		
		System.out.println("\n\n\n\n");
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		DataBaseUtility.closeDB();	
	}

	
	@Test(description="update Database", enabled=true)
	public void updateDatabase() throws SQLException
	{
		DataBaseUtility.connectDB();
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		DataBaseUtility.updateDataBase("UPDATE MERCURYDB SET FIRSTNAME='XXXXX'WHERE USERNAME='MANDY_LCR'");
		DataBaseUtility.updateDataBase("UPDATE MERCURYDB SET FIRSTNAME='JAMES'WHERE USERNAME='J_ROBBIN'");
		
		
		System.out.println("\n\n\n\n");
		DataBaseUtility.showDataBase("SELECT * FROM MERCURYDB");
		DataBaseUtility.closeDB();	
	}
	
}

