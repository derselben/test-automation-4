package lesson10.homework;

import lesson10.a_add_wd_event_listener.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LandingPage;

import static org.hamcrest.CoreMatchers.containsString;

public class IFrameTest extends BaseTest {

    LandingPage landingPage;

    @Before
    public void openLandingPage(){
        landingPage = new LandingPage(driver);
        landingPage.visit();
    }

    @Test
    public void verifyFacebookLink(){

        // Given

        // When
        landingPage.switchToFacebookBlock();

        // Then
        Assert.assertThat(landingPage.inFrameFacebookScript.getAttribute("innerHTML"), containsString("facebook.com"));
    }
}
