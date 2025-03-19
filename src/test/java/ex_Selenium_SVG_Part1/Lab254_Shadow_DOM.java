package ex_Selenium_SVG_Part1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab254_Shadow_DOM {
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
		driver.get("https://selectorshub.com/xpath-practice-page");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		WebElement divScrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
		js.executeScript("arguments[0].scrollIntoView(true);",divScrollTo);
		
		Thread.sleep(3000);
		
		WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
		inputBoxPizza.sendKeys("Farmhouse");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}