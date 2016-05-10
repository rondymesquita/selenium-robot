package br.com.example.driver;

import br.com.example.config.Config;
import br.com.example.config.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public abstract class AbstractDriverImpl<T> implements AbstractDriver<T>{

    protected final Class<T> tClass;
    protected WebDriver driver;

    public AbstractDriverImpl(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        this.tClass = tClass;
    }

    public boolean exists(By element) throws Exception{

        waitUntilVisibilityOfElementLocated(element);
        return driver.findElements(element).size() > 0;
    }

    public void waitUntilVisibilityOfElementLocated(By element) throws Exception{
        try{
            WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch(Exception e){
            String msg = "Could not find " + element;
            Log.severe(msg);
            throw new Exception(msg);
        }
    }

    public void waitUntilTextMatches(By element, String text) throws Exception {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
            wait.until(ExpectedConditions.textMatches(element, Pattern.compile(text)));
        }catch(Exception e){
            String msg = "Could not find "+element;
            Log.severe(msg);
            throw new Exception(msg);
        }
    }
//    public void waitUntilPageOpens(Page page) {
//        WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT);
//        wait.until(
//                ExpectedConditions.urlMatches(page.URL)
//        );
//    }

    public WebDriver getRawDriver(){
        return driver;
    }

    public void get(String s) {
        driver.get(s);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }
}
