package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPOM {
		private WebDriver driver; 
		
		public ChangePasswordPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText = "Homepage")
		public WebElement homepageBtn;
		
		@FindBy(linkText = "Edit profile")
		public WebElement editBtn;
		
		@FindBy(id = "profile_password0")
		public WebElement oldPassword;
		
		@FindBy(id = "password1")
		public WebElement newPassword;
		
		@FindBy(id = "profile_password2")
		public WebElement confirmPassword;
		
		@FindBy(id = "profile_apply_change")
		public WebElement SaveBtn;
		
		public void ClickHomepage() {
		this.homepageBtn.click();
		}
		
		public void ClickEditProfile() {
			this.editBtn.click();
		}
		
		public void SendOldPassword(String oldPassword) {
			this.oldPassword.clear();
			this.oldPassword.sendKeys(oldPassword);
		}
		
		public void SendNewPassword(String newPassword) {
			this.newPassword.clear();
			this.newPassword.sendKeys(newPassword);
		}
		
		public void SendConfrmPassword(String confirmPassword) {
			this.confirmPassword.clear();
			this.confirmPassword.sendKeys(confirmPassword);
		}
		
		public void ClickSaveBtn() {
			this.SaveBtn.click();
		}

}
