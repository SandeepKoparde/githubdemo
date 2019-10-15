package Test1;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
public class Testcase1 
{
	static WebDriver driver = null;
	
	@BeforeAll
	static void init()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@BeforeEach
	void launchApp()
	{
		driver.get("http://www.newtours.demoaut.com/");
	}
	
	@Test
	@Order(1)
	@DisplayName("validate title")
	void validate_title()
	{
		assertAll("Validate Title", 	() -> assertEquals("Welcome: Mercury Tours", driver.getTitle(), "Title Validation"));
	}
	
	@AfterEach
	void close()
	{
		driver.close();
	}
	
	@AfterAll
	static void tearDown()
	{
		driver.quit();
	}

}
