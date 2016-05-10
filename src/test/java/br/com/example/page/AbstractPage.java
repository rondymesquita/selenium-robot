package br.com.example.page;

import br.com.example.config.Log;
import br.com.example.driver.RobotDriver;

/**
 * Created by rondymesquita on 26/09/15.
 */
abstract class AbstractPage {

    protected RobotDriver driver;
    public static String url;

    AbstractPage(RobotDriver driver, String url){
        this.driver = driver;
        this.url = url;
    }

    public void open(){
        Log.info("Opening " + url);
        driver.get(url);
    }


}
