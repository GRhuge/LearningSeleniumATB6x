package ex_Selenium_SVG_Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab255_Actions_Class {
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("---guest");
		driver = new ChromeDriver(options);
	}
	
	@Test(groups="QA")
	@Description("Test Case Description")	
	public void testPositive() throws InterruptedException {
		driver.get("https://awesomeqa.com/practice.html");
		driver.manage().window().maximize();
		
		WebElement firstName=driver.findElement(By.name("firstname"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT)
		       .sendKeys(firstName, "thetestingacademy")
		       .keyUp(Keys.SHIFT).build().perform();
		
		WebElement link = driver.findElement(By.xpath("//a[@style='color: #1e73be; margin: 0px; padding: 0px;']"));
		actions.contextClick(link).build().perform();
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}