package fitnesse.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNessePage  {

	protected WebDriver driver;
	
	@FindBy(id = "tools")
	private WebElement toolsMenu;
	
	@FindBy(xpath = "//nav/ul/li/a[.='Edit']")
	private WebElement editLink;
	
	@FindBy(id = "add")
	private WebElement addMenu;
	
	@FindBy(xpath = "//header/h1")
	private WebElement name;
	
	@FindBy(xpath = "//header/ul")
	private WebElement breadCrumbs;

	public FitNessePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageName(){
		return name.getText();
	}
	
	public ArrayList<String> getBreadCrumbPath(){
		ArrayList<String> entries = new ArrayList<String>();
		for (WebElement entry: breadCrumbs.findElements(By.tagName("li"))){
			entries.add(entry.getText());
		}
		return entries;
	}
	
	public FitNesseEditorPage edit(){
		editLink.click();
		
		return PageFactory.initElements(driver, FitNesseEditorPage.class);
	}
	
	public FitNessePage navigateTo(String url){
		driver.navigate().to(url);
		return PageFactory.initElements(driver,	 FitNessePage.class);
	}
	
	public FitNessePage clickLink(String linktext){
		driver.findElement(By.linkText(linktext)).click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}
	
	public FitNesseNewPage clickAddTest(){
		addMenu.findElement(By.linkText("Test page")).click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNesseNewPage clickAddStaticPage(){
		addMenu.findElement(By.linkText("Static page")).click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNesseNewPage clickAddSuitePage(){
		addMenu.findElement(By.linkText("Suite page")).click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNessePropertiesPage clickPropertiesLink(){
		toolsMenu.findElement(By.linkText("Properties")).click();
		return PageFactory.initElements(driver, FitNessePropertiesPage.class);
	}

}
