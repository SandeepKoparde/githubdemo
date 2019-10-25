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
	
	public void login_user_registration()
	{
		driver.findElement(By.xpath("//button[text()='Login user Registration']")).click();
	}
	
	public void pc_configuration_check()
	{
		driver.findElement(By.xpath("//button[text()='PC Configuration Check']")).click();
	}

	public String getCompleteTrainingMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void backToMenu() {
		// TODO Auto-generated method stub
		
	}

	public void training() {
		// TODO Auto-generated method stub
		
	}
}
