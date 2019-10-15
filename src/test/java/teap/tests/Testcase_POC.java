package teap.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;

import teap.common.CloseApp;
import teap.common.LaunchTeapApp;
import static teap.common.Settings.*;
import teap.db.DBfunctions;
import teap.db.Putty;
import teap.pages.DailyRefreshTrainingPage;
import teap.pages.HomePage;
import teap.pages.MainMenuPage;
import teap.pages.RatingPage;
import teap.pages.RatingSchemeManagementPage;

@TestMethodOrder(OrderAnnotation.class)
public class Testcase_POC
{	
	static Process putty = null;
	WebDriver driver = null;
			
	@BeforeAll
	static void init()
	{
		putty = Putty.start();
		System.out.println("Start DB Loading");
		int db_load_exit_value = 0;
		try {
			db_load_exit_value = DBfunctions.load_db();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(db_load_exit_value);	
	}
	
	@BeforeEach
	void launchApp()
	{
		driver = LaunchTeapApp.LaunchApp();
		
	}
	
	@Test
	@Order(1)
	@DisplayName("Setting Up QC Script Incidence Value")
	void setUp() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.login(RL_USER_ID, RL_PASSWORD);
		
		MainMenuPage mnp = new MainMenuPage(driver);
		mnp.rating_scheme_management();
		
		RatingSchemeManagementPage rsmp=new RatingSchemeManagementPage(driver);
		rsmp.set_QCScript_incidence(1);	
		
		assertAll("Setup", 	() -> assertEquals(1, 2, "Dummy Testcondition"));
	}
	
	@Test
	@Order(2) 
	@DisplayName("Database Testing PoC")
	public void databaseTesting() throws Exception 
	{
		HomePage hp2=new HomePage(driver);
		hp2.login(RT_USER_ID, RT_PASSWORD);
		
		MainMenuPage mnp = new MainMenuPage(driver);
		mnp.rating_for_rater();
		
		DailyRefreshTrainingPage drtp = new DailyRefreshTrainingPage(driver);
		Thread.sleep(15000);
		drtp.rate_script();
		drtp.rating();
		drtp.next();
		drtp.handle_alert();
		
		RatingPage rp = new RatingPage(driver);
		String scriptNo = rp.getScriptNo();
		//System.out.println(scriptNo);
		
		String section = rp.getSection();
		System.out.println(section);
		
		String testSet = rp.getTestSet();
		System.out.println(testSet);
		
		String part = rp.getPart();
		System.out.println(part);
		
		Thread.sleep(15000);
		rp.rate_script();
		rp.rating();
		rp.handle_alert();
		
		Connection conn = DBfunctions.est_conn();
		String query = "SELECT raterId, ratingdate, ratingstatus, ratingCnt, stage  "
				+ "FROM cbt_pf_crg.m_script_info "
				+ "where scriptNo='"+scriptNo+"';";
		
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery(query);
		rs.first();
		
    	String raterId = rs.getString(1);
    		
    	Date date = rs.getTimestamp(2);
    	String ratingdate = new SimpleDateFormat("yyyy/MM/dd").format(date);
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	String sysDate=dtf.format(now);
    		
        int ratingstatus = rs.getInt(3);
            
        int ratingCnt = rs.getInt(4);
            
        int stage = rs.getInt(5);
            
    	assertAll("Database Testing", 	() -> assertEquals(RT_USER_ID, raterId, "Rater ID"),
										() -> assertEquals(sysDate, ratingdate, "Rating Date" ),
										() -> assertEquals(1,ratingstatus, "Rating Status"),
										() -> assertEquals(2, ratingCnt, "Rating Count"),
										() -> assertEquals(3, stage, "Rating Stage"));
		
			
		// closing DB Connection		
		conn.close();
	}
	
	@AfterEach
	void logout() throws InterruptedException
	{
		Thread.sleep(3000);
		CloseApp close = new CloseApp(driver);
		close.logout();
		Thread.sleep(3000);
	}
	
	@AfterAll
	static void tearDown()
	{
		Putty.close(putty);
	}

}
