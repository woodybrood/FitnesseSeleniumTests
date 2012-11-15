package fitnesse.pages;


import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FitNesseSuiteResultsPage extends FitNesseResultsPage {
	
	@FindBy(xpath = "//nav/ul/li/a[.='Suite']")
	private WebElement suiteLink;
	
	public FitNesseSuiteResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public int getRightTestCount(){
		return getCountFromTestSummaryUsingPattern(RIGHTCOUNT);
	}
	
	public int getWrongTestCount(){
		return getCountFromTestSummaryUsingPattern(WRONGCOUNT);
	}
	public int getIgnoredTestCount(){
		return getCountFromTestSummaryUsingPattern(IGNOREDCOUNT);
	}
	
	public int getExceptionTestCount(){
		return getCountFromTestSummaryUsingPattern(EXCEPTIONCOUNT);
	}
	
	public FitNesseSuiteResultsPage runSuite(){
		suiteLink.click();
		FitNesseSuiteResultsPage suiteResults = PageFactory.initElements(driver, FitNesseSuiteResultsPage.class);
		return suiteResults.waitForSuiteToComplete(10);
	}
	
	protected Pattern getTestCountPattern(){
		return Pattern.compile("Test Pages:\\s+(\\d+)\\s+right,\\s+(\\d+)\\swrong,\\s+(\\d+)\\signored,\\s+(\\d+)\\sexceptions");
	}
	
	public FitNesseSuiteResultsPage waitForSuiteToComplete(Integer seconds){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.textToBePresentInElement(By.id("test-summary"), "Test Pages:"));
		return this;
	}

}
