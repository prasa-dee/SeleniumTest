package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PG_GoogleSearch;

public class TS_GoogleSearch {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Go to google
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	
	@Test
	public void tc_001_GoogleSerch() {
		//Creating a method level object from page class (can create globally as well
		PG_GoogleSearch page = new PG_GoogleSearch(driver);
		page.searchGoogle("cat"); //integrate data file to retrieve data
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
