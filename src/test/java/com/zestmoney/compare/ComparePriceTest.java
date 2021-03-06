package com.zestmoney.compare;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.zestmoney.compare.Base;
import com.zestmoney.compare.SearchAmazon;

public class ComparePriceTest extends Base{
	int amazonprice ;
	int flipkartprice ;
	String amazonresult;
	String flipkartresult;
	
	
@BeforeTest
public void browser() {
	openBrowser();
}
@Test(priority=1)
 public void getPriceAmazon() throws Exception {

	log.info("open amazon url");
	driver.get(prop.getProperty("amazonurl"));
	Thread.sleep(5000);
	SearchAmazon amazon = new SearchAmazon(driver);
	amazon.searchProduct(prop.getProperty("productsearch"));
	amazon.clickSearchBtn();
	Thread.sleep(5000);
	List<WebElement> phoneNames = amazon.getPhoneNames();
	List<WebElement> phonePrices = amazon.getPrices();
	
	amazonresult = searchPhoneAndReturnPrice(phoneNames,phonePrices);
	if(amazonresult!=null) {
	String[] amares = amazonresult.split(",");
	String amazonresult = amares[0]+amares[1];
	String price = amazonresult;
	amazonprice = Integer.parseInt(price);
	System.out.println("phone found on amazon and price is : "+amazonprice);
	}
	else {
		System.out.println("Phone not found on Amazon");
	}
	
	log.info("amazon execution successful");
}

@Test(priority=2)
public void getPriceFlipKart() throws Exception {
	
	log.info("open flipkart url");
	driver.get(prop.getProperty("flipkarturl"));
	Thread.sleep(5000);
	SearchFlipkart flipkart = new SearchFlipkart(driver);
	flipkart.clickCancel();
	flipkart.searchProduct(prop.getProperty("productsearch"));
	flipkart.clickSearchBtn();
	Thread.sleep(5000);
	List<WebElement> phoneNames = flipkart.getPhoneNames();
	List<WebElement> phonePrices = flipkart.getPrices();

	flipkartresult = searchPhoneAndReturnPrice(phoneNames,phonePrices);
	if(flipkartresult!=null) {
	String price = flipkartresult.substring(1);
	String[] flipprice = price.split(",");
	price = flipprice[0]+flipprice[1];
	flipkartprice = Integer.parseInt(price);
	System.out.println("phone found on flipkart and price is : "+flipkartprice);
	}
	else {
		System.out.println("Phone not found on Flipkart");
	}
	
	log.info("flipkart execution successful");
}

@Test(priority=3)
public void compare() {
	System.out.println("Final Compare Result Is :-");
	if(amazonresult==null || flipkartresult==null) {
		System.out.println("Item not found on any or both website");
	}
	else if(amazonprice<flipkartprice) {
		System.out.println("amazon has lesser price");
	}
	else if(amazonprice>flipkartprice) {
		System.out.println("flipkart has lesser price");
	}
	else{
		System.out.println("price on both website is same");
	}

}


@AfterTest()
public void tearDown()
{
	driver.close();
}

}
