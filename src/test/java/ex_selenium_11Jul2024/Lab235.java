package ex_selenium_11Jul2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab235 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://sdet.live");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
	}
}
