package ex_selenium_16Jul2024_Xpath_Ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab243_Xpath_Ex {
	@Test
	public void testVerifyFREETrail() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		System.out.println(driver.getTitle());
		
		//Absolute XPath - Full XPath - Type 1
		///html/body/div[2]/div[1]/div[2]/div/div[1]/div/div/div[3]/form[1]/ul/li[1]/div/input
		
		//Relative XPath
		//Core Logic  - //tagname[@attribute='value']
		
		driver.findElement(By.xpath("//a[@href='./profile.php#login']")).click();
	//	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John Doe");
		driver.findElements(By.xpath("//input[@placeholder='Username']")).get(1).sendKeys("John Doe");
		
		}
}