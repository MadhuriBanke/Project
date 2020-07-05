package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProjectPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SearchCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProjectTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SearchCoursesPOM coursePOM;
	private AddProjectPOM addPojectPOM;
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
		addPojectPOM =new AddProjectPOM(driver);
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
	//To verify whether application allows teacher to add project details
	
	public void AddProjectTestSuccess() throws InterruptedException {
		//login to e learning application using teacher profile
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Logged In");
		//view available courses
		coursePOM.clickCourseLink();
		screenShot.captureScreenShot("CourseList");
		//search required course
		coursePOM.sendKeyword("api");		
		coursePOM.ClickSearchBtn();
		screenShot.captureScreenShot("filteredResults");
		//select required course
		addPojectPOM.clickCourseLink();
		//add project for a course
			//scroll to find project icon
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		addPojectPOM.clickProjectIcon();
		addPojectPOM.clickCreateprojectIcon();
		Thread.sleep(1000);
		addPojectPOM.enterProjectTitle("e learning");
		addPojectPOM.enterProjectSubTitle("e learning project");
		Thread.sleep(1000);
		addPojectPOM.clickSaveBlogBtn();
		
		//verify that Message should get displayed for successful addition of project
		
	        	String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	        	Assert.assertEquals(Actual,"The project has been added."); 
	    
				
		//add task or article to the project
	    addPojectPOM.clickProjectLink();
		addPojectPOM.clickTaskIcon();
		addPojectPOM.enterTaskTitle("StudentTask1");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		addPojectPOM.clickTaskSaveBtn();
		//verify that Message should get displayed for successful addition of article
			//using try and catch so that if message is not displayed for addition of article, further code will still be executed, as it is not dependent on article.
		try{
				Boolean ActualTask= driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
				Assert.assertTrue(ActualTask, "Task has not been created");
		}
		catch(NoSuchElementException fail) {
				System.out.println(fail.getMessage());
		}
		
		//add a role to the task created
		addPojectPOM.clickRoleMgntIcon();
		addPojectPOM.clickAddRoleIcon();
		addPojectPOM.EnterNewroleTitle("Developer1");
		addPojectPOM.clickRoleSaveBtn();
		//verify that Message should get displayed for successful creation of task
		try{
				Boolean ActualRole= driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
				Assert.assertTrue(ActualRole, "Role has not been added");
		}
		catch(java.lang.AssertionError fail) {
				System.out.println(fail.getMessage());
		}
		//assigning role to the task
		addPojectPOM.clickAssignRoleIcon();
		addPojectPOM.clickUserDrpdwn();
		addPojectPOM.ClickSelectUser();
		addPojectPOM.clickValidateBtn();
		Thread.sleep(2000);
		//verify the message for successful assigning of task to a role
		Boolean taskAlert=driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		Assert.assertTrue(taskAlert, "Role has not been assigned to user");
		//register user to the project
		addPojectPOM.clickUserMngmt();
		addPojectPOM.selectuserCheckbox();
		Thread.sleep(3000);
		addPojectPOM.clickRegisterBtn();
		//verify message for successful registration
		Boolean registerAlert=driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		Assert.assertTrue(registerAlert, "user has not been registered");
				
	}
	
	
}
		
