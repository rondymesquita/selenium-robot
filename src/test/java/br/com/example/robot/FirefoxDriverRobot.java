package br.com.example.robot;

import br.com.example.driver.FirefoxDriverImpl;
import org.openqa.selenium.WebDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class FirefoxDriverRobot {

        private WebDriver driver;

        public WebDriver getDriver() throws IllegalAccessException, InstantiationException {
            quitDriver();
            driver = new FirefoxDriverImpl();
            return driver;
        }

        public void quitDriver() {
            if(driver != null){
                driver.quit();
            }
        }


}
