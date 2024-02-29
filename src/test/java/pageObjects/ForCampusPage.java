package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForCampusPage extends BasePage
{
	JavascriptExecutor js;
	public ForCampusPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	// Locators
	@FindBy(xpath = "//a[@href='/campus']") WebElement courseraForCampus;//verify page
	@FindBy(xpath = "//form[@id='mktoForm_1512']") WebElement scrollToForm;
	
	
	// Actions
	public boolean coursera_campus()
	{
		boolean statusCampus = courseraForCampus.isDisplayed();
		return statusCampus;
	}
	public void scroll_to_form()
	{
		js.executeScript("arguments[0].scrollIntoView();", scrollToForm);
	}

	

}
