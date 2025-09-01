package initiation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import basepages.ContactUsPageObject;
import basepages.PageClasses;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasses extends PageClasses{
	
	@BeforeSuite
	public void initializingWeb() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver= new ChromeDriver(options);
			
		driver.get("https://arkenea.com/contact-us/");
		
		driver.manage().window().maximize();
		
		
	}
	
	
	@BeforeMethod
	public void allPageObject() throws IOException
	{
		
		ContactPage = new ContactUsPageObject(driver);
		
		
						
	}
	
	@AfterSuite
	public void tearDowmBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
