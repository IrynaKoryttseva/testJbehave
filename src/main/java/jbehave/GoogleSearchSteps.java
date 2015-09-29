package jbehave;

import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchSteps {
	WebDriver driver;

	@Given("I run Firefox browser")
	public void IrunFirefoxBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");

		System.out.println("Browser opened");

	}

	
	@When("I input my data $string")
	public void IinputMyData(String string) {
		GoogleMainPage gmp = new PageFactory().initElements(driver,GoogleMainPage.class);
		gmp.InputInSearchBar(string);
		gmp.ClickTheButton();

	}

	@Then("system get me result of search")
	public void SystemGetMeResult() throws Exception {
		GoogleMainPage gmp = new PageFactory().initElements(driver,GoogleMainPage.class);
		gmp.ContentOnPage();
		gmp.getPagesReturned();
		driver.quit();
	}

}
