package driverUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBConfig 
{
	static File file = new File("E:/Eclipse_selenium/Selenium_Singleton_Framework/src/DriverUtility/Config.properties");
	static FileInputStream fis;
	static Properties prop = new Properties();
	public static String getDriver() throws IOException,FileNotFoundException
	{
		try
		{
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}
		return null;
	}
	public static String getConnectionString() throws IOException,FileNotFoundException
	{
		try
		{
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("connectionString");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}
		return null;
	}
	public static String getUserName() throws IOException,FileNotFoundException
	{
		try
		{
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("userName");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}
		return null;
	}
	public static String getPassword() throws IOException,FileNotFoundException
	{
		try
		{
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("password");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
		}
		return null;
	}

}
