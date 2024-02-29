package stepDefinition;

import java.io.IOException;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForCampusPage;
import pageObjects.ForEnterprisePage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.ReadyToTransformForm;
import utilities.DataProviders;

public class ReadyToTransformStep
{
	HomePage hp;
	ForEnterprisePage ep;
	ProductsPage pp;
	ForCampusPage cp;
	ReadyToTransformForm form;
	
	@Given("user navigate to the coursera home page")
	public void user_navigate_to_the_coursera_home_page() throws IOException 
	{
		CucumberBaseClass.getLogger().info("***** Starting Ready To Transform Step ******");
		hp = new HomePage(CucumberBaseClass.getDriver());
		ep = new ForEnterprisePage(CucumberBaseClass.getDriver());
		pp = new ProductsPage(CucumberBaseClass.getDriver());
		cp = new ForCampusPage(CucumberBaseClass.getDriver());
		form = new ReadyToTransformForm(CucumberBaseClass.getDriver());
		CucumberBaseClass.getLogger().info("***** Scrolling to For Enterprise ******");
		hp.scroll_page_height();
		
		 
	}
	@When("user clicks on For Enterprise page")
	public void user_clicks_on_for_enterprise_page() {
		CucumberBaseClass.getLogger().info("***** Navigating to For Enterprise Page ******");
	    hp.click_for_enterprie();
		CucumberBaseClass.getLogger().info("***** Scrolling to Products ******");
	    hp.scroll_page_height();
	    
	}

	@When("user clicks on What We Offer page")
	public void user_clicks_on_what_we_offer_page() {
		CucumberBaseClass.getLogger().info("***** Navigating to Products Page ******");
		ep.click_products();
		CucumberBaseClass.getLogger().info("***** Scrolling to For Campus Page ******");
	    hp.scroll_page_height();
	}

	@When("user clicks on Coursera for Campus")
	public void user_clicks_on_coursera_for_campus() {
		CucumberBaseClass.getLogger().info("***** Navigating to For Campus Page ******");
	    pp.navigate_to_campus();
	}

	@When("scrolls to the form")
	public void scrolls_to_the_form() {
		CucumberBaseClass.getLogger().info("***** Scrolling to Ready To Transform Form ******");
		cp.scroll_to_form();
		CucumberBaseClass.getLogger().info("***** Filling Form Details ******");
	}

	@Then("enters the details in the form")
	public void enters_the_details_in_the_form() throws IOException {
	    form.first_name();
	    form.last_name();
	    String[][] str=DataProviders.getData();
	    
	    form.email(str[1][0]);
	    form.phone_number(str[1][1]);
	    
	    form.institution_type();
	    form.institution_name();
	    form.job_role();
	    form.department();
	    form.description();
	    form.country();
	   
	    form.click_submit_button();
	}

	@Then("captures the error message")
	public void captures_the_error_message() {
		
		//form.click_submit_button();
		CucumberBaseClass.captureScreen("Form");
		CucumberBaseClass.getLogger().info("***** Ready To Transform Step Completed ******");
	}

}
