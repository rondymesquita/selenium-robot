package br.com.example.driver;

import br.com.example.config.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public abstract class AbstractDriverImpl<T> implements AbstractDriver<T>{

    protected final Class<T> tClass;
    protected WebDriver driver;

    public AbstractDriverImpl(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        this.tClass = tClass;
        driver = (WebDriver) tClass.newInstance();
    }

    public boolean exists() {
        Logger.logInfo("Called on AbstractDriverImpl");
        return false;
    }
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
