package fitnesse.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		driver.navigate().to(driver.getCurrentUrl()+ "?properties");
		return PageFactory.initElements(driver, FitNessePropertiesPage.class);
	}

	
	private void hoverOverToolsMenu(){
		Actions builder = new Actions(driver);
		Action hover = builder.moveToElement(addMenu).moveToElement(toolsMenu).build();
		hover.perform();
		
	}
	
	public  void mouseHoverByJavaScript(WebElement targetElement)
    {

        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                            "arguments[0].dispatchEvent(evObj);";
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript(javaScript, targetElement);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
	
	private boolean elementMouseOver(WebElement targetElement)
    {
      
        // driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        try
        {
            builder.moveToElement(targetElement).click().moveToElement(targetElement, 1, 1).build().perform();
            //Thread.sleep(5000);//2 sec is just to for this blog.
        }
        catch (Exception e)
        {
          
            return false;
        }
        return true;
    }
}
