package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCoursesPOM {
	
	private WebDriver driver;
	
	public SearchCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Course")
	WebElement courseLink;
	
	@FindBy(id = "course-search-keyword")
	public WebElement keyword;
	
	@FindBy(id = "search_simple_submit")
	private WebElement searchBtn;
	
	public void clickCourseLink() {
		this.courseLink.click();
	}
	
	public void sendKeyword(String keyword) {
		this.keyword.clear(); 
		this.keyword.sendKeys(keyword); 
	}
	public void ClickSearchBtn() {
	this.searchBtn.click();
	}
	

}
