package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Conditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

public class LandingPage extends BasePage {

	String accountPageTitle = "My Store";

	private JavascriptExecutor js = (JavascriptExecutor)driver;

	@FindBy (className = "login")
	private WebElement singInLink;

	@FindBy(id = "search_query_top")
	private WebElement searchField;

	@FindBy(xpath = "//*[@id='index']/div[2]/ul/li[1]")
	private WebElement firstTip;

	@FindBy(id = "facebook_block")
	private WebElement facebook_block;

	@FindBy(xpath = "//*[@id='facebook_block']/div/div/span/iframe")
	private WebElement facebook_frame;

	@FindBy(xpath = "//*[@class='_li']//script")
	public WebElement inFrameFacebookScript;

	private By submitSearchBtnLocator = By.xpath("//*[@id=\"searchbox\"]/button");
	private By searchFieldLocator = By.id("search_query_top");
	private By firstTipLocator = By.xpath("//*[@id='index']/div[2]/ul/li[1]");
	private By searchResultItems = By.xpath("//*[@id=\"center_column\"]/ul/li");

	public LandingPage switchToFacebookBlock (){
		js.executeScript("arguments[0].scrollIntoView(true)", facebook_block);
		driver.switchTo().frame(facebook_frame);
		return this;
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

	public LandingPage(WebDriver driver) {
		super(driver);
	}
}
