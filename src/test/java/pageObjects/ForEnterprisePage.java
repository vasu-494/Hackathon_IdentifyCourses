package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForEnterprisePage extends BasePage
{
	JavascriptExecutor js;
	public ForEnterprisePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	
	// Locators
	@FindBy(xpath = "//a[@href='/business']") WebElement courseraForBusiness;//verify page
	
	@FindBy(linkText = "What We Offer") WebElement products;
	
	
	// Actions
	public boolean coursera_for_business_page()
	{
		boolean statusBP = courseraForBusiness.isDisplayed();
		return statusBP;
	}
	public void click_products()
	{
		products.click();
	}
}
