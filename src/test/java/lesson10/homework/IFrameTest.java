package lesson10.homework;

import lesson10.a_add_wd_event_listener.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LandingPage;

public class IFrameTest extends BaseTest {

    @Before
    public void openLandingPage(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.visit();
    }

    @Test
    public void verifyFacebookLink(){

        JavascriptExecutor js = (JavascriptExecutor)driver;

        String name = driver.findElement(By.xpath("//*[@id=\"facebook_block\"]/div/div/span/iframe")).getAttribute("name");

        driver.switchTo().frame(name);

        System.out.println(name);
    }
}
