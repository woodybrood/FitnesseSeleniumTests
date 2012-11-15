package fitnesse.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fitnesse.pages.FitNesseSuitePage;
import fitnesse.pages.FitNesseSuiteResultsPage;
import fitnesse.pages.FitNesseTestPage;
import fitnesse.pages.FitNesseTestResultsPage;

public class ExecutionTests extends AbbstractFitNesseTestCase {
	
	
	@Test
	public void suiteButtonRunsSuiteAndSuiteExecutionCompletes(){
		driver.navigate().to(fitnesseServer + "/FitNesse.SuiteAcceptanceTests.SuiteSlimTests.LibrarySuite");
		FitNesseSuitePage suitePage = PageFactory.initElements(driver, FitNesseSuitePage.class);
		FitNesseSuiteResultsPage results = suitePage.runSuite();
		assertEquals(4, results.getRightTestCount());
		assertEquals(0, results.getWrongTestCount());
		assertEquals(0, results.getIgnoredTestCount());
		assertEquals(0, results.getExceptionTestCount());
	}
	
	@Test
	public void testButtonRunsTestAndTestExecutionCompletes(){
		driver.navigate().to(fitnesseServer + "/FitNesse.SuiteAcceptanceTests.SuiteSlimTests.LibrarySuite.LastLibraryPreceedsEarlierLibraryTest");
		FitNesseTestPage testPage = PageFactory.initElements(driver, FitNesseTestPage.class);
		FitNesseTestResultsPage results = testPage.runTest();
		assertEquals(2, results.getRightCount());
		assertEquals(0, results.getWrongCount());
		assertEquals(0, results.getIgnoredCount());
		assertEquals(0, results.getExceptionCount());
	}
	
	

}
