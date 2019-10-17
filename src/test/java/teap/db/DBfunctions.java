package teap.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static teap.common.Settings.*;

public class DBfunctions
{
	
	public static int load_db() throws InterruptedException
	{
		String mysql_cmd = "mysql.exe --protocol=tcp --host=" + DB_HOST + "  --port=" + DB_PORT + " --database=" + DB_NAME +
									" --user="+ DB_USERNAME +" --password=" + DB_PASSWORD + 
									" --default-character-set=utf8 --comments < cbt_pf_crg_20190920.dev.sql";
		//System.out.println(mysql_cmd);
		
		String[] db_load_cmd = new String[]{"cmd.exe","/c", mysql_cmd};
		File working_dir= new File("F:\\Rating_System_Regression_Automation\\DB_Backups\\DB_2Anchorscripts_RatingStart");
		
		Process load_db_mysl = null;
		
		try {
			load_db_mysl=Runtime.getRuntime().exec(db_load_cmd, null, working_dir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return load_db_mysl.waitFor();
	}
	
	public static Connection est_conn()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void restoreDB()
	{
		
	}
	
	
}
