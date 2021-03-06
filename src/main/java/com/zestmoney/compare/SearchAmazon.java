package com.zestmoney.compare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAmazon extends Base{
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	private WebElement searchbtn;
	
	public SearchAmazon(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product) {
		searchbox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchbtn.click();
	}
	
	public List<WebElement> getPhoneNames() {
		 return driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']/span"));
	}
	
	public List<WebElement> getPrices() {
		return driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']/span//following::span[@class='a-price-whole']"));
	}


}
