package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getDate()
	{
		/*
		 * String xpath= "//b[contains(text(),', 20')]"; 
		 * By dateLocator = By.xpath(xpath); 
		 * WebElement dateElement = driver.findElement(dateLocator);
		 * String date= dateElement.getText(); 
		 * return date;
		 */
		
		return driver.findElement(By.xpath("//b[contains(text(),', 20')]")).getText();
	}
	
	public boolean getIsUserNameDisplayed()
	{
		return driver.findElement(By.name("userName")).isDisplayed();
	}
	
	public int getPasswordLength()
	{
		return Integer.parseInt(driver.findElement(By.name("password")).getAttribute("size"));
	}
	
	public void login(String userName, String password)
	{
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}

}
