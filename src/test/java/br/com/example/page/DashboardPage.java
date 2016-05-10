package br.com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by alvaro_silva on 09/05/2016.
 */
public class DashboardPage extends Page{

    public static final String URL = "file://" + new File("./assets/public/dashbord.html").getAbsolutePath();

    public final By logoutButtonBy = By.id("logout_button");
    public final By contentTitleBy = By.id("title");

    public final String TITLE = "Dashboard";


    public DashboardPage(WebDriver driver) {
        super(driver, URL);
    }

    public LoginPage logout(){
        driver.findElement(logoutButtonBy).click();
        return new LoginPage(driver);
    }

    public boolean isOpened(){
        return driver.getCurrentUrl().contains("dashboard") && driver.findElement(contentTitleBy).getText().equals(TITLE);
    }

}
