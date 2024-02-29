package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstCoursePage extends BasePage
{
	JavascriptExecutor js;
	public FirstCoursePage(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	//Locators
	
	//course 1 details
	@FindBy(xpath = "(//div[@class='cds-ProductCard-header']//div[2])[1]")WebElement course1Title;
	@FindBy(xpath = "(//div[@class='cds-CommonCard-ratings']//p[1])[1]")WebElement course1Rating;
	@FindBy(xpath = "(//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[8]")WebElement course1Duration;
	
	//Actions
	public List<String> course1_details()
	{	
		List<String> course1_Details = new ArrayList<String>();
		String title = course1Title.getText();
		String rating = course1Rating.getText();
		course1_Details.add(title);
		course1_Details.add("Rating: "+rating);
		return course1_Details;
		
	}
	
	public String course1_duration()
	{
		String duration1 = course1Duration.getText();
		return duration1;
	}
	
	public void switch_to_default()
	{
		Set<String> windowIDs = driver.getWindowHandles();
		List<String> winIDs = new ArrayList(windowIDs);
		
		String parentID = winIDs.get(0);
		String childID = winIDs.get(1);
		driver.close();
		driver.switchTo().window(parentID);
	}
	
	
}
