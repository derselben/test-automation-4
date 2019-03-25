package lesson10.homework;

import lesson10.a_add_wd_event_listener.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.LandingPage;

public class PurchaseTest extends BaseTest {

    @Before
    public void logIn (){

        new LandingPage(driver)
                .visit()
                .goToLogIn()
                .logIn( "derselben@gmail.com",
                        "qwerty123");
    }

    @Test
    public void verifyOrder(){
        new LandingPage(driver)
                .searchFor("Dress")
                .submitSearch()
                .hoverOnNthSearchResultItemAndAddToCard(1);
    }
}

