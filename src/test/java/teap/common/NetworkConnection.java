package teap.common;

import java.io.IOException;


public class NetworkConnection 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(NetworkConnection.connectToWifi());
	}
	
	public static int connectToWifi() throws IOException, InterruptedException
	{
		Process wifi=Runtime.getRuntime().exec("netsh wlan connect ssid=Jiem-india name=Jiem-india");
		return wifi.waitFor();
	}

}
