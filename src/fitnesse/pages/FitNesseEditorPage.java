package fitnesse.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FitNesseEditorPage  {

	protected WebDriver driver;
	
	@FindBy(xpath = "//header/h1/a")
	private WebElement pageLink;
	
	@FindBy(id = "helptext")
	private WebElement helptext;
	
	@FindBy(id = "pageContent")
	private WebElement pageContent;
	
	@FindBy(name = "save")
	private WebElement saveButton;
	
	@FindBy(xpath = "//button")
	private WebElement cancelButton;
	
	
	@FindBy(xpath = "//button[value='Format']")
	private WebElement formatButton;

	@FindBy(id="suites")
	private WebElement tagsField;

	@FindBy(id="templateMap")
	private WebElement templatesList;
	
	@FindBy(xpath="//button[value='Insert Template']")
	private WebElement insertTemplateButton;
	
	@FindBy(id="editor-wysiwyg-1")
	private WebElement wysiwygRadio;
	
	@FindBy(id="editor-textarea-1")
	private WebElement plainTextRadio;
	
	public FitNesseEditorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setHelpText(String text){
		helptext.sendKeys(text);
	}
	
	public String getHelpText(){
		return helptext.getText();
	}
	
	public void setPageContent(String newContent){
		pageContent.clear();
		pageContent.sendKeys(newContent);
	}
	
	public String getPageContent(){
		return pageContent.getText();
	}
	
	public FitNessePage savePage(){
		saveButton.click();
		
		return PageFactory.initElements(driver, FitNessePage.class);
	}
	
	public FitNessePage clickCancel(){
		cancelButton.click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}

	public void formatTables(){
		formatButton.click();
	}
	
	public FitNesseWysiwigEditorPage useWysiwygEditor(){
		wysiwygRadio.click();
		return PageFactory.initElements(driver, FitNesseWysiwigEditorPage.class);
	}
	
	public FitNesseEditorPage usePlainTextEditor(){
		plainTextRadio.click();
		return PageFactory.initElements(driver, FitNesseEditorPage.class);
	}
	

	public void setTags(String tags){
		tagsField.sendKeys(tags);
	}
	
	public String getTags(){
		return tagsField.getText();
	}
	
	public void insertTemplate(String templateName){
		Select select = new Select(templatesList);
		select.selectByVisibleText(templateName);
		insertTemplateButton.click();
	}
	
	public boolean isTemplateInTemplateList(String templateName){
		boolean found = false;
		List<WebElement> allOptions = templatesList.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
		    if (option.getText().equals(templateName)) return true;
		}
		return found;

	}

	public void addPageContent(String string) {
		
		 ((JavascriptExecutor) driver).executeScript("positionScript = function(el){if (typeof el.selectionStart == \"number\") {" +
        "el.selectionStart = el.selectionEnd = el.value.length;" +
    	"} else if (typeof el.createTextRange != \"undefined\") {"+
        "el.focus();" +
        "var range = el.createTextRange();" +
        " range.collapse(false);" +
        "range.select();}}; return positionScript(arguments[0]); ", pageContent);
		pageContent.sendKeys(Keys.END,Keys.ENTER);
		pageContent.sendKeys(string, Keys.ENTER);
		
	}
	
}
