package ex_Selenium_24Jul2024_Actions_Windows_DragDown_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab265_Google {
	@Test
	public void google() {
		try {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		WebElement ele=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		driver.navigate().refresh();
		WebElement ele2=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		ele.sendKeys("TTA");
		}catch(StaleElementReferenceException e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}