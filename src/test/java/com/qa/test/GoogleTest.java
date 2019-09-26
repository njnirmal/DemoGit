package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleTest {
	
	WebDriver driver =null;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod()
    @Parameters({"browser"})
	public void BrowserSetUP(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		}else if(browser.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test(priority =1 ,groups="sanity")
	public void GetPagetitle()
	{
		
	   String expectedTitle="Google";	
       String title =driver.getTitle();
       System.out.println("page title is :" + title);
       Assert.assertEquals(title, expectedTitle,"Title not matched .....");
       
       

	}
	
	@Test(priority=2,groups="smoke")
	public void getLogo()
	{
		boolean b = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3,groups="sanity")
	public void verifyGMailLink() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=4,groups="regression")
	public void verifyImages() {
		boolean b = driver.findElement(By.linkText("Images")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=5,groups="regression")
	public void verifySearchText() {
		boolean b = driver.findElement(By.xpath("//input[@title='Search']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=6,groups="regression" )
	public void verifyMicrophoneIcon() {
		boolean b = driver.findElement(By.xpath("//div[@aria-label='Search by voice']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	@Test(priority=7)
	public void finalTest() {
		
		boolean a = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		softAssert.assertFalse(a);
		System.out.println("Logo is displayed");
		boolean b = driver.findElement(By.linkText("Images")).isDisplayed();
		softAssert.assertTrue(b);
		System.out.println("Image is displayed");
		boolean c = driver.findElement(By.xpath("//input[@title='Search']")).isDisplayed();
		softAssert.assertFalse(c);
		System.out.println("Search is displayed");
		boolean d = driver.findElement(By.xpath("//div[@aria-label='Search by voice']")).isDisplayed();
		softAssert.assertFalse(d);
		System.out.println("Microp phone is displayed");
		
		softAssert.assertAll();
		
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}


}
