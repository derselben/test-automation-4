package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseStep extends BasePage {

    public By proceedBtnLocator = By.xpath("//*[@id=\"center_column\"]//span[text()[contains(.,'Proceed to checkout')]]");

//    public  <T extends BaseStep> T  proceed(Class<T> clazz);
    public BaseStep proceed(){
        $(proceedBtnLocator).click();
        return this;
    }

    public BaseStep(WebDriver driver) {
        super(driver);
    }
}
