package fitnesse.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitNessePropertiesPage {

	WebDriver driver;

	@FindBy(id = "Static")
	private WebElement staticPageType;

	@FindBy(id = "Test")
	private WebElement testPageType;

	@FindBy(id = "Suite")
	private WebElement suitePageType;

	@FindBy(id = "Prune")
	private WebElement skipTest;

	@FindBy(id = "Suites")
	private WebElement tagsField;

	@FindBy(id = "HelpText")
	private WebElement helptext;

	@FindBy(id = "Edit")
	private WebElement editOption;

	@FindBy(id = "Versions")
	private WebElement versionsOption;

	@FindBy(id = "Properties")
	private WebElement propertiesOption;

	@FindBy(id = "WhereUsed")
	private WebElement whereUsedOption;

	@FindBy(id = "Refactor")
	private WebElement refactorOption;

	@FindBy(id = "RecentChanges")
	private WebElement recentChangesOption;

	@FindBy(id = "Files")
	private WebElement filesOption;

	@FindBy(id = "Search")
	private WebElement searchOption;

	@FindBy(id = "secure-read")
	private WebElement secureReadOption;

	@FindBy(id = "secure-write")
	private WebElement secureWriteOption;

	@FindBy(id = "secure-test")
	private WebElement secureTestOption;

	@FindBy(xpath = "//nav/ul/li/a[.='View']")
	private WebElement viewLink;

	@FindBy(name = "Save")
	private WebElement savePropertiesButton;

	public FitNessePropertiesPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPropertiesPage(){
		return driver.getCurrentUrl().endsWith("?properties");
	}
	
	public void setPageTypeToStatic() {
		setOption(staticPageType);
	}

	public boolean isStaticPage() {
		return staticPageType.isSelected();
	}

	public void setPageTypeToTest() {
		setOption(testPageType);
	}

	public boolean isTestPage() {
		return testPageType.isSelected();
	}

	public void setPageTypeToSuite() {
		setOption(suitePageType);
	}

	public boolean isSuitePage() {
		return suitePageType.isSelected();
	}

	public void setSkipTest() {
		setOption(skipTest);
	}

	public void clearSkipTest() {
		clearOption(skipTest);
	}

	public boolean isSkipTestSet(){
		return skipTest.isSelected();
	}
	
	public void setTags(String tags) {
		tagsField.sendKeys(tags);
	}

	public String getTags(){
		return tagsField.getText();
	}
	
	public void setHelpText(String helpText) {
		helptext.sendKeys(helpText);
	}
	
	public String getHelpText(){
		return helptext.getText();
	}

	public void enablePageEditLink() {
		setOption(editOption);
	}

	public void disablePageEditLink() {
		clearOption(editOption);
	}
	
	public boolean isPageEditLinkSet(){
		return editOption.isSelected();
	}

	public void enableVersionsLink() {
		setOption(versionsOption);
	}

	public void disableVersionsLink() {
		clearOption(versionsOption);
	}

	public boolean isVersionsLinkSet(){
		return versionsOption.isSelected();
	}

	
	public void enablePropertiesLink() {
		setOption(propertiesOption);
	}

	public void disablePropertiesLink() {
		clearOption(propertiesOption);
	}

	public boolean isPropertiesLinkSet(){
		return propertiesOption.isSelected();
	}

	
	public void enableWhereUsedLink() {
		setOption(whereUsedOption);
	}

	public void disableWhereUsedLink() {
		clearOption(whereUsedOption);
	}

	public boolean isWhereUsedLinkSet(){
		return whereUsedOption.isSelected();
	}

	public void enableRefactorLink() {
		setOption(refactorOption);
	}

	public void disableRefactorLink() {
		clearOption(refactorOption);
	}
	
	public boolean isRefactorLinkSet(){
		return refactorOption.isSelected();
	}


	public void enableRecentChangesLink() {
		setOption(recentChangesOption);
	}

	public void disableRecentChangesLink() {
		clearOption(recentChangesOption);
	}
	
	public boolean isRecentChangesLinkSet(){
		return recentChangesOption.isSelected();
	}


	public void enableFilesLink() {
		setOption(filesOption);
	}

	public void disableFilesLink() {
		clearOption(filesOption);
	}

	public boolean isFilesLinkSet(){
		return filesOption.isSelected();
	}

	public void enableSearchLink() {
		setOption(searchOption);
	}

	public void disableSearchLink() {
		clearOption(searchOption);
	}

	public boolean isSearchLinkSet(){
		return searchOption.isSelected();
	}

	public void enableSecureRead() {
		setOption(secureReadOption);
	}

	public void disableSecureRead() {
		clearOption(secureReadOption);
	}
	
	public boolean isSecureReadSet(){
		return secureReadOption.isSelected();
	}

	public void enableSecureWrite() {
		setOption(secureWriteOption);
	}

	public void disableSecureWrite() {
		clearOption(secureWriteOption);
	}

	public boolean isSecureWriteSet(){
		return secureWriteOption.isSelected();
	}

	public void enableSecureTest() {
		setOption(secureTestOption);
	}

	public void disableSecureTest() {
		clearOption(secureTestOption);
	}

	public boolean isSecureTestSet(){
		return secureTestOption.isSelected();
	}

	public FitNessePage viewCurrentPage() {
		viewLink.click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}

	public FitNessePage saveProperties() {
		savePropertiesButton.click();
		return PageFactory.initElements(driver, FitNessePage.class);
	}

	private void setOption(WebElement option) {
		if (!option.isSelected()) {
			option.click();
		}
	}

	private void clearOption(WebElement option) {
		if (option.isSelected()) {
			option.click();
		}
	}

}
