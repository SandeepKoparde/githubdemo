package teap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuPage 
{
	WebDriver driver;

	public MainMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void rating_for_rater()
	{
		driver.findElement(By.xpath("//button[text()='Rating for Rater']")).click();
	}
	
	public void rating_scheme_management()
	{
		driver.findElement(By.xpath("//button[text()='Rating Scheme Management']")).click();
	}
	
	
}
