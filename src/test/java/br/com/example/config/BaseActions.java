package br.com.example.config;

import br.com.example.page.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static br.com.example.config.Logger.*;

/**
 * Created by alvaro_silva on 09/05/2016.
 */
public class BaseActions {

    private WebDriver driver;

    public BaseActions(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @param element
     * @return A boolean if given element exists on opened page
     * @throws Exception
     */
    public boolean exists(By element) throws Exception{
        waitUntilVisibilityOfElementLocated(element);
        return driver.findElements(element).size() > 0;
    }

    /**
     * Wait for given element to exist
     * @param element
     * @throws Exception
     */
    public void waitUntilVisibilityOfElementLocated(By element) throws Exception{
        try{
            WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch(Exception e){
            String msg = "Could not find "+element;
            logSevere(msg);
            throw new Exception(msg);
        }
    }

    public void waitUntilTextMatches(By element, String text) throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
            wait.until(ExpectedConditions.textMatches(element, Pattern.compile(text)));
        }catch(Exception e){
            String msg = "Could not find "+element;
            logSevere(msg);
            throw new Exception(msg);
        }
    }
//    public void waitUntilPageOpens(Page page) {
//        WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
//        wait.until(
//                ExpectedConditions.urlMatches(page.URL)
//        );
//    }

}
