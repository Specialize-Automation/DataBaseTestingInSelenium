package testScripts.DataBase;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import oracleDB.OracleDBUtility;
import testScripts.BrowserSetup;

public class Registration_001_DB extends BrowserSetup
{		
	@Test
	public void userRegister() throws SQLException
	{
	    Logger log = Logger.getLogger(Registration_001_DB.class.getName());
	    log.setLevel(Level.INFO);
	    
	    WebDriverWait wait = new WebDriverWait(driver1,20);	 	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER"))); 
	    WebElement register = driver1.findElement(By.linkText("REGISTER"));
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("arguments[0].setAttribute('target','_self');",register);
	    register.click();  
	  
	    //passing values simply to the WebElements
//	    String[] data = OracleDBUtility.returnData();
	    List<String> data = OracleDBUtility.returnData();
	    
	    log.info("Data Provided from Mercury DB: FIRSTNAME "+data.get(0));
	    log.info("Data Provided from Mercury DB: LASTNAME "+data.get(1));
	    log.info("Data Provided from Mercury DB: PHONE "+data.get(2));
	    log.info("Data Provided from Mercury DB: EMAIL "+data.get(3));
	    log.info("Data Provided from Mercury DB: USERNAME "+data.get(4));
	    log.info("Data Provided from Mercury DB: PASSWORD "+data.get(5));
	    log.info("Data Provided from Mercury DB: CONFIRMPASSWORD "+data.get(6));
	    
	    
	    driver1.findElement(By.cssSelector("input[name*='firstName']")).sendKeys(data.get(0));
	    driver1.findElement(By.cssSelector("input[name*='lastName']")).sendKeys(data.get(1));
	    driver1.findElement(By.cssSelector("input[name*='phone']")).sendKeys(data.get(2));
	    driver1.findElement(By.cssSelector("input[id*='userName']")).sendKeys(data.get(3));
	    driver1.findElement(By.xpath("//input[@id='email'][@name='email']")).sendKeys(data.get(4));
	    driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(5));
	    driver1.findElement(By.xpath("//input[starts-with(@name,'confirmP')]")).sendKeys(data.get(6));
	    
/*	    driver1.findElement(By.cssSelector("input[name*='firstName']")).sendKeys(data[0]);
	    driver1.findElement(By.cssSelector("input[name*='lastName']")).sendKeys(data[1]);
	    driver1.findElement(By.cssSelector("input[name*='phone']")).sendKeys(data[2]);
	    driver1.findElement(By.cssSelector("input[id*='userName']")).sendKeys(data[3]);
	    driver1.findElement(By.xpath("//input[@id='email'][@name='email']")).sendKeys(data[4]);
	    driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(data[5]);
	    driver1.findElement(By.xpath("//input[starts-with(@name,'confirmP')]")).sendKeys(data[6]); 
*/	    
	    driver1.findElement(By.xpath("//input[contains(@src,'submit.gif')]")).click();
	    OracleDBUtility.closeDB();
	    
	  		
	}
}
