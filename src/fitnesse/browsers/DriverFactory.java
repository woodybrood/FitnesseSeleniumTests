package fitnesse.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DriverFactory {
	
	public static String FIREFOX = "firefox";
	public static String HTMLUNIT = "htmlunit";
	
	public static WebDriver getDriver(String browserName) throws Exception{
		if (FIREFOX.equalsIgnoreCase(browserName)){
			return buildFirefoxDriver();
		} else if (HTMLUNIT.equalsIgnoreCase(browserName)){
			return buildHtmlUnitDriver();
		} else {
			throw new Exception("No valid browser selected");
		}
	}
	
	private static WebDriver buildFirefoxDriver(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver;
	}
	
	private static WebDriver buildHtmlUnitDriver(){
		WebDriver driver = new HtmlUnitDriver();
		return driver;
	}

}
