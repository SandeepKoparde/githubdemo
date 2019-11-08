package teap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginUserRegistration {
	WebDriver driver;
	
	public LoginUserRegistration(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void file_upload(String filepath)
	{
		/*
		 *  The JavaScript code is required if your web-site has hidden the HTML INPUT tag of type="file"
		 *  behind the click action of a button (or other UI element) by setting the display ='none'.
		 *  
		 *  The first JavaScript code unhides the HTML file selector while
		 *  the second JavaScript code hides the HTML file selector again
		 *  The Selenium code in between actually sets the value of the file to be uploaded.
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("var myfile = document.getElementById('userFile');"
						+ "myfile.style.display = 'block';"
		/*
		 * Uncomment the below 2 lines if you get an error that the file input element is not displayed.
		 * This code changes the dimensions of the file input element to make them non-zero;
		*/			
		//				+ "myfile.style.height = '200px';"
		//				+ "myfile.style.width = '200px';"
						);
		
		driver.findElement(By.id("userFile")).sendKeys(filepath);
		js.executeScript("document.getElementById('userFile').style.display = 'none';");
		driver.findElement(By.xpath("//button[text()='Upload']")).click();
		driver.findElement(By.id("modal-submit")).click();
	}

}
