package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.FileDownloader;


public class AccountPage extends BasePage {

    WebDriver driver;

    public static String accountPageTitle = "My account - My Store";

    @FindBy(className = "logout")
    WebElement singOutLink;

    public LoginPage signOut(){
        singOutLink.click();
        return new LoginPage(driver);
    }

    public void openOrders(){
        $(By.className("icon-list-ol")).click();
        waitFor(ExpectedConditions.titleContains("Order history"));
    }

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
