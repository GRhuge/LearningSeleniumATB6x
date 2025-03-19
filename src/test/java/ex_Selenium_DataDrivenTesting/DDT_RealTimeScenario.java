package ex_Selenium_DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class DDT_RealTimeScenario {
	
	@BeforeClass
	public void setUp() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	WebDriver driver;
	
	@Test(dataProvider="loginData")
	public void testDataDriven(String email, String password, String expectedResult) {
		
		driver.get("https://app.vwo.com");
		WebElement emailElement = driver.findElement(By.id("login-username"));
		emailElement.clear();
		emailElement.sendKeys(email);
		
		WebElement passwordElement = driver.findElement(By.id("login-password"));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		driver.findElement(By.id("js-login-btn")).click();
		
		if(expectedResult.equalsIgnoreCase("Valid")) {
			String text = driver.findElement(By.xpath("//input[@id='login-username']")).getText();
			System.out.println(text);
		//	Assert.assertEquals(text, "Wingify");
		}
		
		if(expectedResult.equalsIgnoreCase("InValid")){
			WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(error_message));
			Assert.assertTrue(error_message.isDisplayed());
			Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
		}
	}
	
//	@DataProvider(name="loginData")
//	public Object[][] testData(){
//		return new Object[][] {
//			{"TD1", "24sfb2cb@asfv.coo", "Wingify@123", "Invalid"},
//			{"TD2", "2455sfb2cb@asfv.coo", "Wingify@123", "Valid"}
//		};
//	}
	
	@DataProvider(name = "loginData")
	public String[][] testDataExcel() throws IOException{
		String testDataFile = "E:\\ABTB6x\\LearningSeleniumATB6x\\resources\\TataData.xlsx";
		ExcelReader excelReader = new ExcelReader(testDataFile);
		String[][] data = excelReader.getDataFromSheet(testDataFile, "LoginData");
		return data;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}