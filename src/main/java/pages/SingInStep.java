package pages;

import org.openqa.selenium.WebDriver;

public class SingInStep extends BaseStep{

    @Override
    public AddressStep proceed() {
        return ((AddressStep) super.proceed());
    }

    public SingInStep(WebDriver driver) {
        super(driver);
    }

    public BaseStep logIn(String username, String password) {
        new LoginPage(driver).logIn(username, password);
        return this;
    }
}
