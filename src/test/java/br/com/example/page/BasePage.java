package br.com.example.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by rondymesquita on 26/09/15.
 */
abstract class Page {

    protected WebDriver driver;
    public static String url;

    Page(WebDriver driver, String url){
        this.driver = driver;
        this.url = url;
    }

    public void open(){
        driver.get(url);
    }


}
