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
import com.training.pom.RecoverPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RecoverPasswordTest {
	private WebDriver driver;
	private String baseUrl;
	private RecoverPasswordPOM recoverPasswordPOM;
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
		recoverPasswordPOM = new RecoverPasswordPOM(driver); 
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
	public void recoverLostPswd() throws InterruptedException {
		recoverPasswordPOM.clicklostPswdLink();
		recoverPasswordPOM.enterUserText("Madhuri");
		recoverPasswordPOM.clicksendMessageBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Password Reset");
		String actual = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
		Assert.assertEquals(actual, "Your password has been emailed to you");
		
	}
	
	
}
