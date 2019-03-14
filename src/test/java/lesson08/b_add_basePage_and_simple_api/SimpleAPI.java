package lesson08.b_add_basePage_and_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class SimpleAPI {

    abstract WebDriver getDriver();

    protected void open(String url){
        getDriver().get(url);
    }

    protected WebElement $(By locator) {
        return waitFor(visibilityOfElementLocated(locator));
    }

    protected WebElement $(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        return waitFor(condition.apply(locator));
    }

    protected WebElement $(By locator, Conditions condition) {
        return waitFor(condition.getCondition().apply(locator));
    }

    protected WebElement $(String xpath) {
        return $(By.xpath(xpath));
    }

    protected List<WebElement> $$(By locator) {
        return waitFor(visibilityOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> $$(String xpath) {
        return $$(By.xpath(xpath));
    }

    <T> T waitFor(ExpectedCondition<T> condition, long timeout){
        return (new WebDriverWait(getDriver(),timeout)).until(condition);
    }

    <T> T waitFor(ExpectedCondition<T> condition){
        return waitFor(condition, 15l);
    }
}
