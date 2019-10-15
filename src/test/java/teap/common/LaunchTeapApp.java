package teap.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTeapApp {
	
	public static WebDriver LaunchApp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(Settings.URL);
		driver.manage().window().maximize();
		return driver;
	}
}
