package br.com.example.robot;

import br.com.example.config.Log;
import br.com.example.driver.RobotDriver;

import java.lang.reflect.Constructor;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Robot {

    private static RobotDriver robotDriver;
    public static final String FIREFOX = "firefox";
    public static final String APPIUM = "appium";
    public static final String SELENDROID = "selendroid";
    private static String defaultDriver = FIREFOX;

    private Robot() {}

    public static RobotDriver getRobotDriver() {

        String driver = System.getProperty("driver") != null ? System.getProperty("driver") : defaultDriver;

        Log.info(String.format("Selected driver: %s", driver));

        robotDriver = getAbstractDriverByGivenName(driver);

        return robotDriver;
    }

    public static RobotDriver getRobotDriver(String driver) {

        System.setProperty("driver", driver);

        return getRobotDriver();
    }

    public static void quit() {
        if (robotDriver != null) {
            robotDriver.quit();
            Log.info("Driver stopped");
        }
    }

    private static RobotDriver getAbstractDriverByGivenName(String driverName) {
        Class cl;
        String className = String.format("br.com.example.driver.impl.%sRobotDriverImpl", capitalize(driverName));
        try {
            cl = Class.forName(className);
            Constructor con = cl.getConstructor(null);
            robotDriver = (RobotDriver) con.newInstance();
        } catch (Exception e) {
            Log.severe(String.format("There is not any driver to instantiate with name: %s", className));
            e.printStackTrace();
        }
        return robotDriver;
    }

    private static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
