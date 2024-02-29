package stepDefinition;

import java.io.IOException;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstCoursePage;
import pageObjects.HomePage;
import pageObjects.SecondCoursePage;
import pageObjects.WebDevelopmentPage;

public class WebDevelopmentCoursesStep 
{
	HomePage hp;
	WebDevelopmentPage wd;
	FirstCoursePage fc;
	SecondCoursePage sc;
	
	@Given("User navigates to Coursera Home Page")
	public void user_navigates_to_coursera_home_page() 
	{
		CucumberBaseClass.getLogger().info("***** Starting Web Development Courses Step ******");
		
		hp = new HomePage(CucumberBaseClass.getDriver());
		wd = new WebDevelopmentPage(CucumberBaseClass.getDriver());
		fc = new FirstCoursePage(CucumberBaseClass.getDriver());
		sc = new SecondCoursePage(CucumberBaseClass.getDriver());
	}

	@When("the user clicks on the search bar")
	public void the_user_clicks_on_the_search_bar() throws IOException 
	{
		CucumberBaseClass.getLogger().info("***** Launched Browser Successfully ******");
		CucumberBaseClass.getLogger().info("***** Navigated to Coursera Home Page Successfully ******");
		CucumberBaseClass.getLogger().info("***** Searching Web Development Courses ******");
		hp.search_web_development_courses();
	}

	@When("the user selects the language and level")
	public void the_user_selects_the_language_and_level() 
	{
		CucumberBaseClass.getLogger().info("***** Scrolling Down ******");
		hp.scroll_down();
		CucumberBaseClass.getLogger().info("***** Selecting Language ******");
		wd.select_english();
		CucumberBaseClass.getLogger().info("***** Scrolling Down ******");
		hp.scroll_down();
		CucumberBaseClass.getLogger().info("***** Selecting Level ******");
		wd.select_beginner();
		CucumberBaseClass.getLogger().info("***** Scrolling Up ******");
		hp.scroll_up();
		
	}

	@Then("verify details of the first course")
	public void verify_details_of_the_first_course() {
	    hp.scroll_up();
	    CucumberBaseClass.getLogger().info("***** Validating First Course Details ******");
	    fc.course1_details();
	    wd.click_course1();
	    wd.switch_driver_to_course();
	    fc.switch_to_default();
	    CucumberBaseClass.getLogger().info("***** First Course Details Verified ******");
	}

	@Then("verify details of the second course")
	public void verify_details_of_the_second_course() {
		CucumberBaseClass.getLogger().info("***** Validating Second Course Details ******");
		sc.course2_details();
		wd.click_course2();
		wd.switch_driver_to_course();
	    sc.course2_duration();
	    sc.switch_to_default();
	    CucumberBaseClass.getLogger().info("***** Second Course Details Verified ******");
	    CucumberBaseClass.getLogger().info("***** Web Development Courses Step Completed ******");
	}

}
