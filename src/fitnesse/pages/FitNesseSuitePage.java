package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNesseSuitePage extends FitNessePage {


	@FindBy(xpath = "//nav/ul/li/a[.='Suite']")
	private WebElement suiteLink;
	
	public FitNesseSuitePage(WebDriver driver) {
		super(driver);
	}
	
	public FitNesseSuiteResultsPage runSuite(){
		suiteLink.click();
		FitNesseSuiteResultsPage suiteResults = PageFactory.initElements(driver, FitNesseSuiteResultsPage.class);
		return suiteResults.waitForSuiteToComplete(10);
	}

}
