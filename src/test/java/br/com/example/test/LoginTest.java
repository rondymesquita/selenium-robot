package br.com.example.test;

import br.com.example.driver.AbstractDriver;
import br.com.example.driver.FirefoxDriverImpl;
import br.com.example.page.DashboardPage;
import br.com.example.page.LoginPage;
import br.com.example.robot.Robot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest{

	private AbstractDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void before() throws IllegalAccessException, InstantiationException {
		driver = Robot.getInstance();
		loginPage = new LoginPage(driver);
	}
	
	@After
	public void after(){

//		driver.quit();
		Robot.quit();
	}
	
	@Test
	public void shouldDoLoginWithValidUser() throws Exception {
		loginPage.open();
		DashboardPage dashboardPage = loginPage.loginWithValidUser();
		Assert.assertTrue(dashboardPage.isOpened());
		Assert.assertTrue(driver.exists(dashboardPage.contentTitleBy));
	}
	
	
}
