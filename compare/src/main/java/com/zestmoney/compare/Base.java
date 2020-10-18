package com.zestmoney.compare;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public WebDriver driver;
	FileInputStream fi;
	protected Properties prop;
	protected JavascriptExecutor js;
	protected Actions a;
	public static  Logger log;
	
	public void initialize() {
		log = LogManager.getLogger(Base.class);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		try {
			fi = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\prop.properties");
			 prop = new Properties();
			 prop.load(fi);
			 log.info("properties file loaded");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		js = (JavascriptExecutor)driver;
		a = new Actions(driver);
	
		log.info("Basic Initialization done");
	}
	
	
	public void openBrowser() {
		
		/* if we write line code then there is not need to do system.setProperty("",""). 
		Every thing is done automatically we don't need to download driver and keep it in framework. */
		WebDriverManager.chromedriver().setup(); 
		
		
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
	
		driver.manage().deleteAllCookies();
		initialize();
		log.info("browser opened");
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