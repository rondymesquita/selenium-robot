package br.com.example.driver;

import br.com.example.config.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class FirefoxDriverImpl extends AbstractDriverImpl<FirefoxDriver> implements AbstractFirefoxDriver{

    public FirefoxDriverImpl() throws InstantiationException, IllegalAccessException {
        super(FirefoxDriver.class);
        //driver = new FirefoxDriver();
    }

//    public WebDriver getRawDriver() {
//        return driver;
//    }

    public boolean exists() {
        Logger.logInfo("Called on FirefoxDriverImpl");
        return true;
    }
}
