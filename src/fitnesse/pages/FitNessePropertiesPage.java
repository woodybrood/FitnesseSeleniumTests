package fitnesse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitNessePropertiesPage {
	
	@FindBy(id="Static")
	private WebElement staticPageType;
	
	@FindBy(id="Test")
	private WebElement testPageType;
	
	@FindBy(id="Suite")
	private WebElement suitePageType;
	
	@FindBy(id="Prune")
	private WebElement skipTest;
	
	@FindBy(id="Suites")
	private WebElement tagsField;
	
	@FindBy(id = "HelpText")
	private WebElement helptext;

}
