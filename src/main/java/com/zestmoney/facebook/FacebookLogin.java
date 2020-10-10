package com.zestmoney.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.compare.Base;

public class FacebookLogin extends Base {

	@FindBy(xpath="//input[@id='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement submit;
	
	
	public FacebookLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String usrname) {
		username.sendKeys(usrname);
	}
	
	public void enterPassword(String psswrd) {
		password.sendKeys(psswrd);
	}
	
	public FacebookPost clickSubmitbtn() {
		 submit.click();
		 return new FacebookPost(driver);
	}
	
	public List<WebElement> getUsrError() {
	return driver.findElements(By.xpath("//input[@placeholder='Email address or phone number']/parent::div//child::div/a"));
	}	
	
	public List<WebElement> getPassError() {
	return driver.findElements(By.xpath("//input[@placeholder='Password']/parent::div//child::div/a //passworderror"));
	}
}
