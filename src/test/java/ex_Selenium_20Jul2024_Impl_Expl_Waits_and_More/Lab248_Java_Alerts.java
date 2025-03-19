package ex_Selenium_20Jul2024_Impl_Expl_Waits_and_More;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab248_Java_Alerts {
	    
	    ChromeDriver driver;
		@BeforeTest
		public void openBrowser() {
			ChromeOptions options=new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver=new ChromeDriver(options);
		}
		
		@Test(groups="QA")
		@Description("Test Case Description")
		public void testVerifyJSAlerts() {
			
		  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		  System.out.println(driver.getTitle());
		  driver.manage().window().maximize();
		  
	//	  WebElement element=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	//	  element.click();
	//	  WebElement elementConfirm=driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
	//	  elementConfirm.click();
		  WebElement elementPrompt=driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
		  elementPrompt.click();
		  
	//	  Wait for the alert to appear
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		  wait.until(ExpectedConditions.alertIsPresent());
	
	//	  Get the alert
		  Alert alert=driver.switchTo().alert();
	//	  alert.accept();
	//	  alert.dismiss();
		  alert.sendKeys("Krsna");
		  alert.accept();
		  
		  String result=driver.findElement(By.id("result")).getText();
	//	  Assert.assertEquals(result, "You successfully clicked an alert");
	//	  Assert.assertEquals(result, "You clicked: Cancel");
		  Assert.assertEquals(result, "You entered: Krsna");
		}
		
		@AfterTest
		public void closeBrowser() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
}