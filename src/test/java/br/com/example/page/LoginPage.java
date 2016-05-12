package br.com.example.page;

import br.com.example.driver.RobotDriver;
import br.com.example.page.components.Alert;
import org.openqa.selenium.By;

import java.io.File;

public class LoginPage extends AbstractPage {

    /*
     * Set url to you login page
     * e.g.: http://myapp/loginPage
     */
    public static String url = "file://" + new File("./assets/public/login.html").getAbsolutePath();

    /*
     * Credentials fields
     */
    public final By usernameFieldBy = By.id("username_field");
    public final By passwordFieldBy = By.id("password_field");

    /*
     * Login or submit buttton
     */
    public final By loginButton = By.id("login_button");

    private static final String VALID_USERNAME = "admin@admin.com";
    private static final String VALID_PASSWORD = "admin";

    /*
    Components
     */
    private Alert alert = new Alert(driver);

    public LoginPage(RobotDriver driver) {
        super(driver, url);
    }

    public DashboardPage loginWithValidUser() throws Exception {
        setCredentials(VALID_USERNAME, VALID_PASSWORD);
        clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.waitUntilTextMatches(dashboardPage.contentTitleBy, dashboardPage.TITLE);

        return dashboardPage;
    }

    public void loginWithInvalidUser() {
        setCredentials("invalid@email.com", "invalidPassword");
        clickLoginButton();
    }

    public void loginWith(String username, String password) {
        setCredentials(username, password);
        clickLoginButton();
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().contains("login") &&
                driver.findElement(usernameFieldBy).isDisplayed() &&
                driver.findElement(passwordFieldBy).isDisplayed();
    }

    public Alert getAlert() {
        return alert;
    }

    private void setUsername(String username) {
        driver.findElement(usernameFieldBy).sendKeys(username);
    }

    private void setPassword(String password) {
        driver.findElement(passwordFieldBy).sendKeys(password);
    }

    private void setCredentials(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}
