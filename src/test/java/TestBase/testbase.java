package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testbase {
	public WebDriver driver;
	public Logger log;
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//commonvalues.properties");
		p=new Properties();
		p.load(file);
		log=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("runningenv").equalsIgnoreCase("remote"))
		{
						
			DesiredCapabilities cap = new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("Linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("Invalid Platform plese pass the correct platform form running xml file");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default:System.out.println("Inavlid Browser name"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		}
		
			
		if(p.getProperty("runningenv").equalsIgnoreCase("local"))
		{
			EdgeOptions options = new EdgeOptions();
		
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			case "edge": 	driver=new EdgeDriver(options);break;
			default: System.out.println("Please pass the correct browser name!"); return;
			}
		}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL1"));
			driver.manage().window().maximize();
			driver.manage().logs().getAvailableLogTypes();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String generateRandomString()
	{
		String generatedStr = RandomStringUtils.randomAlphabetic(6);
		return generatedStr;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomealphanum()
	{
		String pswdStr = RandomStringUtils.randomAlphabetic(3);
		String pswdnum=RandomStringUtils.randomNumeric(4);
		return (pswdStr+"@"+pswdnum);
	}
	
	/*public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}*/


}
