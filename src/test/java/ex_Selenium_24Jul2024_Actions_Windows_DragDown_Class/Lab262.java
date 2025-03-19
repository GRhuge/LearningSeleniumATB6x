package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab262 {
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
	public void testPositiveWindowsOptions77() throws InterruptedException {
		driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement searchelement = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchelement.sendKeys("India"+Keys.ENTER);
		
		List<WebElement> list_of_states = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		
		for(WebElement l : list_of_states) {
			String s1 = driver.findElement(with(By.xpath("//div[@title='225']")).toRightOf(l)).getText();
			String s2 = driver.findElement(with(By.xpath("//div[@title='225']")).toLeftOf(l)).getText();
			String s3 = driver.findElement(with(By.xpath("//div[@title='225']")).below(l)).getText();
			String s4 = driver.findElement(with(By.xpath("//div[@title='225']")).above(l)).getText();
			System.out.println(l.getText() + " --> " + s1 + " --> " + s2);
			System.out.println(l.getText() + " --> " + s3 + " --> " + s4);
		}	
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}