package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNesseDeletePage extends FitNessePage {

	@FindBy(tagName = "button")
	private WebElement noButton;
	
	@FindBy(xpath = "//input")
	private WebElement yesButton;
	
	public FitNesseDeletePage(WebDriver driver) {
		super(driver);
	}
	
	public FitNessePage clickYes(){
		yesButton.click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}
	
	public FitNessePage clickNo(){
		noButton.click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}

}
