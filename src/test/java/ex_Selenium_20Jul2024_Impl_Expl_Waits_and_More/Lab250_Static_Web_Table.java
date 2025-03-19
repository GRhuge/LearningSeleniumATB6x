package ex_Selenium_20Jul2024_Impl_Expl_Waits_and_More;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Lab250_Static_Web_Table {
	ChromeDriver driver;
	@BeforeTest
	public void openBrowser() {
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver=new ChromeDriver(options);
	}
	
	@Test(groups="QA")
	@Description("Test Case Description")
	public void testPositive() {
		driver.get("https://awesomeqa.com/webtable.html");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		//Row - //table[@id='customers']/tbody/tr
		//Col - //table[@id='customers']/tbody/tr[2]/td
		
		int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
	    int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
		
		String first_part="//table[@id='customers']/tbody/tr[";
		String second_part="]/td[";
		String third_part="]";
		
		for(int i=2; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				String dynamic_xpath=first_part+i+second_part+j+third_part;
				String data=driver.findElement(By.xpath(dynamic_xpath)).getText();
				System.out.println(data);
				if(data.contains("Helen Bennett")) {
					String country_path=dynamic_xpath+"/following-sibling::td";
					String country_company=dynamic_xpath+"/preceding-sibling::td";
					
					String country_text=driver.findElement(By.xpath(country_path)).getText();
					String company_text=driver.findElement(By.xpath(country_company)).getText();
					
					System.out.println("-----");
					System.out.println("Helen Bennett is In-" + country_text);
					System.out.println("Helen Bennett working in - " + company_text);
				}
			}
		}
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