package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
 
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilities.ExcelUtils;
 
public class BaseClass 
{
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;

	
	@BeforeTest
	@Parameters({"os","browser"})
	public void setUp(String os,String browser) throws IOException 
	{
		//Loading property file
	
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//loading log4j file
		logger= LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//For Selecting OS:
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os...");
				return;
			}
			//For Selecting Browser:
			switch(browser.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("edge"); break;
			default:System.out.println("No Matched Browser");
			return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
			switch(browser.toLowerCase()) {
			case "chrome" :driver=new ChromeDriver(); break;
			case "edge" :driver=new EdgeDriver(); break;
			default: System.out.println("No Matching Browser");
			return;
			}
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	public void WriteExcelData(List<String> list, int column) throws IOException 
	{
		
		int row=0;
		for(String data : list) 
		{
			ExcelUtils.write("Sheet1", row, column, data);
			row++;
		}

	}
	
	public void clear_field(WebElement element)
	{
		element.clear();
	}
//	//@AfterMethod
	public static String captureScreen(String name) 
	{
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}

