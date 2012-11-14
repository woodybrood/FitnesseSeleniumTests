package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitNesseNewPage extends FitNesseEditorPage {

	@FindBy(id="pagename")
	private WebElement pagename;
	
	
	
	public FitNesseNewPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void setPageName(String name){
		pagename.sendKeys(name);
	}


	public boolean isNewStaticPageEditor() {
		return driver.getCurrentUrl().endsWith("?new&pageType=Static");
	}


	public boolean isNewTestPageEditor() {
		return driver.getCurrentUrl().endsWith("?new&pageType=Test");
	}

	public boolean isNewSuitePageEditor() {
		return driver.getCurrentUrl().endsWith("?new&pageType=Suite");
	}
}
