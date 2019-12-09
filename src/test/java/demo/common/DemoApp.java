package demo.common;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.common.Settings;

public class DemoApp {
	
	public static WebDriver launchApp()
	{
		String driverpath = Paths.get("src", "test", "resources","webdrivers","chromedriver.exe").toFile().getAbsolutePath();
		//System.out.println(driverpath);
		//System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.get(Settings.APP_URL);
		driver.manage().window().maximize();
		return driver;
	}
}
