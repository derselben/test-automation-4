package lesson08.a_add_base_test;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class FirstTest extends BaseTest {
    @Ignore
    @Test
    public void verifyFirstTip(){
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(driver);

        landingPage.searchFor(query1);
        asssertThat(textToBePresentInElementLocated(landingPage.firstTipLocator, query1));

        landingPage.searchFor(query1);
        asssertThat(textToBePresentInElementLocated(landingPage.firstTipLocator, query2));
    }

    void asssertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(driver,10l))
                .until(condition);
    }

    void asssertThat(ExpectedCondition<Boolean> condition, long timeout) {
        (new WebDriverWait(driver, timeout))
                .until(condition);
    }
}