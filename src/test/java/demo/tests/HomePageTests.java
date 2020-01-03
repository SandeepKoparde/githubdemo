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
import demo.common.General;
import demo.common.Settings;
import demo.pages.FlightFinder;
import demo.pages.HomePage;

// Test class names MUST end with Test or Tests.

@TestMethodOrder(OrderAnnotation.class)
public class HomePageTests {

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
	@DisplayName("Validate Home Page")
	void HomePage() {
		HomePage hp = new HomePage(driver);
		
		//Text displayed validation using String comparison
		String expectedDisplayDate=General.getSystemDate();
		String actualDisplayDate = hp.getDate();
		
		//Field displayed validation using Boolean comparison
		boolean expUserNameIsDiplayed = true;
		boolean actUserNameIsDisplayed = hp.getIsUserNameDisplayed();
		
		//Field length validation using int
		int expPasswordLength = 10;
		int actPasswordLength = hp.getPasswordLength();
		
		assertAll("Home Page UI", 
					() -> assertEquals(expectedDisplayDate, actualDisplayDate, "Incorrect Date diaplayed on Home Page"),
					() -> assertEquals(expUserNameIsDiplayed, actUserNameIsDisplayed, "User Name is not displayed"),
					() -> assertEquals(expPasswordLength, actPasswordLength, "The Length of password field is incorrect")
				 );
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Validate Login Functionality")
	void login() {
		
		HomePage hp = new HomePage(driver);
		hp.login(Settings.USER_NAME, "India123$");
		
		FlightFinder ff = new FlightFinder(driver);
		
		//Validate title to ascertain Login is successful
		String expTitle = "Find a Flight: Mercury Tours: ";
		String actTitle = ff.getTitle();
		
		assertAll("Login", 
					() -> assertEquals(expTitle, actTitle, "Login not successful ")
				 );
		
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
