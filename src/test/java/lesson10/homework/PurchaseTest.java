package lesson10.homework;

import lesson10.a_add_wd_event_listener.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;

public class PurchaseTest extends BaseTest {

    LandingPage landingPage;

    @Before
    public void logIn (){

        landingPage = new LandingPage(driver);
        landingPage
                .visit()
                .goToLogIn()
                .logIn( "derselben@gmail.com",
                        "qwerty123");
    }

    @After
    public void logOutAfterTest(){
        landingPage.signOut();
    }

    @Test
    public void verifyThatOrderIsSameAsWasCheckedOut(){

        landingPage
                .searchFor("Dress")
                .submitSearch();

        int itemNumber = new Random().nextInt(landingPage.quantityOfSearchedItems);

        CartPopUp cartPopUp = landingPage
                .hoverOnNthSearchResultItemAndAddToCard(itemNumber);

        String addedProductName = cartPopUp.getProductName();

        cartPopUp
                .proceed()
                .proceed(AddressStep.class)
                .proceed()
                .iAgree()
                .proceed()
                .payByBankWire()
                .confirmPayment();

        String firstItemNameOfLastOrder =  new OrdersPage(driver).visit()
                .openNthOrderDetails(1)
                .getNthOrderItemName(1);

        Assert.assertThat(firstItemNameOfLastOrder, containsString(addedProductName));
    }
}

