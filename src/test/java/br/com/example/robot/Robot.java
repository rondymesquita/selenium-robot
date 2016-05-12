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

    /**
     * Get RobotDriver instance based on 'driver' system property
     * E.g.: If 'driver' system property is 'firefox', this method will return 'FirefoxRobotDriverImpl' instance if this class exists on driver package
     * @return RobotDriver instance
     */
    public static RobotDriver getRobotDriver() {

        String driver = System.getProperty("driver") != null ? System.getProperty("driver") : defaultDriver;

        Log.info(String.format("Selected driver: %s", driver));

        robotDriver = getAbstractDriverByGivenName(driver);

        return robotDriver;
    }

    /**
     * Get RobotDriver instance based on given parameter.
     * E.g.: Use getRobotDriver(Robot.FIREFOX) to return 'FirefoxRobotDriverImpl' instance.
     * @param driver
     * @return RobotDriver instance
     */
    public static RobotDriver getRobotDriver(String driver) {

        System.setProperty("driver", driver);

        return getRobotDriver();
    }

    /**
     * Quit running RobotDriver
     */
    public static void quit() {
        if (robotDriver != null) {
            robotDriver.quit();
            Log.info("Driver stopped");
        }
    }

    /**
     * Return an instance from given parameter
     * E.g.: If 'drivernamer' passed is 'firefox', this method will return 'FirefoxRobotDriverImpl' instance if this class exists on driver package
     * @param driverName
     * @return
     */
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

    /**
     * Put first letter to uppercase
     * E.g.: If you pass 'sampleWord', it will return 'SampleWord'
     * @param text
     * @return
     */
    private static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
