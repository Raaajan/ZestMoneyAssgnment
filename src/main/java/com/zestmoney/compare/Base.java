package com.zestmoney.compare;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Base {
	
	public WebDriver driver;
	FileInputStream fi;
	protected Properties prop;
	protected JavascriptExecutor js;
	protected Actions a;
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver 
		//which will switch off this browser notification on the chrome browser
		driver = new ChromeDriver(options);
	
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		try {
			 fi = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\prop.properties");
			 prop = new Properties();
			 prop.load(fi);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		js = (JavascriptExecutor)driver;
		a = new Actions(driver);
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