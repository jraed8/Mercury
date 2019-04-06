package Flights;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import resources.Base;

public class TC1 extends Base {
	
	@BeforeMethod
	public void openBrowser() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	@Test (dataProvider = "getData")
	public void BHXtoDubai(String a, String b, String c, String d, String e, String f  ) throws InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		
		Select destination = new Select(lp.obj_destination());
		destination.selectByVisibleText(a);
		
		Select from = new Select(lp.obj_from());
		from.selectByVisibleText(b);
		
		lp.obj_depart().click();
		String month = lp.obj_calendarMonth().getText();
		String expMonth = c;
		
		while (!month.equalsIgnoreCase(expMonth))
		{
			lp.obj_clickNextMonth().click();
			month = lp.obj_calendarMonth().getText();

		}
		int countDays = lp.obj_calendarDay().size();
		
		for (int i = 0;i<countDays;i++)
		{
			String dayText = lp.obj_calendarDay().get(i).getText();
			if (dayText.equalsIgnoreCase(d))
			{
				lp.obj_calendarDay().get(i).click();
			
				Thread.sleep(3000);
				break;
			}
		}
		
		 month = lp.obj_calendarMonth().getText();
		 expMonth = e;
		
		while (!month.equalsIgnoreCase(expMonth))
		{
			lp.obj_clickNextMonth().click();
			month = lp.obj_calendarMonth().getText();

		}
		 countDays = lp.obj_calendarDay().size();
		
		for (int i = 0;i<countDays;i++)
		{
			String dayText = lp.obj_calendarDay().get(i).getText();
			if (dayText.equalsIgnoreCase(f))
			{
				lp.obj_calendarDay().get(i).click();
			
				Thread.sleep(3000);
				break;
			}
		}
		
		//lp.obj_searchButton().click();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][6];
		
		data[0][0] = "Dubai/Emirates";
		data[0][1] = "Birmingham - (BHX)";
		data[0][2] = "June 2019";
		data[0][3] = "15";
		data[0][4] = "January 2020";
		data[0][5] = "11";
		
		data[1][0] = "Thailand";
		data[1][1] = "Edinburgh - (EDI)";
		data[1][2] = "July 2019";
		data[1][3] = "3";
		data[1][4] = "January 2020";
		data[1][5] = "11";
		
		
		
		return data;
	}
	
	

}
