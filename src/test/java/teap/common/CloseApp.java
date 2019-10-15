package teap.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CloseApp 
{
	WebDriver driver;

	public CloseApp(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout()
	{
		driver.findElement(By.className("btn-warning")).click();
		driver.close();
		driver.quit();
	}

}
