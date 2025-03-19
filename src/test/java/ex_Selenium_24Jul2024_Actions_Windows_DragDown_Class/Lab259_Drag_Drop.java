package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

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

public class Lab259_Drag_Drop {
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
	public void testPositiveDragDrop() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		WebElement from = driver.findElement(By.id("column-a"));
		WebElement to = driver.findElement(By.id("column-b"));
//		actions.dragAndDrop(from, to).perform();
		actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
		
		Thread.sleep(3000);
		
		driver.get("https://awesomeqa.com/selenium/upload.html");
		WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
		uploadFileInput.sendKeys("E:\\ABTB6x\\LearningSeleniumATB6x\\src\\test\\java\\ex_Selenium_Actions_Windows_DragDown_Class\\toUpload.txt");
		driver.findElement(By.name("submit")).click();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
}