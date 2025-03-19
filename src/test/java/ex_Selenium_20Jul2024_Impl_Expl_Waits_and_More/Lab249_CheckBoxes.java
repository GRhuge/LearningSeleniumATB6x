package ex_Selenium_20Jul2024_Impl_Expl_Waits_and_More;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab249_CheckBoxes {

	  ChromeDriver driver;
	  @BeforeTest
	  public void openBrowser() {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  driver=new ChromeDriver(options);
	  }
			
	  @Test(groups="QA")
	  @Description("Test Case Description")
	  public void testVerifyCheckboxes() {
				
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  System.out.println(driver.getTitle());
	  driver.manage().window().maximize();
	  
	  List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox'][1]"));
	  checkboxes.get(0).click();
	  
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
