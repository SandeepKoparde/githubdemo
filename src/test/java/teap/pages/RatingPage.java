package teap.pages;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RatingPage 
{
	WebDriver driver;

	public RatingPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getScriptNo()
	{
		String scriptNo = driver.findElement(By.id("copyScriptNoField")).getAttribute("value");
		
		return scriptNo.substring(1, scriptNo.length()-1);
	}
	
	public String getSection()
	{
		return driver.findElement(By.xpath("//th[text()='Section']//following::td[1]")).getText();
	}
	
	public String getTestSet()
	{
		return driver.findElement(By.xpath("//th[text()='TestSet']//following::td[1]")).getText();
	}
	
	public String getPart()
	{
		return driver.findElement(By.xpath("//th[text()='Part']//following::td[1]/div/div")).getText();
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
	}public void rating()
	{
		driver.findElement(By.name("ratingBtn")).click();
	}
	
	public void pending()
	{
		driver.findElement(By.name("pendingBtn")).click();
	}
	
	public void handle_alert()
	{
		
		driver.findElement(By.name("modalBtn")).click();
	}

}
