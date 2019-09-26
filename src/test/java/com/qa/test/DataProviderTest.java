package com.qa.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.TestUtil;

public class DataProviderTest {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		
		ArrayList<Object[]> testData = TestUtil.getExcelData();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getData")
	public void VerifyRegisterEbayTest(String firstname,String lastname,String emailId,String passWord) throws Exception {
		
    WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
    WebElement lastName =driver.findElement(By.xpath("//input[@name='lastname']"));
    WebElement emailID=driver.findElement(By.xpath("//input[@name='reg_email__']"));
    WebElement password=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
    
    firstName.clear();
    firstName.sendKeys(firstname);
    Thread.sleep(3000);
    lastName.clear();
    lastName.sendKeys(lastname);
    Thread.sleep(3000);
    emailID.clear();
    emailID.sendKeys(emailId);
    Thread.sleep(3000);
    password.clear();
    password.sendKeys(passWord);
    Thread.sleep(3000);
		

		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
