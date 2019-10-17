package teap.common;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchTeapApp {
	
	public static WebDriver LaunchApp()
	{
		String driverpath = Paths.get("src", "test", "resources","webdrivers","chromedriver.exe").toFile().getAbsolutePath();
		//System.out.println(driverpath);
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.get(Settings.URL);
		driver.manage().window().maximize();
		return driver;
	}
}
