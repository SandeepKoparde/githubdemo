package teap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingSchemeManagementPage 
{
	WebDriver driver;

	public RatingSchemeManagementPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void set_QCScript_incidence(int value)
	{
		try {
			driver.findElement(By.id("qcScriptIncidence")).clear();
			Thread.sleep(2000);
			
			driver.findElement(By.id("qcScriptIncidence")).sendKeys(String.valueOf(value));
			driver.findElement(By.id("checkButton")).click();
		
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("checkButton")).click();
		
		
	}

}
