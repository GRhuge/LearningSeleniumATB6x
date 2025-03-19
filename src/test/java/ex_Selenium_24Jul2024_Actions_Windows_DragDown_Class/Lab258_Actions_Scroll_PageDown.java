package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab258_Actions_Scroll_PageDown {
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
	public void testPositive() {
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("Scroll Down");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}