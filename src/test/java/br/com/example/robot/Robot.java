package br.com.example.robot;

import br.com.example.config.Log;
import br.com.example.driver.RobotDriver;

import java.lang.reflect.Constructor;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Robot {

    private static RobotDriver robotDriver;
    private static final String FIREFOX = "firefox";
    private static final String APPIUM = "appium";
    private static final String SELENDROID = "selendroid";

    private Robot() {}

    public static RobotDriver getRobotDriver() {

        String driver = System.getProperty("driver") != null ? System.getProperty("driver") : FIREFOX;
        //String driver = SELENDROID;

        Log.info(String.format("Selected driver: %s", driver));

        robotDriver = getAbstractDriverByGivenName(driver);

        return robotDriver;
    }

    public static void quit() {
        if (robotDriver != null) {
            robotDriver.quit();
            Log.info("Driver stopped");
        }
    }

    private static RobotDriver getAbstractDriverByGivenName(String driverName) {
        Class cl;
        try {
            cl = Class.forName(String.format("br.com.example.driver.%sDriverImpl", capitalize(driverName)));
            Constructor con = cl.getConstructor(null);
            robotDriver = (RobotDriver) con.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return robotDriver;
    }

    private static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
