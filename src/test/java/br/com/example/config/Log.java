package br.com.example.config;

import java.util.logging.Level;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Log {
	
	private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Logger.class");
	private static final String PREFIX = "===>";
	private static final String SUFFIX = "<===";

	public static void info(String msg){
		logger.log(Level.INFO, log(msg));
	}
	
	public static void severe(String msg){
		logger.log(Level.SEVERE, log(msg));
	}

	private static String log(String msg){
		return String.format("%s%s%s", PREFIX, msg, SUFFIX);
	}

}
