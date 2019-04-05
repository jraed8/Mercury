package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	
	{
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\marius\\MercuryHolidays\\src\\main\\java\\Resources\\DataDriver.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
			 driver =new ChromeDriver();	
		}
		else if(browserName.equals("Firefox"))
		{
			/*
			 * System.setProperty("webdriver.chrome.driver", "C://work//firefox.exe");
			 * driver= new Firefoxdriver();
			 */
		}
		return driver;
	}
}
