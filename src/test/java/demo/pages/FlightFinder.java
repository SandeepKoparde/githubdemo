package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightFinder {
	WebDriver driver;
	
	public FlightFinder(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
	public String getSelectedTripType()
	{
		if (driver.findElement(By.xpath("//input[@value='roundtrip']")).isSelected())
		{
			return "Round Trip";
		}
		else
		{
			return "One Way";
		}
	}
}
