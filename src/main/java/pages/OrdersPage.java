package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrdersPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor)driver;

    private By ordersListLocator = By.xpath("//*[@id=\"order-list\"]//tr[contains(@class,'item')]");
    private By submitReorderLocator = By.id("submitReorder");
    private By orderItemsLocator = By.xpath("//*[@id=\"order-detail-content\"]/table/tbody/tr");

    public OrdersPage visit(){
        open("http://automationpractice.com/index.php?controller=history");
        $(ordersListLocator);
        return this;
    }

    public List<WebElement> getOrdersList(){
        return $$(ordersListLocator);
    }

    public OrdersPage openNthOrederDetails(int n){
        n--;
        getOrdersList().get(n).findElement(By.xpath(".//td/a/span")).click();
        $(submitReorderLocator);
        return this;
    }

    public String getNthOrderItemName(int n){
        n--;
        js.executeScript("arguments[0].scrollIntoView(true)", $(orderItemsLocator));
        return $$(orderItemsLocator).get(n).findElement(By.xpath("//td[2]/label")).getText();
    }

    public OrdersPage(WebDriver driver) {
        super(driver);
    }
}
