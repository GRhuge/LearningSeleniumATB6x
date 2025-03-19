package ex_Selenium_20Jul2024_Impl_Expl_Waits_and_More;

import java.time.Duration;
import java.util.List;

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

public class Lab246_ExplicitWait_Example2 {
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver=new ChromeDriver(options);
	}
	
	@Test(groups="QA")
	@Description("Test Case Description")
	public void testVerifyFreeTrial() {
		driver.get("https://app.vwo.com/#/login");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		driver.findElement(By.id("login-username")).sendKeys("rahuldigital51@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Rahul123@");
		driver.findElement(By.id("js-login-btn")).click();
		
		//Wait to Dashboard to load
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-qa='lufexuloga']")));
		
		WebElement loggedin_username=driver.findElement(By.cssSelector("span[data-qa='lufexuloga']"));
		System.out.println("Logged in User Details -> "+loggedin_username);
		Assert.assertEquals(loggedin_username.getText(), "Rahul G");
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