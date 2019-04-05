package Flights;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import Resources.Base;

public class Tc1 extends Base{

	@BeforeMethod
	public void openBrowser() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
			driver.close();	
	}
	
}
