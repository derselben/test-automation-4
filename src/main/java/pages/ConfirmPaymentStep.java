package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPaymentStep extends BaseStep {

    private By confirmPaymentLocator = By.xpath("//*[@id=\"cart_navigation\"]/button/span");

    public OrderConfirmedStep confirmPayment(){
        $(confirmPaymentLocator).click();
        return new OrderConfirmedStep(driver);
    }

    public ConfirmPaymentStep(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseStep proceed() {
        return null;
    }
}
