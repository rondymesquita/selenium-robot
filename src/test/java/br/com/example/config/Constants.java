package br.com.example.config;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Constants {
	
	public static final String APP_URL = "PUT URL APPLICATION HERE";
	public static final String APP_USERNAME = "1";
	public static final String APP_PASSWORD = "1";
	public static final String FINAL_APP_URL = String.format("http://%s:%s@%s", Constants.APP_USERNAME, Constants.APP_PASSWORD, Constants.APP_URL);
	
}
