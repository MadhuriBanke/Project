package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TakeAssesmentPOM {
private WebDriver driver;
	
	public TakeAssesmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()='Course catalog']")
	public WebElement courseCatalougeLink;
	
	@FindBy(xpath = "//input[@name='search_term']")
	private WebElement courseSearchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@title='CoursewithTest']")
	private WebElement CourseLink;
	
	@FindBy(xpath = "//*[@class='btn btn-lg btn-success btn-block']")
	private WebElement SubscribeBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement RegistrationAlert;
	
	@FindBy(xpath = "//*[@title='Assessments']")
	private WebElement AssesmentIcon;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]//*[text()='Test1']")
	private WebElement TestDisplayed;
	
	@FindBy(xpath = "//a[@class='btn btn-success btn-large']")
	private WebElement TestStartBtn;
	
	@FindBy(xpath = "//label[@class='radio ']")
	private WebElement radioBtn1;
	
	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement NextQuesBtn1;
	
	@FindBy(xpath = "//label[@class='radio ']")
	private WebElement redioBtn2;
	
	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement NextQuesBtn2;
	
	@FindBy(xpath = "//label[@class='checkbox']")
	private WebElement checkboxBtn3;
	
	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement NextQuesBtn3;
	
	@FindBy(xpath = "//label[@class='radio ']")
	private WebElement radioBtn4;
	
	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement EndBtn4;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement TestSavedAlert;
	
	@FindBy(xpath = "//*[@class='alert alert-info']//*[text()='Your test test is completed']")
	private WebElement TestcompletedAlert;
	
	@FindBy(xpath = "//*[text()='Congratulations you passed the test!']")
	private WebElement TestResult;
	
	public void clickCourseCatalougeLink() {
		this.courseCatalougeLink.click();
	}
	
	public void EnterCourseSearchBox(String keysToSend) {
		this.courseSearchBox.clear();
		this.courseSearchBox.sendKeys(keysToSend);
	}
	public void clickSearchBtn() {
		this.searchBtn.click();
	}
	public void clickCourseLink() {
		this.CourseLink.click();
	}
	public void clickSubscribeBtn() {
		this.SubscribeBtn.click();
	}
	public void clickAssesmentIcon() {
		this.AssesmentIcon.click();
	}
	public void clickTestLink() {
		this.TestDisplayed.click();
	}
	public void clickTestStartBtn() {
		this.TestStartBtn.click();
	}
	public void clickNextQuesBtn1() {
		this.NextQuesBtn1.click();
	}
	public void clickNextQuesBtn2() {
		this.NextQuesBtn2.click();
	}
	public void clickNextQuesBtn3() {
		this.NextQuesBtn3.click();
	}
	public void clickEndBtn4() {
		this.EndBtn4.click();
	}
}
