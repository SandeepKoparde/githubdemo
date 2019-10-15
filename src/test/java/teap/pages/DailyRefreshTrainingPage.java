package teap.pages;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DailyRefreshTrainingPage 
{
	WebDriver driver;

	public DailyRefreshTrainingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void rate_script() throws InterruptedException
	{
		List<WebElement> marks = driver.findElements(By.xpath("//input[@value='2']"));
		ListIterator<WebElement> marks_iterator = marks.listIterator();
		
		while(marks_iterator.hasNext())
		{
			marks_iterator.next().click();
			Thread.sleep(3000);
		}
	}
	
	public void rating()
	{
		driver.findElement(By.name("ratingBtn")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pending()
	{
		driver.findElement(By.name("pendingBtn")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void next()
	{
		driver.findElement(By.name("nextBtn")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void handle_alert()
	{	
		driver.findElement(By.name("modalBtn1")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
