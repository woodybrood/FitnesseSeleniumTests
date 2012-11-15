package fitnesse.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNessePage  {

	protected WebDriver driver;
	
	@FindBy(xpath = "//nav/ul/li/a[.='Tools']")
	private WebElement toolsMenu;
	
	@FindBy(xpath = "//nav/ul/li/a[.='Edit']")
	private WebElement editLink;
	
	@FindBy(id = "add")
	private WebElement addMenu;
	
	@FindBy(xpath = "//header/h1")
	private WebElement name;
	
	@FindBy(xpath = "//header/ul")
	private WebElement breadCrumbs;
	
	@FindBy(xpath = "//nav/ul/li/ul/li/a[.='Properties']")
	private WebElement propertiesLink;
	
	@FindBy(xpath = "//nav/ul/li/ul/li/a[.='Delete']")
	private WebElement deletePageLink;
	
	@FindBy(xpath = "//nav/ul/li/ul/li/a[.='Static page']")
	private WebElement newStaticPageLink;
	
	@FindBy(xpath = "//nav/ul/li/ul/li/a[.='Test page']")
	private WebElement newTestPageLink;
	
	@FindBy(xpath = "//nav/ul/li/ul/li/a[.='Suite page']")
	private WebElement newSuitePageLink;
	
	@FindBy(tagName="article")
	private WebElement articleBody;
	
	
	
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
	
	public FitNesseNewPage clickAddTestPage(){
		showAddMenu();
		newTestPageLink.click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNesseNewPage clickAddStaticPage(){
		showAddMenu();
		newStaticPageLink.click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNesseNewPage clickAddSuitePage(){
		showAddMenu();
		newSuitePageLink.click();
		return PageFactory.initElements(driver, FitNesseNewPage.class);
	}
	
	public FitNessePropertiesPage clickPropertiesLink(){
		showToolsMenu();
		propertiesLink.click();
		return PageFactory.initElements(driver, FitNessePropertiesPage.class);
	}

	
	private void showToolsMenu(){
		((JavascriptExecutor) driver).executeScript("$('li#tools').find('ul').css('display', 'block')");
	}
	
	private void showAddMenu(){
		((JavascriptExecutor) driver).executeScript("$('li#add').find('ul').css('display', 'block')");
	}

	public String getArticleContents() {
		return articleBody.getText(); 
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public FitNesseDeletePage deleteCurrentPage(){
		showToolsMenu();
		deletePageLink.click();
		return PageFactory.initElements(driver, FitNesseDeletePage.class);
	}
	
}
