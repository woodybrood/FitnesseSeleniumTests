package fitnesse.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import test.utility.EnvironmentVariableProvider;


import fitnesse.pages.FitNesseDeletePage;
import fitnesse.pages.FitNesseNewPage;
import fitnesse.pages.FitNessePage;

public class NewPageTests extends AbbstractFitNesseTestCase {
	
	private FitNessePage page = null;
	private static String SAMPLE_CONTENT_MARKUP = "!1 Test Page";
	private String fitnesseServer; 
	
	@Before
	public void setUp(){
		fitnesseServer = EnvironmentVariableProvider.getFitnesseServer();
		driver.navigate().to("http://localhost:8080/FrontPage");
		page = PageFactory.initElements(driver, FitNessePage.class);
	}
	
	@Test
	public void userCanCreateNewTestPage(){
		FitNesseNewPage newPage = page.clickAddTestPage();
		newPage.setPageName("NewWikiTest");
		newPage.setHelpText("This is a sample test");
		newPage.setPageContent(SAMPLE_CONTENT_MARKUP);
		page = newPage.savePage();
		page = page.navigateTo(fitnesseServer + "/FrontPage.NewWikiTest");
		assertTrue("Page will contain text", page.getArticleContents().contains("Test Page"));
	}
	
	@Test
	public void userCanCreateNewTestPageAndDeleteIt(){
		FitNesseNewPage newPage = page.clickAddTestPage();
		newPage.setPageName("PageToDelete");
		page = newPage.savePage();
		page = page.navigateTo(fitnesseServer + "/FrontPage.PageToDelete");
		FitNesseDeletePage deletePage  = page.deleteCurrentPage();
		deletePage.clickYes();
		assertEquals("Should be back at FrontPage", "FrontPage", page.getPageTitle());
	}
	
	
	@Test
	public void userCanCreateNewSuitePage(){
		FitNesseNewPage newPage = page.clickAddSuitePage();
		newPage.setPageName("NewSuiteTest");
		newPage.setHelpText("This is a sample suite");
		newPage.setPageContent("!1 Suite Page");
		page = newPage.savePage();
		page = page.navigateTo(fitnesseServer + "/FrontPage.NewSuiteTest");
		assertTrue("Page will contain text", page.getArticleContents().contains("Suite Page"));
	}
	
	@Test
	public void userCanCreateNewStaticPage(){
		FitNesseNewPage newPage = page.clickAddSuitePage();
		newPage.setPageName("NewStaticTest");
		newPage.setHelpText("This is a sample static");
		newPage.setPageContent("!1 Static Page");
		page = newPage.savePage();
		page = page.navigateTo(fitnesseServer + "/FrontPage.NewStaticTest");
		assertTrue("Page will contain text", page.getArticleContents().contains("Static Page"));
	}

	@After
	public void tearDown(){
		try {
			FitNesseDeletePage deletePage = page.deleteCurrentPage();
			deletePage.clickYes();
		}
		catch (Exception e){
			//throw away the exception.
		}
	}
	
	
}
