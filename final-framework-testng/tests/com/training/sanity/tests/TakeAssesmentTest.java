package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.TakeAssesmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TakeAssesmentTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TakeAssesmentPOM takeAssesmentPOM;
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
		takeAssesmentPOM = new TakeAssesmentPOM(driver);
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
//To verify whether application allows student to subscribe for the course & take the authored assessment
	
	public void takequizTest() throws InterruptedException {
		
		//login to e learning application using student profile
		loginPOM.sendUserName("Krishna06");
		loginPOM.sendPassword("krishna@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoggedIn");
		
		//scroll down till the element(course catalouge link) is visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement courseCatalougeLink = driver.findElement(By.xpath("//*[text()='Courses history']"));
		js.executeScript("arguments[0].scrollIntoView();", courseCatalougeLink);
		
		takeAssesmentPOM.clickCourseCatalougeLink();
		Thread.sleep(2000);
		screenShot.captureScreenShot("view all courses");
		//search the required course
		takeAssesmentPOM.EnterCourseSearchBox("test");
		takeAssesmentPOM.clickSearchBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot("view searched courses");
		//select the required course
		takeAssesmentPOM.clickCourseLink();
		Thread.sleep(2000);
		//subscribe the new course or view the previously subscribed course
		takeAssesmentPOM.clickSubscribeBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("subscribed course detail");
		//go to assessment
		takeAssesmentPOM.clickAssesmentIcon();
		takeAssesmentPOM.clickTestLink();
		//start a new test or resume a test
		takeAssesmentPOM.clickTestStartBtn();
		//wait for 10 secs so that user can select answer.user select the answer of 1st question manually 
		Thread.sleep(10000);
		takeAssesmentPOM.clickNextQuesBtn1();
		
		//wait for 10 secs so that user can select answer.user select the answer of 2nd question manually
		Thread.sleep(10000);
		takeAssesmentPOM.clickNextQuesBtn2();
		
		//wait for 10 secs so that user can select answer.user select the answer of 3rd question manually
		Thread.sleep(10000);
		takeAssesmentPOM.clickNextQuesBtn3();
		
		//wait for 10 secs so that user can select answer.user select the answer of 4th question manually
		Thread.sleep(10000);
		takeAssesmentPOM.clickEndBtn4();
		Thread.sleep(10000);
		screenShot.captureScreenShot("view resultss");
		
		//verify test has been saved
		boolean TestSavedAlert = driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
		Assert.assertTrue(TestSavedAlert, "test not saved");
		
		//verify test has been completed
		boolean TestcompletedAlert = driver.findElement(By.xpath("//*[@class='alert alert-info']//*[text()='Your test test is completed']")).isDisplayed();
		Assert.assertTrue(TestcompletedAlert, "test not completed");
		
		//verify user passed or failed th test
		try{
			boolean TestResult = driver.findElement(By.xpath("//*[text()='Congratulations you passed the test!']")).isDisplayed();
			Assert.assertTrue(TestResult, "you have failed the test");
		}
		catch(NoSuchElementException fail) {
			System.out.println("You have failed the test");
			System.out.println(fail.toString());
			
		}
	
  }
}
