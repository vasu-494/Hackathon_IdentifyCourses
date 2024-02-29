package testCase;

import testBase.BaseClass;
//import utilities.DataProviders;
import utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForCampusPage;
import pageObjects.ForEnterprisePage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.ReadyToTransformForm;

public class TC_003_ReadyToTransformTest extends BaseClass
{
	@Test(priority =10, groups= {"sanity","regression"})
	public void verify_coursera_page() throws InterruptedException
	{
		logger.info("***** Starting TC_003_ReadyToTransformTest *****");
		HomePage hp = new HomePage(driver);
		logger.info("***** Navigating To Home Page *****");
		hp.coursera();
		logger.info("***** Verifying Home Page *****");
		Assert.assertEquals(hp.home_page(), true);
		logger.info("***** Home Page Verified *****");
		Thread.sleep(3000);
		logger.info("***** Scrolling To Page Footer *****");
		hp.scroll_page_height();
		logger.info("***** Clicking For Enterprise *****");
		hp.click_for_enterprie();
	}
	
	
	@Test(priority =11, groups= {"sanity","regression"})
	public void verify_enterprise_page() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		ForEnterprisePage ep = new ForEnterprisePage(driver);
		logger.info("***** Verifying For Enterprise Page *****");
		Assert.assertEquals(ep.coursera_for_business_page(), true);
		logger.info("***** For Enterprise Page Verified *****");
		Thread.sleep(3000);
		logger.info("***** Scrolling To Page Footer *****");
		hp.scroll_page_height();
		Thread.sleep(3000);
		logger.info("***** Clicking Products *****");
		ep.click_products();
	}
	@Test(priority =12, groups= {"sanity","regression"})
	public void verify_products() throws InterruptedException
	{
		
		ProductsPage pp = new ProductsPage(driver);
		
		logger.info("***** Verifying Products Page *****");
		Assert.assertEquals(pp.coursera_products(), true);
		logger.info("***** Products Page Verified *****");
		Thread.sleep(3000);
		logger.info("***** Clicking For Campus *****");
		pp.navigate_to_campus();
	}
	@Test(priority = 13, groups= {"sanity","regression"})
	public void validate_campus_page()
	{
		ForCampusPage cp = new ForCampusPage(driver);
		logger.info("***** Verifying For Campus Page *****");
		Assert.assertEquals(cp.coursera_campus(), true);
		logger.info("***** For Campus Page Verified *****");
		logger.info("***** Scrolling To Ready To Transform Form *****");
		cp.scroll_to_form();
		logger.info("***** Filling Ready To Transform Form *****");
	}

	@Test(priority = 14, groups= {"regression"})
	public void validate_first_name()
	{
		
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.first_name(), true);
	}	
	
	@Test(priority = 15, groups= {"regression"})
	public void validate_last_name()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.last_name(), true);
	}	
	
	@Test(priority = 16, groups= {"regression"})
	public void validate_institution_type()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.institution_type(), true);
	}
	
	@Test(priority = 17, groups= {"regression"})
	public void validate_institution_name()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.institution_name(), true);
	}
	
	@Test(priority = 18, groups= {"regression"})
	public void validate_job_role()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.job_role(), true);
	}
	
	@Test(priority = 19, groups= {"regression"})
	public void validate_department() throws InterruptedException
	{
		Thread.sleep(3000);
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.department(), true);
	}
	
	@Test(priority = 20, groups= {"regression"})
	public void validate_description()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.description(), true);
	}
	
	@Test(priority = 21, groups= {"regression"})
	public void validate_country()
	{
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		Assert.assertEquals(form.country(), true);
		try
		{
			if(form.state_field() == true)
			{
				form.select_state();
				Assert.assertTrue(true);
			}
		}
		catch(Exception e)
		{
		
			Assert.assertTrue(true);
		}		
	}
	
	@Test(priority = 22, dataProvider="FormData",dataProviderClass = DataProviders.class, groups= {"regression"})
	public void validate_input(String email,String ph_number,String exp) throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		ReadyToTransformForm form = new ReadyToTransformForm(driver);
		String act="";
		form.email(email);
		form.phone_number(ph_number);
		Thread.sleep(2000);
		try
		{
			logger.info("***** Clicking Submit Button *****");
			form.click_submit_button();
			Thread.sleep(2000);
			if(form.email_msg()== false && form.phone_number_msg()== false)
			{
				act = "valid";
				Assert.assertTrue(true);
				captureScreen("1. Valid mail and number");
				clear_field(form.mail());
				clear_field(form.number());
			}
			
			else if(form.email_msg()== true && form.phone_number_msg()== false)
			{
				act = "invalid";
				Assert.assertEquals(act.equalsIgnoreCase(exp),true);	
				captureScreen("2. Valid mail and invalid number");
				clear_field(form.mail());
				clear_field(form.number());
			}
			else if(form.email_msg()== false && form.phone_number_msg()== true)
			{
				act = "invalid";
				Assert.assertEquals(act.equalsIgnoreCase(exp),true);
				captureScreen("3. Invalid mail and valid number");
				clear_field(form.mail());
				clear_field(form.number());
			}
			else if(form.email_msg()== true && form.phone_number_msg()== true)
			{
				act = "invalid";
				Assert.assertEquals(act.equalsIgnoreCase(exp),true);
				captureScreen("4. Invalid mail and invalid number");
			}
			form.email_msg();
			form.phone_number_msg();
			logger.info("***** TC_003_ReadyToTransformTest Completed *****");
		}
		catch(Exception e) {}
		
	}	
		
		
		
		
		
		
		
	
	
}
