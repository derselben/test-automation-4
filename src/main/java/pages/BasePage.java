package pages;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SimpleAPI;

public abstract class BasePage extends SimpleAPI {

	protected WebDriver driver;

	@FindBy(className = "logout")
	WebElement singOutLink;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BasePage signOut(){
		singOutLink.click();
		return this;
	}

	protected WebDriver getDriver() {
		return driver;
	}
}
