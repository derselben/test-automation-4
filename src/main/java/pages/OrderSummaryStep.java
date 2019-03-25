package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryStep extends BaseStep {


    private By cartSummaryLocator = By.id("cart_summary");

    public <T extends BaseStep> T proceed(Class<T> clazz) {
        super.proceed();
        if(singOutLink.isDisplayed()) return clazz.cast(new AddressStep(driver));
        return clazz.cast(new SingInStep(driver));
    }


    public OrderSummaryStep(WebDriver driver) {
        super(driver);
        $(cartSummaryLocator);
    }
}
