package greenKart_TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import greenKart_Pages.gk_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class gk_baseclass 
{
	private WebDriver d;
	public String url;
	public gk_HomePage hp;
	Properties properties_File;
	//String destinationfile;
	
	@BeforeClass(alwaysRun=true)
	public void initalize_Browser() throws IOException
	{
		//destinationfile = System.getProperty("user.dir") + "\\Screenshots\\" + getCurrentDate_Time();
		String config_File_Path = System.getProperty("user.dir")+"//src/test//java//resources_Utility//config.properties";
		FileInputStream fs = new FileInputStream(config_File_Path);
		properties_File = new Properties();
		properties_File.load(fs);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void initalizeBrowser() throws IOException
	{
		if(properties_File.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--headless");
			d = new ChromeDriver(options);			
		}
		else if(properties_File.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			//options.addArguments("--headless");
			d = new FirefoxDriver(options);
		}
		d.manage().window().maximize();
		d.get(properties_File.getProperty("URL"));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		hp = new gk_HomePage(d);
		
	}
	
	public String getCurrentDate_Time()
	{
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddmmyy-hhmmss");
		String current_Date_Time = ldt.format(dtf);
		return current_Date_Time;
	}

	
	public void TakeScreenshot(String test_Case_Name) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)d);
		File sc = ts.getScreenshotAs(OutputType.FILE);
		//destinationfile = destinationfile + "\\" + test_Case_Name + ".png";
		File destination = new File(System.getProperty("user.dir") + "\\Screenshots\\"+System.currentTimeMillis()+test_Case_Name+ ".png");
		FileUtils.copyFile(sc, destination);
				
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE== result.getStatus())
		{		
			//System.out.println("Fail");
			TakeScreenshot(result.getMethod().getMethodName());
		}
		d.quit();
	}
}
