package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Lab263_IFrame {
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
	public void testPositiveIFrame() throws InterruptedException {
		driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.switchTo().frame("result");
		
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.click();
		
		WebElement element = driver.findElement(By.id("username"));
		
		WebElement errorElement = driver.findElement(with(By.tagName("small")).below(element));
		String errorText = errorElement.getText();
		Assert.assertTrue(errorElement.isDisplayed());
		Assert.assertEquals(errorText,"Username must be at least 3 characters");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
