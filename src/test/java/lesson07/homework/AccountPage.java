package lesson07.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {

    WebDriver driver;

    static String accountPageTitle = "My account - My Store";

    @FindBy(className = "logout")
    WebElement singOutLink;

    LoginPage signOut(){
        singOutLink.click();
        return new LoginPage(driver);
    }

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
