package teap.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import teap.common.CloseApp;
import teap.common.LaunchTeapApp;

//import teap.db.Putty;

public class Testcase2 {
	//static Process putty = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
		//putty = Putty.start();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() throws InterruptedException {
		WebDriver driver = LaunchTeapApp.LaunchApp();
		assertEquals("Login", driver.getTitle());
		driver.close();
		driver.quit();
		//assertEquals(0, teap.db.DBfunctions.load_db());
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//Putty.close(putty);
	}
}
