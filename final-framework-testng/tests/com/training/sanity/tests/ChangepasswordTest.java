package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangepasswordTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePasswordPOM changePasswordPOM;
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
		changePasswordPOM = new ChangePasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void ChangepasswordTest() {
		loginPOM.sendUserName("deepti");
		loginPOM.sendPassword("student@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoggedIn");
		changePasswordPOM.ClickHomepage();
		screenShot.captureScreenShot("Homepage");
		changePasswordPOM.ClickEditProfile();
		screenShot.captureScreenShot("EditPage");
		changePasswordPOM.SendOldPassword("student@123");
		changePasswordPOM.SendNewPassword("conference@123");
		changePasswordPOM.SendConfrmPassword("conference@123");
		screenShot.captureScreenShot("detailsEntered");
		changePasswordPOM.ClickSaveBtn();
		screenShot.captureScreenShot("PasswordChanged");
		String Actual = driver.findElement(By.xpath("//*[contains(text(),'Your new profile has been saved')]")).getText();
		Assert.assertEquals(Actual, "Your new profile has been saved");
		
	}
}

