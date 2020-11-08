package com.zestmoney.tripadvisor;

	import java.util.Iterator;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.zestmoney.compare.Base;
	import com.zestmoney.facebook.FacebookPost;

	public class TripAdvisorTest extends Base{
		
		FacebookPost post;
		@BeforeTest
		public void browser() {
			openBrowser();
		}

		@Test(priority=1)
		public void search() throws InterruptedException {
			
			driver.get("https://www.tripadvisor.in/");

			js.executeScript("window.scrollBy(0,900)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys("club mahindra");
			driver.findElement(By.xpath("(//button[@type='submit' and @title='Search'])[1]")).click();
			System.out.println("title1 "+driver.getTitle());
			WebElement firstresult = driver.findElement(By.xpath("(//div[@class='result-title'])[1]"));
			firstresult.click();
			a.keyDown(Keys.SHIFT).click(firstresult).build().perform();
			Thread.sleep(5000);
			Set<String> windows = driver.getWindowHandles();
			System.out.println("windows "+windows);
			Iterator<String> itr = windows.iterator();
			String mainwin = itr.next();
			System.out.println("mainwin "+mainwin);
			while(itr.hasNext()) {
				String newwin = itr.next();
				System.out.println("win"+newwin);
				driver.switchTo().window(newwin);  
				System.out.println("switched to tab successfully");
			}
			Thread.sleep(5000);
			System.out.println("title3 "+driver.getTitle());
			driver.manage().window().maximize();
			WebElement review = driver.findElement(By.xpath("//div[@id='COMMUNITYCONTENT']//a[contains(@href,'UserReview')]"));
			review.click();
			Set<String> reviewwindows = driver.getWindowHandles();
			Iterator<String> reviewitr = reviewwindows.iterator();
			while(reviewitr.hasNext()) {
				String newwinrev = reviewitr.next();
				System.out.println("win"+newwinrev);
				driver.switchTo().window(newwinrev);  
				System.out.println("switched to tab successfully");
			}
			
			WebDriverWait wait = new WebDriverWait(driver,90);
			
			WebElement bubble = driver.findElement(By.xpath("//span[@id='bubble_rating']"));
			
			wait.until(ExpectedConditions.visibilityOf((bubble)));
			
			a.moveToElement(bubble, 50, 0).build().perform();
			Thread.sleep(3000);
		}
	}

