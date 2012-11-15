package fitnesse.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FitNesseTestResultsPage extends FitNesseResultsPage{
	
	
	public FitNesseTestResultsPage(WebDriver driver) {
		super(driver);
		
	}
	

	
	public int getRightCount(){
		return getCountFromTestSummaryUsingPattern(RIGHTCOUNT);
	}
	
	public int getWrongCount(){
		return getCountFromTestSummaryUsingPattern(WRONGCOUNT);
	}
	public int getIgnoredCount(){
		return getCountFromTestSummaryUsingPattern(IGNOREDCOUNT);
	}
	
	public int getExceptionCount(){
		return getCountFromTestSummaryUsingPattern(EXCEPTIONCOUNT);
	}
	
	protected Pattern getTestCountPattern(){
		return Pattern.compile("Assertions:\\s+(\\d+)\\s+right,\\s+(\\d+)\\swrong,\\s+(\\d+)\\signored,\\s+(\\d+)\\sexceptions");
	}
	
	public FitNesseTestResultsPage waitForTestToComplete(Integer seconds){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.textToBePresentInElement(By.id("test-summary"), "Assertions:"));
		return this;
	}

}
