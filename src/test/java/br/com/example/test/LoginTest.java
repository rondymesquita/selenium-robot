package br.com.example.test;

import br.com.example.driver.RobotDriver;
import br.com.example.page.DashboardPage;
import br.com.example.page.LoginPage;
import br.com.example.robot.Robot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest{

	private RobotDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void before() throws IllegalAccessException, InstantiationException {
		driver = Robot.getRobotDriver(); //See Robot to get more informations
		loginPage = new LoginPage(driver);
	}
	
	@After
	public void after(){
		Robot.quit();
	}
	
	@Test
	public void shouldDoLoginWithValidUser() throws Exception {
		loginPage.open();
		Assert.assertTrue(loginPage.isOpened());
		DashboardPage dashboardPage = loginPage.loginWithValidUser();
		Assert.assertTrue(dashboardPage.isOpened());
		Assert.assertTrue(!loginPage.isOpened());
	}

	@Test
	public void shouldDoLogoutWithSuccess() throws Exception {
		loginPage.open();
		DashboardPage dashboardPage = loginPage.loginWithValidUser();
		loginPage = dashboardPage.logout();
		Assert.assertTrue(loginPage.isOpened());
		Assert.assertTrue(!dashboardPage.isOpened());
	}

	@Test
	public void shouldShowAlertWhenSigninWithInvalidUser() throws Exception {
		loginPage.open();
		loginPage.loginWithInvalidUser();
		Assert.assertTrue(loginPage.getAlert().isError());
	}
	
	
}
