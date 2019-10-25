package teap.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PCConfigurationCheck {
	WebDriver driver;
	
	public PCConfigurationCheck(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void select_all_checkboxes()
	{
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
	}
	
	public void recommendation_screen_fitness()
	{
		driver.findElement(By.xpath("//button[text()='Recommendation screen fitness']")).click();
	}

}
