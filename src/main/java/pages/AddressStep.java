package pages;

import org.openqa.selenium.WebDriver;

public class AddressStep extends BaseStep {

    @Override
    public ShippingStep proceed() {
        $(proceedBtnLocator).click();
        return new ShippingStep(driver);
    }

    public AddressStep(WebDriver driver) {
        super(driver);
    }
}
