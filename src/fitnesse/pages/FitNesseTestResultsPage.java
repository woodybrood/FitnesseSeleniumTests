package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitNesseTestResultsPage extends FitNesseTestPage{
	
	
	@FindBy(id = "test-summary")
	private WebElement testSummary;
	
	@FindBy(id = "test-action")
	private WebElement testActionButton;
	

	public FitNesseTestResultsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getTestActionText(){
		return testActionButton.getText();
	}
	
	
	public String getAssertionCounts(){
		return testSummary.getText();
	}
	

}
