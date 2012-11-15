package fitnesse.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class FitNesseResultsPage extends FitNessePage {

	protected static int RIGHTCOUNT = 1;
	protected static int WRONGCOUNT = 2;
	protected static int IGNOREDCOUNT = 3;
	protected static int EXCEPTIONCOUNT = 4;
	
	@FindBy(id = "test-summary")
	private WebElement testSummary;
	
	@FindBy(id = "test-action")
	private WebElement testActionButton;

	public FitNesseResultsPage(WebDriver driver) {
		super(driver);
	}

	public String getTestActionText() {
		return testActionButton.getText();
	}

	public String getAssertionCounts() {
		return testSummary.getText();
	}
	
	protected Pattern getTestCountPattern(){
		return null;
	}

	protected Integer getCountFromTestSummaryUsingPattern(int position) {
		Matcher matcher = getTestCountPattern().matcher(getAssertionCounts());
		matcher.find();
		return Integer.parseInt(matcher.group(position));
	}

}