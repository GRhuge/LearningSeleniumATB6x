package ex_selenium_13Jul2024_Xpath_Ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab242_VWOLogin2_Trail_Xpath_Eg {
	@Test
	public void testVerifyFreeTrail() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.vwo.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Login - VWO");
		Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
		
	//	driver.findElement(By.linkText("Start a free trial")).click();
		driver.findElement(By.partialLinkText("Start a free")).click();
		driver.findElement(By.id("page-v1-step1-email")).sendKeys("admin@admin.com");
		driver.findElement(By.name("gdpr_consent_checkbox")).click();
		driver.findElements(By.xpath("//button[@type='submit']")).get(0).click();
		WebElement error_msg_email_exist=driver.findElement(By.className("invalid-reason"));
		System.out.println(error_msg_email_exist.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}