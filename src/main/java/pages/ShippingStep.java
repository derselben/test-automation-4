package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingStep extends BaseStep{

    private By IAgreeCheckBoxLocator = By.id("uniform-cgv");

    public PaymentStep proceed() {
        super.proceed();
        return new PaymentStep(driver);
    }

    public ShippingStep iAgree(){
        $(IAgreeCheckBoxLocator).click();
        return this;
    }

    public ShippingStep(WebDriver driver) {
        super(driver);
    }
}
