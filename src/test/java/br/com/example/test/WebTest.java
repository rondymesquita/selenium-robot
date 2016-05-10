package br.com.example.test;

import br.com.example.driver.AbstractDriver;
import br.com.example.page.DuckDuckGoPage;
import br.com.example.robot.Robot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * Basic functional test with selenium using junit
 *
 */
public class WebTest{

	private AbstractDriver driver;
	private DuckDuckGoPage duckDuckGoPage;

	@Before
	public void before(){
        driver = Robot.getInstance();
		duckDuckGoPage = new DuckDuckGoPage(driver);
	}

	@After
	public void after(){
        Robot.quit();
	}

	/*
	 * Using Page Objects
	 */
	@Test
	public void shouldDoASearchOnDuckDuckGoUsingPageObjectsApproach(){
		duckDuckGoPage.open();

		duckDuckGoPage.setSearchField("Darth Vader");
		duckDuckGoPage.clickOnSearchButton();

		driver.getPageSource().contains("Darth Vader");
	}

	@Test
	public void shouldDoASearchOnDuckDuckGo(){
		driver.get("https://duckduckgo.com");

		WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));
		searchField.sendKeys("Darth Vader");

		driver.findElement(By.id("search_button_homepage")).click();
		driver.getPageSource().contains("Darth Vader");
	}

}
