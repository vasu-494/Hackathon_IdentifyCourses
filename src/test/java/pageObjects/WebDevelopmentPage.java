package pageObjects;


import java.util.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WebDevelopmentPage extends BasePage 
{
	JavascriptExecutor js;
	public WebDevelopmentPage(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	//Locators
	@FindBy(xpath = "//div[@class='rc-SearchResultsHeader']//span[1]")WebElement webDevelopment;
	
	@FindBy(xpath = "//span[@id='cds-react-aria-53-label-text' or text()='English']")WebElement english;
	@FindBy(xpath = "//span[@id='cds-react-aria-81-label-text' or text()='Beginner']")WebElement beginner;
	
	//course 1 details
	@FindBy(xpath = "(//div[@class='cds-CommonCard-clickArea'])[1]")WebElement course1;
	@FindBy(xpath = "(//div[@class='cds-CommonCard-metadata']/p[starts-with(text(),'Beginner' )])[1]") WebElement validate1;
	
	
	
	//course2 details
	@FindBy(xpath = "(//div[@class='cds-CommonCard-clickArea'])[2]")WebElement course2;
	@FindBy(xpath = "(//div[@class='cds-CommonCard-metadata']/p[starts-with(text(),'Beginner' )])[2]") WebElement validate2;
	
	
	
	//Actions
	//search result text
	public String no_of_courses()
	{
		String searchResult = webDevelopment.getText();
		return searchResult;
		
	}
	
	// filters for courses
	public String select_english()
	{
		english.click();
		return english.getText();
	}
	
	public String select_beginner()
	{
		beginner.click();
		return beginner.getText();
	}
	
	
	public void click_course1()
	{
		course1.click();
		
	}
	public void click_course2()
	{
		course2.click();
	}
		
	public void switch_driver_to_course()
	{
		Set<String> windowIDs = driver.getWindowHandles();
		List<String> winIDs = new ArrayList(windowIDs);
		
		String parentID = winIDs.get(0);
		String childID = winIDs.get(1);
		driver.switchTo().window(childID);
	}
	
	public WebElement course1_startswith()
	{
		return validate1;
	}
	public WebElement course2_startswith()
	{
		return validate2;
	}

}
