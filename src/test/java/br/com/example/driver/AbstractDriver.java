package br.com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
//public abstract class Example implements WebDriver{
//
//    public boolean exists(){
//        return true;
//    }
//
//}

public interface AbstractDriver <T> extends WebDriver{
    abstract WebDriver getRawDriver();
    boolean exists();

}