
package stepDefinition;
 
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.CucumberBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
 
public class Hooks {
 
	 WebDriver driver;

	 Properties p;

	@Before
    public void setup() throws IOException
    {
		driver=CucumberBaseClass.initilizeBrowser();
    	p=CucumberBaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
	}

    @After
    public void tearDown(Scenario scenario) 
    {
       driver.quit();
    }
 
    @AfterStep
    public void addScreenshot(Scenario scenario) 
    {
    	TakesScreenshot ts=(TakesScreenshot) driver;
 //   	 this is for cucumber junit report
        if(scenario.isFailed()) 
        {
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
        else
        {
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
    }
}
