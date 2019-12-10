package demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import demo.common.DemoApp;
import demo.pages.FlightFinder;
import demo.pages.HomePage;

class FlightFinderTests 
{
	WebDriver driver = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	

	@BeforeEach
	void setUp() throws Exception 
	{
		driver=DemoApp.launchApp();
		HomePage hp = new HomePage(driver);
		hp.login("sandykop@gmail.com", "India123$");
	}

	

	@Test
	void test() {
		FlightFinder ff = new FlightFinder(driver);
		
		String expSelectedTripType = "RoundTrip";
		String actSelectedTripType = ff.getSelectedTripType();
		
		assertAll("Default Trip Type selected", 
				() -> assertEquals(expSelectedTripType, actSelectedTripType, "Incorrect Default Trip Type selected")
			 );
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
}
