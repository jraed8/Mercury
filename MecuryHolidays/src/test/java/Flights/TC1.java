package Flights;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import resources.Base;

public class TC1 extends Base {
	
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	

}
