package ex_selenium_11Jul2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab238 {
	@Test
	public void testVWOLoginTitle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.vwo.com");
		Assert.assertEquals(driver.getTitle(), "Login - VWO");
		Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
		driver.quit();
	}
}
