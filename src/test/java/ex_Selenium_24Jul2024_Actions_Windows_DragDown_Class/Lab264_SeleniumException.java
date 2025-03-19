package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab264_SeleniumException {
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("---guest");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void testPositiveSeleniumExceptions() {
		driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
		driver.manage().window().maximize();
		
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.click();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}