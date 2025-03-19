package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import java.util.Set;

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

public class Lab260_Windows_Options {
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
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Before Click "+mainWindowHandle);
		WebElement link = driver.findElement(By.linkText("Click Here"));
		link.click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		//All the windows tab have a unique name
		
		for(String handle : windowHandles) {
			driver.switchTo().window(handle);
			System.out.println(handle);
			if(driver.getPageSource().contains("New Window")) {
				System.out.println("Test case passed");
				
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(mainWindowHandle);
		 
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
