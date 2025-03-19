package ex_Selenium_18Jul2024_Css_Selector;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab244_Css_Selector_Ex {
	
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver=new ChromeDriver(options);
	}
	
	@Test(groups="QA")
	@Description("Test Case Description")
	public void testVerifyFreeTrial() {
		driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.cssSelector("input[id='gh-ac']"));
		searchBox.sendKeys("macmini");
		
		WebElement searchBoxButton = driver.findElement(By.cssSelector("input[value='Search']"));
		searchBoxButton.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> searchTitles = driver.findElements(By.cssSelector("span[role='heading']"));
		List<WebElement> searchTitlesPrices = driver.findElements(By.cssSelector("span[class='s-item__price']"));
//		for(WebElement title : searchTitles) {
//			System.out.println(title.getText());
//		}
//		
//		for(WebElement prices : searchTitlesPrices) {
//			System.out.println(prices.getText());
//		}
		
		int size = Math.min(searchTitles.size(), searchTitlesPrices.size());
		for(int i=0;i<size;i++) {
			System.out.println("Title: " + searchTitles.get(i).getText());
			System.out.println("Price: " + searchTitlesPrices.get(i).getText());
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}



