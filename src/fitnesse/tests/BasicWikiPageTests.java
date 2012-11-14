package fitnesse.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fitnesse.pages.FitNesseEditorPage;
import fitnesse.pages.FitNesseNewPage;
import fitnesse.pages.FitNessePage;
import fitnesse.pages.FitNessePropertiesPage;

public class BasicWikiPageTests extends AbbstractFitNesseTestCase {

	private FitNessePage page = null;
	
	@Before
	public void setUp(){
		driver.navigate().to("http://localhost:8080/FrontPage");
		page = PageFactory.initElements(driver, FitNessePage.class);
	}
	
	@Test
	public void editButtonGoesToEditPage() {
		FitNesseEditorPage editPage = page.edit();
		page = editPage.clickCancel();
		assertEquals("Back to FrontPage", "http://localhost:8080/FrontPage", driver.getCurrentUrl());
	}
	
	@Test
	public void propertiesMenuOptionGoesToPropertiesPage(){
		FitNessePropertiesPage propertiesPage = page.clickPropertiesLink();
		assertTrue("On properties page by URL", propertiesPage.isPropertiesPage());
	}
	
	@Test
	public void addTestPageGoesToNewPageEditor(){
		FitNesseNewPage newPage = page.clickAddTestPage();
		assertTrue("On an new test page", newPage.isNewTestPageEditor());
	}
	
	@Test 
	public void addSuitePageGoesToNewSuitePageEditor(){
		FitNesseNewPage newPage = page.clickAddSuitePage();
		assertTrue("On a new suite page", newPage.isNewSuitePageEditor());
	}
	
	@Test 
	public void addStaticPageGoesToNewStaticPageEditor(){
		FitNesseNewPage newPage = page.clickAddStaticPage();
		assertTrue("On a new static page", newPage.isNewStaticPageEditor());
	}
	
	@Test
	public void editFrontPageAndAddWikiWord(){
		FitNesseEditorPage editPage = page.edit();
		editPage.addPageContent("NewWikiWord");
		page = editPage.savePage();
		assertTrue("Page contents include new wik word", page.getArticleContents().contains("NewWikiWord"));
	}

	
}
