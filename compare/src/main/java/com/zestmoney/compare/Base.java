package com.zestmoney.compare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	FileInputStream fi;
	Properties prop;
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
		try {
			 fi = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\prop.properties");
			 prop = new Properties();
			 prop.load(fi);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	public String searchPhoneAndReturnPrice(List<WebElement> phoneNames,List<WebElement> phonePrices ) {
		int flag = 0;
		 String phoneName = null;
		 String phonePrice = null;
		 for(int i=0;i<phoneNames.size();i++) {
			phoneName = phoneNames.get(i).getText();
			phoneName = phoneName.toUpperCase();
			String model = prop.getProperty("model");
			String color = prop.getProperty("color");
			if(phoneName.contains(model) && phoneName.contains(color))
			{
				 phonePrice = phonePrices.get(i).getText();
				flag=1;
				break;
			}
		}
		 if(flag==1) {
			return phonePrice;
		 }
		 else {
			 return null;
		 }

		}
		
}