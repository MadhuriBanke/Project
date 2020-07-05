package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProjectPOM {
	private WebDriver driver;
	
	public AddProjectPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='APITetsting']")
	private WebElement courseLink;
	
	@FindBy(xpath = "//*[@title='Projects']")
	private WebElement projectIcon;
	
	@FindBy(xpath = "//*[@title='Create a new project']")
	private WebElement createprojectIcon;
	
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement projectTitle;
	
	@FindBy(xpath = "//textarea[@class='form-control']")
	private WebElement projectSubTitle;
	
	@FindBy(xpath = "//button[@id='add_blog_submit']")
	private WebElement saveBlogBtn;
	
	@FindBy(xpath = "//*[text()='e learning']")
	private WebElement projectLink;
	
	@FindBy(xpath = "//*[@alt='New task']")
	private WebElement taskIcon;
	
	@FindBy(xpath = "//input[@id='add_post_title']")
	private WebElement taskTitle;
	
	@FindBy(xpath = "//button[@id='add_post_save']")
	private WebElement taskSaveBtn;
	
	@FindBy(xpath = "//*[@title='Roles management']")
	private WebElement roleMgntIcon;

	@FindBy(xpath = "//*[@title='Add a new role']")
	private WebElement addRoleIcon;
	
	@FindBy(xpath = "//input[@name='task_name']")
	private WebElement NewroleTitle;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement roleSaveBtn;
	
	@FindBy(xpath = "//*[@title='Assign roles']")
	private WebElement assignRoleIcon;

	@FindBy(xpath = "//div[text()='Site Owner']")
	private WebElement userDrpdwn;
	
	@FindBy(xpath = "//span[@class='text' and text()='Site Owner']")
	private WebElement SelectUser;
	
	@FindBy(xpath = "//button[@id='assign_task_submit']")
	private WebElement validateBtn;

	@FindBy(xpath = "//*[@title='Users management']")
	private WebElement userMngmt;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement userCheckbox;
	
	@FindBy(xpath = "//a[text()='Register' and @class='btn btn-primary']")
	private WebElement registerBtn;
	
	public void clickCourseLink() {
		this.courseLink.click();
	}
	
	public void clickProjectIcon() {
		this.projectIcon.click();
	}
	
	public void clickCreateprojectIcon() {
		this.createprojectIcon.click();
	}
	
	public void enterProjectTitle(String Title) {
		this.projectTitle.clear();
		this.projectTitle.sendKeys(Title);		
	}
	
	public void enterProjectSubTitle(String Subtitle) {
		this.projectSubTitle.clear();
		this.projectSubTitle.sendKeys(Subtitle);		
	}
	
	public void clickSaveBlogBtn() {
		this.saveBlogBtn.click();
	}
	
	public void clickProjectLink() {
		this.projectLink.click();
	}
	
	public void clickTaskIcon() {
		this.taskIcon.click();
	}
	
	public void enterTaskTitle(String keysToSend) {
		this.taskTitle.clear();
		this.taskTitle.sendKeys(keysToSend);
	}
	
	public void clickTaskSaveBtn() {
		this.taskSaveBtn.click();
	}
	
	public void clickRoleMgntIcon() {
		this.roleMgntIcon.click();
	}
	
	public void clickAddRoleIcon() {
		this.addRoleIcon.click();
	}
	
	public void EnterNewroleTitle(String keysToSend) {
		this.NewroleTitle.clear();
		this.NewroleTitle.sendKeys(keysToSend);
	}
	public void clickRoleSaveBtn() {
		this.roleSaveBtn.click();
	}
	
	public void clickAssignRoleIcon() {
		this.assignRoleIcon.click();
	}
	//public void clickUserDrpdwn(String UserName) {
		//Select UserDropdown = new Select(userDrpdwn);
		//UserDropdown.selectByVisibleText(UserName);
	public void clickUserDrpdwn() {
		this.userDrpdwn.click();
	}
	public void ClickSelectUser() {
		this.SelectUser.click();
	}
	public void clickValidateBtn() {
		this.validateBtn.click();
	}
	public void clickUserMngmt() {
		this.userMngmt.click();
	}
	public void selectuserCheckbox() {
		this.userCheckbox.click();
	}
	public void clickRegisterBtn() {
		this.registerBtn.click();
	}
}
