package demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.WebDriver;

import demo.common.DemoApp;
import demo.pages.HomePage;

@TestMethodOrder(OrderAnnotation.class)
public class DemoTest {

	WebDriver driver = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		driver=DemoApp.launchApp();
	}

	@Test
	@Order(1)
	@DisplayName("Home Page")
	void test() {
		HomePage hp = new HomePage(driver);
		String expectedDisplayDate="S";
		String actualDisplayDate = hp.getDate();
		assertAll("Date displayed on Home Page", 
					() -> assertEquals(expectedDisplayDate, actualDisplayDate, 
				"Incorrect Date diaplayed on Home Page"));
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

}
