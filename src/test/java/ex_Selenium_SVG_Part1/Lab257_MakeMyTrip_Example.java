package ex_Selenium_SVG_Part1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab257_MakeMyTrip_Example {
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
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		
		Thread.sleep(8000);
		
		WebElement source = driver.findElement(By.id("fromcity"));	
		
		Actions action = new Actions(driver);
		action.moveToElement(source).click().sendKeys("MUM").build().perform();
		
		List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		
		for(WebElement e: list_auto_complete) {
			if(e.getText().contains("Mumbai")) {
			e.click();
			break;
			}
		}
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(8000);
		driver.quit();
	}
}