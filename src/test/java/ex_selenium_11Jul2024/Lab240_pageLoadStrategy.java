package ex_selenium_11Jul2024;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab240_pageLoadStrategy {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://app.vwo.com/#/login");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
