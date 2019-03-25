package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentStep extends BaseStep {

    private By payByBankWireLocator = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");

    public ConfirmPaymentStep payByBankWire(){
        $(payByBankWireLocator).click();
        return new ConfirmPaymentStep(driver);
    }

    public PaymentStep(WebDriver driver) {
        super(driver);
    }
}
