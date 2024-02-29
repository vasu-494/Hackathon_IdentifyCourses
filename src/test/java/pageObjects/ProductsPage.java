package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage
{

	JavascriptExecutor js;
	public ProductsPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		
	}

	
	// Locators 
	@FindBy(xpath = "(//h1)[1]") WebElement header;//use isdisplayed to verify page
	@FindBy(xpath = "//h4[text()='* Credit eligibility determined by your institution.']") WebElement scrollToCampus;
	@FindBy(xpath = "(//button/span[text() = 'Learn more'])[2]") WebElement learnMore;
	
	
	
	//Actions
	public boolean coursera_products()
	{
		boolean statusPro = header.isDisplayed();
		return statusPro;
	}
	public void navigate_to_campus()
	{
		// scroll to campus
		js.executeScript("arguments[0].scrollIntoView();", scrollToCampus);
		learnMore.click();
	}
}
