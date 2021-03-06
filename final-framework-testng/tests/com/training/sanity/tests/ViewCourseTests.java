package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.SearchCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewCourseTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SearchCoursesPOM coursePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		coursePOM = new SearchCoursesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void viewCourseTests() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoggedIn");
		coursePOM.clickCourseLink();
		screenShot.captureScreenShot("CourseList");
		coursePOM.sendKeyword("selenium");		
		coursePOM.ClickSearchBtn();
		screenShot.captureScreenShot("filteredResults");
		Assert.assertEquals(driver.getTitle(), "My Organization - My education - Course list");
		String Actual = driver.findElement(By.xpath("//*[contains(text(),'Selenium9898')]")).getText();
		Assert.assertEquals(Actual, "Selenium9898");
		   
	}
}

