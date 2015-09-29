package jbehave;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage {
	private WebDriver driver;

	public GoogleMainPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "q")
	private WebElement searchBar;
	@FindBy(name = "btnG")
	private WebElement button;

	@FindBy(id = "resultStats")
	private WebElement resultDiv;

	public void getPagesReturned() throws Exception {
		if (resultDiv.isDisplayed()) {
			System.out.println(resultDiv.getText());
		}
	}

	public void InputInSearchBar(String text) {
		searchBar.sendKeys(text);
	}

	public void ContentOnPage() {
		System.out.println(driver.getTitle());
	}

	public void Teardown() {
		driver.close();
	}

	public void ClickTheButton() {
		button.click();
	}
}
