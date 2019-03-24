package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Conditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

public class LandingPage extends BasePage {

	String accountPageTitle = "My Store";

	@FindBy (className = "login")
	WebElement singInLink;

	@FindBy(id = "search_query_top")
	WebElement searchField;

	@FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
	WebElement firstTip;

	By searchFieldLocator = By.id("search_query_top");
	By firstTipLocator = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public LandingPage visit() {
		open("http://automationpractice.com/index.php");
		return this;
	}

	public void searchFor(String query) {
		$(searchFieldLocator, Conditions.CLICKABLE).click();
		$(searchFieldLocator).clear();
		$(searchFieldLocator).sendKeys(query);
	}

	public LoginPage goToLogIn(){
		singInLink.click();
		return new LoginPage(driver);
	}

	public void searchFor(String query, String oldTip) {
		searchFor(query);
		waitFor(invisibilityOfElementWithText(firstTipLocator, oldTip), 5l);
	}

	public String getFirstTipText() {
		return $(firstTipLocator).getText();
	}
}