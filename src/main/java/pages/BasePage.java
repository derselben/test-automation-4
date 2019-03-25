package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.SimpleAPI;

public abstract class BasePage extends SimpleAPI {

	protected WebDriver driver;
//	protected Actions action = new Actions(getDriver());

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected WebDriver getDriver() {
		return driver;
	}
}
