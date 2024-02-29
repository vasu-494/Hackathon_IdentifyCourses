package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondCoursePage extends BasePage
{
	JavascriptExecutor js;
	public SecondCoursePage(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	//Locators
	//course 2 details
	@FindBy(xpath = "(//div[@class='cds-ProductCard-header']//div[2])[2]")WebElement course2Title;
	@FindBy(xpath = "(//div[@class='cds-CommonCard-ratings']//p[1])[2]")WebElement course2Rating;
	@FindBy(xpath = "(//div[contains(text(),'months') or contains(text(),'Approx') or contains(text(),'week') or contains(text(),'hours')])")WebElement course2Duration;
	
	//Actions
	public List<String> course2_details()
	{	
		List<String> course2_Details = new ArrayList<String>();
		String title = course2Title.getText();
		String rating = course2Rating.getText();
		course2_Details.add(title);
		course2_Details.add(rating);
		return course2_Details;
		
	}
	
	public String course2_duration()
	{
		String duration2 = course2Duration.getText();
		return duration2;
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
