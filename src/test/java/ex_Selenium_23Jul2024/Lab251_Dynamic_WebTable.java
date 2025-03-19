package ex_Selenium_23Jul2024;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab251_Dynamic_WebTable {
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("---guest");
		driver = new ChromeDriver(options);
		}
	
	@Test(groups = "QA")
	@Description("Test Case Descriptions")
	public void testPositive() {
		driver.get("https://awesomeqa.com/webtable1.html");
		driver.manage().window().maximize();
		
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> rows_tables = table.findElements(By.tagName("tr"));
		System.out.println(rows_tables.size());
		
		for(int i = 0; i < rows_tables.size(); i++) {
			List<WebElement> col = rows_tables.get(i).findElements(By.tagName("td"));
			for(WebElement c:col) {
				System.out.println(c.getText());
			}
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}