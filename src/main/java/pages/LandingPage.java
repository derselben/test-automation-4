package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Conditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

public class LandingPage extends BasePage {

	String accountPageTitle = "My Store";

	public int quantityOfSearchedItems;

    protected Actions action = new Actions(driver);

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
	private By addToCartBtn = By.xpath(".//span[text()[contains(.,'Add to cart')]]");
	private By itemAddedPopUp = By.id("layer_cart");

	public LandingPage switchToFacebookBlock (){
		js.executeScript("arguments[0].scrollIntoView(true)", facebook_block);
		driver.switchTo().frame(facebook_frame);
		return this;
	}

	public LandingPage visit() {
		open("http://automationpractice.com/index.php");
		return this;
	}

	@Override
	public LandingPage signOut() {
		super.signOut();
		return this;
	}

	public LandingPage searchFor(String query) {
		$(searchFieldLocator, Conditions.CLICKABLE).click();
		$(searchFieldLocator).clear();
		$(searchFieldLocator).sendKeys(query);
		return this;
	}

	public LandingPage submitSearch() {
		$(submitSearchBtnLocator).click();
		waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultItems));
		quantityOfSearchedItems = $$(searchResultItems).size();
		return this;
	}

	public CartPopUp hoverOnNthSearchResultItemAndAddToCard (int n){
		System.out.println("trying to hover on " + n + "th item");
	    action.moveToElement($$(searchResultItems).get(n)).click().build().perform();
	    waitFor(ExpectedConditions.visibilityOf($$(searchResultItems).get(n).findElement(addToCartBtn)));
        $$(searchResultItems).get(n).findElement(addToCartBtn).click();
        return new CartPopUp(driver);
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
