package br.com.example.robot;

import br.com.example.driver.AbstractDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public interface AbstractRobot {

    public AbstractDriver getDriver() throws IllegalAccessException, InstantiationException;
    public void quitDriver();
}
