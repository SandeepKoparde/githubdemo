package teap.tests;

import static org.junit.jupiter.api.Assertions.*;
import static teap.common.Settings.RL_PASSWORD;
import static teap.common.Settings.RL_USER_ID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import teap.common.CloseApp;
import teap.common.LaunchTeapApp;

import teap.db.Putty;
import teap.pages.HomePage;
import teap.pages.LoginUserRegistration;
import teap.pages.MainMenuPage;
import teap.pages.PCConfigurationCheck;

//Test class names MUST end with Test or Tests.

@TestMethodOrder(OrderAnnotation.class)
public class Testcase2 {
	static Process putty = null;
	WebDriver driver = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		putty = Putty.start();
	}

	@BeforeEach
	void setUp() {
		driver = LaunchTeapApp.LaunchApp();
	}

	@Test
	@Order(1)
	@DisplayName("User Registration")
	void user_registeration() {
		HomePage hp = new HomePage(driver);
		hp.login(RL_USER_ID, RL_PASSWORD);
		
		MainMenuPage mnp = new MainMenuPage(driver);
		mnp.login_user_registration();

		LoginUserRegistration lur = new LoginUserRegistration(driver);
		lur.file_upload("F:\\Rating_System_Regression_Automation\\Template\\UserRegistrationTemplate_TEAP_2.csv");

		String expected_msg = "Login user information on 1 people was registered.";
		String actual_message = driver.findElement(By.xpath("//h2[.='Upload Results']//following::div")).getText();
		assertAll("Upload Message", () -> assertEquals(expected_msg, actual_message, "Upload Message"));

	}

	@Test
	@Order(2)
	@DisplayName("New User Login")
	void new_user_login() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.login("RT6", RL_PASSWORD);

		MainMenuPage mnp = new MainMenuPage(driver);
		mnp.pc_configuration_check();

		PCConfigurationCheck pccc = new PCConfigurationCheck(driver);
		pccc.select_all_checkboxes();
		pccc.recommendation_screen_fitness();

		mnp.rating_for_rater(); 
		String expected_msg="You must complete....";
		String actual_message = mnp.getCompleteTrainingMessage();
		assertAll("Upload Message", () -> assertEquals(expected_msg, actual_message, "Upload Message"));
		
		mnp.backToMenu();
		mnp.training();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		CloseApp close = new CloseApp(driver);
		close.logout();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Putty.close(putty);
	}
}
