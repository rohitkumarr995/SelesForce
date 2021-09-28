package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSalesforces {
	public static WebDriver driver;
	public static Properties prop; 
	
	public static WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		String path = "D:\\Selenium Test Cases\\Salesforce\\src\\main\\java\\Resources\\base.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(prop.getProperty("browser"));
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_v93\\chromedriver.exe");
			
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless")) {
				
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			

		}
		driver.get(prop.getProperty("url"));
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testMethodName, WebDriver driver) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String desfile = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".jpg";
		FileUtils.copyFile(src, new File(desfile));
		return desfile;
	}

}
