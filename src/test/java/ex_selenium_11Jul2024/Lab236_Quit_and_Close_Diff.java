package ex_selenium_11Jul2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab236_Quit_and_Close_Diff {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.vwo.com");
		
		//quit and close difference
		//Thread.sleep(5000);
		//driver.close();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
