package br.com.example.robot;

import br.com.example.config.Log;
import br.com.example.driver.AbstractDriver;

import java.lang.reflect.Constructor;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Robot {

    private static AbstractDriver abstractDriver;
    private static AbstractRobot abstractRobot;
    private static final String FIREFOX = "firefox";
    private static final String APPIUM = "appium";
    private static final String SELENDROID = "selendroid";

    private Robot() {}

    public static AbstractDriver getInstance() {

        //String driver = System.getProperty("driver") != null ? System.getProperty("driver") : FIREFOX;
        String driver = SELENDROID;

        Log.info(String.format("Selected driver: %s", driver));

        abstractDriver = getAbstractDriverByGivenName(driver);

        return abstractDriver;
    }

    public static void quit() {
        if (abstractDriver != null) {
            abstractDriver.quit();
            Log.info("Driver stopped");
        }
    }

    private static AbstractDriver getAbstractDriverByGivenName(String driverName) {
        Class cl;
        try {
            cl = Class.forName(String.format("br.com.example.driver.%sDriverImpl", capitalize(driverName)));
            Constructor con = cl.getConstructor(null);
            abstractDriver = (AbstractDriver) con.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return abstractDriver;
    }

    private static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
