package com.zestmoney.facebook;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zestmoney.compare.Base;

public class FacebookTest extends Base{
	FacebookTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	FacebookPost post;
	@BeforeTest
	public void browser() {
		openBrowser();
	}
	@Test(priority=1)
	 public void facebookLogin() throws Exception {
		
		driver.get(prop.getProperty("facebookurl"));
		log.info("Opened facebook URL");
		FacebookLogin login = new FacebookLogin(driver);
		login.enterUsername(prop.getProperty("usrname"));
		log.info("username entered");
		Thread.sleep(5000);
		login.enterPassword(prop.getProperty("password"));
		log.info("password entered");
		post = login.clickSubmitbtn();
		
	}
	@Test(priority=2)
	 public void facebookPost() throws Exception {
		
		List<WebElement> present = post.homelogo();
		if(present.size()>0) {
			System.out.println("login successfull in facebook");
		}
		else{
			Assert.assertTrue(false, "Login failed in facebook");
		}
		post = new FacebookPost(driver);
		post.clickPost();
		Thread.sleep(3000);
		post.postPop(prop.getProperty("msgtopost"));
		post.clickPostbtn();
		System.out.println("msg post successfully");
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}

}
