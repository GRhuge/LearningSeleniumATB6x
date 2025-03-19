package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Lab261_Relative_Locators {
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
	public void testPositiveWindowsOptions() throws InterruptedException {
		driver.get("https://awesomeqa.com/practice.html");
		driver.manage().window().maximize();
		WebElement span_element = driver.findElement(By.xpath("//span[.='Years of Experience']"));
		driver.findElement(with(By.id("exp-4")).toRightOf(span_element)).click();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}