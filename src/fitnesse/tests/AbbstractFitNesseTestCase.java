package fitnesse.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import fitnesse.browsers.DriverFactory;

public abstract class AbbstractFitNesseTestCase {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void startBrowser() throws Exception{
		driver = DriverFactory.getDriver(DriverFactory.FIREFOX);
	}
	
	
	@AfterClass
	public static void closeBrowser(){
		driver.close();
		driver.quit();
	}
	
	

}
