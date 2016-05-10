package br.com.example.page.components;

import br.com.example.driver.AbstractDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by alvaro_silva on 10/05/2016.
 */
public class Alert extends AbstractComponent{

    private final By alertBy = By.cssSelector(".alert");
    private final By alertDangerBy = By.cssSelector(".alert.alert-danger");
    private final By alertProgressBy = By.cssSelector(".alert.alert-progress");

    public Alert(AbstractDriver driver) {
        super(driver);
    }

    public boolean isError() throws Exception {
        driver.waitUntilVisibilityOfElementLocated(alertDangerBy);
        return driver.findElement(alertDangerBy).isDisplayed();
    }
}