package lesson08.b_add_basePage_and_simple_api;

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
        landingPage.visit();

        landingPage.searchFor(query1);
        assertThat(textToBePresentInElementLocated(landingPage.firstTipLocator, query1));

        landingPage.searchFor(query2);
        assertThat(textToBePresentInElementLocated(landingPage.firstTipLocator, query2), 15l);
    }
}