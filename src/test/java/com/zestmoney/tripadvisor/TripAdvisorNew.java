package com.zestmoney.tripadvisor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripAdvisorNew {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rajadube\\Rajan\\localAutomation\\resourcedownloaded\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in/");
		driver.findElement(By.xpath("(//input[@type = 'search'])[2]")).sendKeys("Club Mahindra");
		System.exit(1);
		driver.findElement(By.xpath("//div[text() = \"Club Mahindra Madikeri, Coorg\"]")).click();
		driver.findElement(By.linkText("Write a review")).click();
		Thread.sleep(2000);
		new Actions(driver).moveToElement(new WebDriverWait(driver, 20)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bubble_rating']"))), 50, 0)
		.click().build().perform();
		Thread.sleep(2000);
		driver.quit();
	}
}