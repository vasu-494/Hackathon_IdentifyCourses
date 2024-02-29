package stepDefinition;

import java.io.IOException;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstCoursePage;
import pageObjects.HomePage;
import pageObjects.LanguageLearningPage;
import pageObjects.SecondCoursePage;
import pageObjects.WebDevelopmentPage;

public class LanguageLearningStep 
{
	HomePage hp;
	LanguageLearningPage lang;
	
	
	@Given("user navigates to the coursera home page")
	public void user_navigates_to_the_coursera_home_page() throws IOException 
	{
		CucumberBaseClass.getLogger().info("***** Starting Language Learning Step ******");
		hp = new HomePage(CucumberBaseClass.getDriver());
		lang = new LanguageLearningPage(CucumberBaseClass.getDriver());
		hp.search().click();
		hp.clear_value();
		hp.search_language_learning();
		 
	}

	@When("the user clicks on languages show more")
	public void the_user_clicks_on_languages_show_more() {
		CucumberBaseClass.getLogger().info("***** Scrolling Down ******");
		hp.scroll_down();
		CucumberBaseClass.getLogger().info("***** Getting Languages ******");
		lang.no_of_languages();
		
		
	    
	}

	@Then("gets the languages count and languages")
	public void gets_the_languages_count_and_languages() {
		CucumberBaseClass.getLogger().info("***** Scrolling Down ******");
		lang.lang_list();
		hp.scroll_down();

	}

	@Then("get the levels count and levels")
	public void get_the_levels_count_and_levels() {
		CucumberBaseClass.getLogger().info("***** Getting Levels ******");
	   lang.level_list();
	   CucumberBaseClass.getLogger().info("***** Language Learning Step Completed ******");
	}



}
