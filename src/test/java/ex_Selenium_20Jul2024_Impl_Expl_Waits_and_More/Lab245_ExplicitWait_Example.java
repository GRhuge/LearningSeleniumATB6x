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

public class Lab245_ExplicitWait_Example {
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
		
		driver.findElement(By.id("login-username")).sendKeys("rahul@zilliontechnologies.com");
		driver.findElement(By.id("login-password")).sendKeys("rahul4321");
		driver.findElement(By.id("js-login-btn")).click();
		
		WebElement error_msg=driver.findElement(By.id("js-notification-box-msg"));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.textToBePresentInElement(error_msg, "Your email, password, IP address or location did not match"));
		
		Assert.assertEquals(error_msg.getText(), "Your email, password, IP address or location did not match");
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