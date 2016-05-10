package br.com.example.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public interface AbstractDriver <T> extends WebDriver{
    
    abstract WebDriver getRawDriver();
    boolean exists(By element) throws Exception;
    void waitUntilVisibilityOfElementLocated(By element) throws Exception;
    void waitUntilTextMatches(By element, String text) throws Exception;

}