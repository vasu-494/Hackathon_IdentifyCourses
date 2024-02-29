package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReadyToTransformForm extends BasePage
{
	JavascriptExecutor js;
	
	public ReadyToTransformForm(WebDriver driver) 
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	// Locators
	@FindBy(xpath = "//input[@id='FirstName']")WebElement firstName;
	@FindBy(xpath = "//input[@id='LastName']")WebElement lastName;

	@FindBy(xpath = "//select[@id='Institution_Type__c']")WebElement institutionList;
	@FindBy(xpath = "//input[@id='Company']")WebElement institutionName;
	@FindBy(xpath = "//select[@id='Title']")WebElement jobRole;
	@FindBy(css = "#Department")WebElement department;
	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']")WebElement description;
	@FindBy(xpath = "//select[@id='Country']")WebElement country;
	@FindBy(xpath = "//select[@id='State']")WebElement state;

	@FindBy(xpath = "//input[@id='Email']")WebElement mail;
	@FindBy(xpath = "//input[@id='Phone']")WebElement phone;
	@FindBy(xpath = "//div[@id='ValidMsgEmail']")WebElement mailError;
	@FindBy(xpath = "//div[@id='ValidMsgPhone']")WebElement phoneError;
	@FindBy(xpath = "//button[@class='mktoButton' and text()='Submit']")WebElement submitForm;
	// Actions
		
	public boolean first_name()
	{
		firstName.sendKeys(randomString());
		boolean fn = firstName.isEnabled();
		return fn;
	}
	
	public boolean last_name()
	{
		lastName.sendKeys(randomString());
		boolean ln = lastName.isEnabled();
		return ln;
	}
	
	
	public boolean email(String email)
	{
		mail.sendKeys(email);
		boolean mailStatus = mail.isEnabled();
		return mailStatus;
	}
	public WebElement mail()
	{
		return mail;
	}
	public boolean email_msg()
	{
		boolean mailStatus = mailError.isDisplayed();
		System.out.println("\n"+mailError.getText());
		return mailStatus;
	}
	
	
	public boolean phone_number(String ph_number)
	{
		phone.sendKeys(ph_number);
		boolean phoneStatus = phone.isEnabled();
		return phoneStatus;
	}
	
	public boolean phone_number_msg()
	{
		boolean phoneStatus = phoneError.isDisplayed();
		System.out.println("\n"+phoneError.getText());
		return phoneStatus;
		
	}
	public WebElement number()
	{
		return phone;
	}
	
	public boolean institution_type()
	{
		Select s = new Select(institutionList);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
		
	}
	public boolean institution_name()
	{
		institutionName.sendKeys(randomString());
		boolean name = lastName.isEnabled();
		return name;
		
	}
	public boolean job_role()
	{
		Select s = new Select(jobRole);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
	}
	public boolean department()
	{
		Select s = new Select(department);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
	}
	public boolean description()
	{
		Select s = new Select(description);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
	}
	public boolean country()
	{
		Select s = new Select(country);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
	}
	public boolean state_field()
	{
		boolean s = state.isDisplayed();
		return s;
	}
	public boolean select_state()
	{
		Select s = new Select(state);
		List<WebElement>list = s.getOptions();
		int max = list.size();
		Random r = new Random();
		int value = r.nextInt(max); 
		list.get(value).click();
		boolean status = list.get(value).isSelected();
		return status;
	}
	public boolean click_submit_button()
	{
		js.executeScript("arguments[0].click();", submitForm);
		return submitForm.isEnabled();
	}
}
