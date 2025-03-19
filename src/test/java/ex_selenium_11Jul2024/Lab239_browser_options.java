package ex_selenium_11Jul2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab239_browser_options {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		//We can run the browser in Headless(No UI) mode or full mode
		//Headless means - No UI ,so performance is good, fast execution
		//FUll mode - UI present and performance will lag
		
		//Options - Browser - It start maximize, add extension, add option
		
		//options.addArguments("start-maximized");
		//options.addArguments("window-size=800,6 00");
		options.addArguments("guest");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://google.com");
		Thread.sleep(5000);
		driver.quit();
	}

}
