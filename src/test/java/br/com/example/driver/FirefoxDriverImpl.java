package br.com.example.driver;

//import br.com.example.config.Logger;
import br.com.example.config.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class FirefoxDriverImpl extends AbstractDriverImpl<FirefoxDriver> implements AbstractFirefoxDriver{

    public FirefoxDriverImpl() throws InstantiationException, IllegalAccessException {
        super(FirefoxDriver.class);
        driver = new FirefoxDriver();
    }

}
