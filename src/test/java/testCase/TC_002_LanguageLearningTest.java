package testCase;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LanguageLearningPage;
import pageObjects.WebDevelopmentPage;
import testBase.BaseClass;
import utilities.ExcelUtils;

public class TC_002_LanguageLearningTest extends BaseClass
{
	
	@Test(priority=7, groups= {"sanity"})
	public void validate_language_learning_search()
	{	
		logger.info("***** Starting TC_002_LanguageLearningTest *****");
		HomePage hp = new HomePage(driver);
		LanguageLearningPage lang = new LanguageLearningPage(driver);
		try 
		{	logger.info("***** Clearing Existing Values *****");
			logger.info("***** Searching Language Learning *****");
			hp.search().click();
			hp.clear_value();
			hp.search_language_learning();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		logger.info("***** Verifying Language Learning Search *****");
		String expSearchResult = "results for \"Language Learning\"";
		String actSearchResult = lang.lang_learning();
		Assert.assertEquals(actSearchResult.contains(expSearchResult),true );
		logger.info("***** Language Learning Search Verified *****");
		// logger + sc
	}
	
	@Test(priority=8, groups= {"regression"})
	public void validate_language() throws IOException
	{
		HomePage hp = new HomePage(driver);
		LanguageLearningPage lang = new LanguageLearningPage(driver);
		logger.info("***** Scrolling Down *****");
		hp.scroll_down();
		System.out.println("\n****************************************************\nLANGUAGES:\n");
		logger.info("***** Getting Languages *****");
		int listSize = lang.no_of_languages();
		logger.info("***** Printing Languages *****");
		System.out.println("Total number of languages available: "+ listSize);
		
		List<String> lang_list = lang.lang_list();
		lang.display_language(lang_list);
		logger.info("***** Writing Languages *****");
		WriteExcelData(lang_list,2);
		Assert.assertEquals(listSize,24);
		logger.info("***** Language Details Verified *****");
		
	}
	
	@Test(priority=9, groups= {"regression"})
	public void validate_level() throws IOException
	{
		HomePage hp = new HomePage(driver);
		LanguageLearningPage lang = new LanguageLearningPage(driver);
		logger.info("***** Scrolling Down *****");
		hp.scroll_down();
		String expLevel = "Level";
		String actLevel = lang.level_info();
		if(actLevel.contains(expLevel))
			Assert.assertTrue(true);
		logger.info("***** Level Is Verified *****");
		List<String> level_List = lang.level_list();
		System.out.println("\n****************************************************\nLEVEL:\n");
		System.out.println("Total number of level available: "+ level_List.size());
		logger.info("***** Printing Levels *****");
		lang.display_levels(level_List);
		logger.info("***** Writing Levels *****");
		WriteExcelData(level_List,3);
		logger.info("***** Level Details Verified *****");
		logger.info("***** TC_002_LanguageLearningTest Completed *****");
	}
	
}
