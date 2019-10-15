package teap.db;

public class Putty 
{
	public static Process start()
	{
		String cmdForPuttyTunnel = "putty.exe -noagent -L 3306:cbtpft-dev-crgdb-a001.cbz0k2cieozb.ap-northeast-1.rds.amazonaws.com:3306 ec2-user@52.193.107.3 -i E:\\keys\\sandeep.koparde@jiem.in-dev.ppk";
		
		Process putty = null;
		
		try {
			putty = Runtime.getRuntime().exec(cmdForPuttyTunnel);
			Thread.sleep(15000);
		} catch (Exception e1) {
			//catches the exceptions thrown by both the above statements.
			e1.printStackTrace();
		}
		
		return putty;
		
	}
	
	public static void close(Process putty)
	{
		putty.destroy();
	}

}
