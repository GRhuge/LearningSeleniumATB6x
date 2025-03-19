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

public class Lab256_SpiceJet_Example {
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
		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
		
		Actions action = new Actions(driver);
//		action.moveToElement(source).click().build().perform();
		action.moveToElement(source).click().sendKeys("MUM").build().perform();
//		source.sendKeys("chandi");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}