package br.com.example.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public interface RobotDriver<T> extends WebDriver{
    /**
     *
     * @return Selenium Webdriver instance without custom methods
     */
    WebDriver getRawDriver();

    /**
     * @param element
     * @return A boolean if given element exists on opened page
     * @throws Exception
     */
    boolean exists(By element) throws Exception;

    /**
     * Wait until given element is visible on opened page
     * @param element
     * @throws Exception
     */
    void waitUntilVisibilityOfElementLocated(By element) throws Exception;

    /**
     * Wait until given element have the given text
     * @param element
     * @param text
     * @throws Exception
     */
    void waitUntilTextMatches(By element, String text) throws Exception;

}