package ex_selenium_11Jul2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab237_Navigate_Command{

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.get("https://google.com");
		d.navigate().to("https://fb.com");
		d.navigate().back();
		d.navigate().forward();
		d.navigate().refresh();
	}
}
