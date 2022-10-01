package pages;

import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PG_GoogleSearch {
	
	WebDriver driver;
	
	//Constructor
	public PG_GoogleSearch(WebDriver driver) {
		//as soon as you call this class that object is referring to the driver,
		this.driver = driver;
	}
	
	
	//Locators
	By tfGoogleSerch = By.xpath("//input[@name='q']");
	By btnSearch = By.xpath("//input[@name='btnK'][1]");
	
	
	//Business Actions
	public void searchGoogle(String SearchInput) {
		try {
			driver.findElement(tfGoogleSerch);
			driver.findElement(tfGoogleSerch).sendKeys(SearchInput);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(btnSearch).click();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception cought " + e.getMessage());
		}

	}

}
