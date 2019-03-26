package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public static final String LOGIN_PAGE_TITLE = "Login - My Store";

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy (id = "passwd")
    WebElement passwdField;

    @FindBy (id = "SubmitLogin")
    WebElement submitLoginBtn;

    public AccountPage logIn(String username, String password) {
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
        submitLoginBtn.click();
        return new AccountPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
