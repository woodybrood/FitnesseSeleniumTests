package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNesseTestPage extends FitNessePage {

	@FindBy(xpath = "//nav/ul/li/a[.='Test']")
	private WebElement testLink;
	
	public FitNesseTestPage(WebDriver driver) {
		super(driver);
	}
	
	public FitNesseTestResultsPage runTest(){
		testLink.click();
		return PageFactory.initElements(driver, FitNesseTestResultsPage.class);
	}
	
	

}
