package pageObjects;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	JavascriptExecutor js;
	
	Actions act = new Actions(driver);
	public Properties p = new Properties();  
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	//Locators
	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")WebElement searchBar; 
	@FindBy(xpath = "//form[@class='search-form']//button[2]/div")WebElement searchIcon;
	
	@FindBy(xpath = "//a//img[@class='rc-CourseraLogo']") WebElement coursera;//verify page
	
	@FindBy(linkText = "For Enterprise") WebElement forEnterprise;
	
	//Actions
	// home page
	public void coursera()
	{
		coursera.click();
	}
	// 
	public boolean home_page()
	{	
		
		boolean statusHP = coursera.isDisplayed();
		return statusHP;
	}
	
	//searching courses
	public WebElement search()
	{
		return searchBar;
	}
	
	public void search_web_development_courses() throws IOException
	{
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p.load(file);
		searchBar.sendKeys(p.getProperty("course"));
		searchIcon.click();
	}
	
	public void search_language_learning() throws IOException
	{
	
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p.load(file);
		searchBar.sendKeys(p.getProperty("langLearn"));
		searchIcon.click();
		
	}
	
	//clear search
	public void clear_value()
	{
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		act.sendKeys(Keys.DELETE);
	}
	
	//scrolls
	public void scroll_down()
	{
		js.executeScript("window.scrollBy(0,200)");
	}
	public void scroll_up()
	{
		js.executeScript("window.scrollBy(0,-300)");
	}
	
	
	public void scroll_page_height()
	{
		js.executeScript("window.scrollBy(0,5000)","");
	}
	
	// navigate to business page
	public void click_for_enterprie()
	{
		js.executeScript("arguments[0].click();",forEnterprise);
	}
	
}
