package test.utility;

import fitnesse.browsers.DriverFactory;

public class EnvironmentVariableProvider {

	
	public EnvironmentVariableProvider() {
		// TODO Auto-generated constructor stub
	}



	public static String getBrowserToUse() {
		String browser = System.getenv("BROWSER");
		if (browser != null){
			return browser;
		}
		else {
			return DriverFactory.FIREFOX;
		}
	}



	public static String getFitnesseServer() {
		String fitnessServer = System.getenv("FITNESSESERVER");
		if (fitnessServer != null){
			return fitnessServer;
		}
		else {
			return "http://localhost:8080";
		}
	}
	
	
	

}
