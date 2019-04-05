package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="RegionID")
	WebElement destination;
	
	@FindBy (id="AirportID")
	WebElement from;
	
	@FindBy(id="HotelID")
	WebElement hotel;
	
	@FindBy(id="departureDate")
	WebElement depart;
	
	
	
	
	public WebElement obj_destination()
	{
		return destination;
	}
	
	public WebElement obj_from()
	{
		return from;
	}
	
	public WebElement obj_hotel()
	{
		return hotel;
	}
	
	public WebElement obj_depart()
	{
		return depart;
	}
	
}
