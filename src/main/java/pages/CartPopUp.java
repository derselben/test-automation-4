package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPopUp extends BasePage {

    private By productNameLocator = By.id("layer_cart_product_title");
    private By itemAddedPopUp = By.id("layer_cart");

    public String getProductName (){
        return $(productNameLocator).getText();
    }

    public OrderSummaryStep proceed() {
        $(itemAddedPopUp).findElement(By.xpath(".//a")).click();
        return new OrderSummaryStep(driver);
    }

    public CartPopUp(WebDriver driver) {
        super(driver);
    }
}
