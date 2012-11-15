package fitnesse.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fitnesse.pages.FitNesseDeletePage;
import fitnesse.pages.FitNesseNewPage;
import fitnesse.pages.FitNessePage;
import fitnesse.pages.FitNessePropertiesPage;

public class PagePropertiesTests extends AbbstractFitNesseTestCase {

	
	private FitNessePage page = null;
	private static String SAMPLE_CONTENT_MARKUP = "!1 Test Page";
	
	@Before
	public void setUp(){
		driver.navigate().to(fitnesseServer + "/FrontPage");
		page = PageFactory.initElements(driver, FitNessePage.class);
		FitNesseNewPage newPage = page.clickAddTestPage();
		newPage.setPageName("NewWikiTest");
		newPage.setHelpText("This is a sample test");
		newPage.setPageContent(SAMPLE_CONTENT_MARKUP);
		page = newPage.savePage();
	}
	
	@Test
	public void canChangeTestPageToStaticPage(){
		FitNessePropertiesPage propertiesPage = page.clickPropertiesLink();
		propertiesPage.setPageTypeToStatic();
		page = propertiesPage.saveProperties();
		propertiesPage = page.clickPropertiesLink();
		assertTrue("Page is now static", propertiesPage.isStaticPage());
		
	}
	
	@Test
	public void canSetTestToBeSkipped(){
		FitNessePropertiesPage propertiesPage = page.clickPropertiesLink();
		propertiesPage.setSkipTest();
		page = propertiesPage.saveProperties();
		propertiesPage = page.clickPropertiesLink();
		assertTrue("Page is now static", propertiesPage.isSkipTestSet());
	}
	
	
	@After
	public void tearDown(){
		try {
			page = page.navigateTo("http://localhost:8080/FrontPage.NewWikiTest");
			FitNesseDeletePage deletePage = page.deleteCurrentPage();
			deletePage.clickYes();
		}
		catch (Exception e){
			//throw away the exception.
		}
	}
}
