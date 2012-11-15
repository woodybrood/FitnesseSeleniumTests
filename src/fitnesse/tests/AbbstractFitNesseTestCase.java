package fitnesse.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import test.utility.EnvironmentVariableProvider;

import fitnesse.browsers.DriverFactory;

public abstract class AbbstractFitNesseTestCase {
	
	protected static WebDriver driver;
	protected static String fitnesseServer;
	
	@BeforeClass
	public static void startBrowser() throws Exception{
		driver = DriverFactory.getDriver(EnvironmentVariableProvider.getBrowserToUse());
		fitnesseServer = EnvironmentVariableProvider.getFitnesseServer();
	}
	
	
	@AfterClass
	public static void closeBrowser(){
		driver.close();
		driver.quit();
	}
	
	

}
