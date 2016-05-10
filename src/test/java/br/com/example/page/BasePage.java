package br.com.example.page;

import br.com.example.driver.AbstractDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by rondymesquita on 26/09/15.
 */
abstract class Page {

    protected AbstractDriver driver;
    public static String url;

    Page(AbstractDriver driver, String url){
        this.driver = driver;
        this.url = url;
    }

    public void open(){
        driver.get(url);
    }


}
