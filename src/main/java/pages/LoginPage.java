package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public static String loginPageTitle = "Login - My Store";

    @FindBy (id = "email")
    WebElement emailField;

    @FindBy (id = "passwd")
    WebElement passwdField;

    @FindBy (id = "SubmitLogin")
    WebElement SubmitLoginBtn;

    public AccountPage logIn(String username, String password){
        enterUsername(username)
                .enterPassword(password)
                .clickSubmitLoginBtn();
        return new AccountPage(driver);
    }

    public LoginPage enterUsername(String username){
        emailField.clear();
        emailField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwdField.clear();
        passwdField.sendKeys(password);
        return this;
    }

    public AccountPage clickSubmitLoginBtn(){
        SubmitLoginBtn.click();
        return new AccountPage(driver);
    }

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
