package lesson07.homework.custom_waits;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomExpectedConditions {

    static ExpectedCondition <Boolean> listNthElementHasText(By locator, int elNo, String expText){
        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                try{
                    return driver.findElements(locator)
                            .get(elNo)
                            .getText()
                            .contains(expText);
                }catch (IndexOutOfBoundsException e){
                    return false;
                }
            }
        };
    }

    static ExpectedCondition<Boolean> pageIsLoaded(String expUrl, String expTitle){
        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.getTitle().equals(expTitle) && driver.getCurrentUrl().equals(expUrl);
            }
        };
    }

    static ExpectedCondition<Boolean> stalenessOfElement(WebElement elToBeDisappeared){
        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                try{
                    elToBeDisappeared.isDisplayed();
                    return false;
                }catch (StaleElementReferenceException s){
                    return true;
                }
            }
        };
    }
}
