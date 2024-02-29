package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageLearningPage extends BasePage
{
	JavascriptExecutor js;
	public LanguageLearningPage(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	// Locators
	@FindBy(xpath="//div[@class='rc-SearchResultsHeader']//span[1]") WebElement learningLanguage;
	
	@FindBy(xpath = "(//div[@data-testid='search-filter-group-Language']//button)[3]") WebElement showMoreLanguage;
	@FindBy(xpath="//div[@id='checkbox-group']/div/label/div") List<WebElement> languages;

	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']") WebElement level;
	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']/div/div//div/span") List<WebElement> levelList;
	
	@FindBy(xpath = "(//span[@class='cds-button-label' and text()='Close'])[2]")WebElement close;
	
	public String lang_learning()
	{
		String searchResultLang = learningLanguage.getText();
		return searchResultLang;
	}
	
	public int no_of_languages()
	{
		showMoreLanguage.click();
		return languages.size();
		
	}
	public List<String> lang_list()
	{
		List<String> list = new ArrayList<String>();
		for(WebElement lang: languages)
		{
			list.add(lang.getText());
		}
		close.click();
		return list;	
	}
	
	public void display_language(List<String> langList)
	{
		for(String lang: langList)
			System.out.println(lang);
	}
	
	public String level_info()
	{
		return level.getText();
	}
	
	public List<String> level_list()
	{
		List<String> list = new ArrayList<String>();
		for(WebElement lev: levelList)
		{
			list.add(lev.getText());
		}
		return list;
	}
	
	public void display_levels(List<String> levels)
	{
		for(String lev : levels)
			System.out.println(lev);
	}

}
