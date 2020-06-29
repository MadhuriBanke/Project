package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPOM {
private WebDriver driver; 
	
	public RecoverPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),' I lost my password ')]")
	public WebElement lostPswdLink;
	
	@FindBy(id = "lost_password_user")
	public WebElement UserText;
	
	@FindBy(id = "lost_password_submit")
	public WebElement sendMessageBtn;
	
	@FindBy(className = "alert alert-info")
	public WebElement SuccessNtfn;
	
	public void clicklostPswdLink(){
		this.lostPswdLink.click();
	}
	
	public void enterUserText(String username) {
		this.UserText.clear();
		this.UserText.sendKeys(username);
		
	}
	
	public void clicksendMessageBtn() {
		this.sendMessageBtn.click();
	}
	
	public void getSuccessNtfn() {
		this.SuccessNtfn.getText();
	}

}