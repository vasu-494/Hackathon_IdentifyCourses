package pageObjects;
 
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 
 
public class BasePage 
{
	public WebDriver driver;
	BasePage(WebDriver driver)
	{
	
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String randomString()
	{
		String str = RandomStringUtils.randomAlphabetic(10);
		return str;
	}
	
}