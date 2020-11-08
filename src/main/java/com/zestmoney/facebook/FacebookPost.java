package com.zestmoney.facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zestmoney.compare.Base;

public class FacebookPost extends Base{
	
	@FindBy(xpath="(//div[@aria-label='Create a post']//child::div/span)[1]")
	private WebElement postComment;
	
	@FindBy(xpath="//div[text()='Post']")
	private WebElement postButton;
	
	@FindBy(xpath="//div[contains(@aria-describedby,'placeholder')]")
	private WebElement postPop;
	
	public FacebookPost(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPost() {
		postComment.click();
	}
	
	public void postPop(String comment) {
		postPop.sendKeys(comment);
	}
	
	public void clickPostbtn() {
		postButton.click();
	}
	
	public List<WebElement> homelogo() {
		return driver.findElements(By.xpath("//a[@aria-label='Home']"));
	}
}
