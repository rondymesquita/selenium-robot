package br.com.example.page;

import java.io.File;

import br.com.example.config.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{
	
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

	BaseActions baseActions;
	
	public LoginPage(WebDriver driver) {
		super(driver, url);
		baseActions = new BaseActions(driver);
	}
	
	public DashboardPage loginWithValidUser() throws Exception {
		setCredentials(VALID_USERNAME, VALID_PASSWORD);

		DashboardPage dashboardPage = clickLoginButton();
		baseActions.waitUntilTextMatches(dashboardPage.contentTitleBy, dashboardPage.TITLE);
//		DashboardPage dashboardPage = clickLoginButton();
//		baseActions.waitUntilPageOpens(dashboardPage);
		return dashboardPage;
	}
	
	public void loginWithInvalidUser(){
		setCredentials("invalid@email.com", "");
		clickLoginButton();
	}

	public void loginWith(String username, String password){
		setCredentials(username, password);
		clickLoginButton();
	}
	
	private void setUsername(String username){
		driver.findElement(usernameFieldBy).sendKeys(username);
	}
	
	private void setPassword(String password){
		driver.findElement(passwordFieldBy).sendKeys(password);
	}
	
	private void setCredentials(String username, String password){
		setUsername(username);
		setPassword(password);
	}
	
	private DashboardPage clickLoginButton(){
		driver.findElement(loginButton).click();
		return new DashboardPage(driver);
	}


}
