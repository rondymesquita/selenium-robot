package br.com.example.driver.impl;

//import br.com.example.config.Logger;
import br.com.example.driver.FirefoxRobotDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class FirefoxRobotDriverImpl extends RobotDriverImpl<FirefoxDriver> implements FirefoxRobotDriver {

    public FirefoxRobotDriverImpl() throws InstantiationException, IllegalAccessException {
        super(FirefoxDriver.class);
        driver = new FirefoxDriver();
    }

}
