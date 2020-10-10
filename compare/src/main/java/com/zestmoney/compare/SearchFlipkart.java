package com.zestmoney.compare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlipkart extends Base {
	
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement clickCancel;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchBtn;
	
	
	public SearchFlipkart(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickCancel() {
		clickCancel.click();
	}
	
	public void searchProduct(String product) {
		searchBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public List<WebElement> getPhoneNames() {
		 return driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	}
	
	public List<WebElement> getPrices() {
		return driver.findElements(By.xpath("//div[@class='_3wU53n']/parent::div/following-sibling::div//div[contains(@class,'1vC4OE')]"));
	}
}
