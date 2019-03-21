package lesson10.a_add_wd_event_listener;

import lesson07.homework.pages.AccountPage;
import lesson07.homework.pages.LoginPage;
import lesson07.homework.pages.LandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileDownloader;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest extends BaseTest {

	@Test
	public void verifyFirstTip() throws IOException, URISyntaxException {

//        Alert alert = new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
//        alert.authenticateUsing(new UserAndPassword("username", "password"));
        LoginPage loginPage = new LandingPage(driver).goToLogIn();

        loginPage
                .enterUsername("derselben@gmail.com")
                .enterPassword("qwerty123")
                .clickSubmitLoginBtn();
        AccountPage accountPage = new AccountPage(driver);

        accountPage.openOrders();

        FileDownloader fileDownloader = new FileDownloader(driver);
        fileDownloader.setURI($("//*[@id=\"order-list\"]/tbody/tr/td[6]/a").getAttribute("href"));
        File file = fileDownloader.downloadFile();


//		// Given
//		final String query1 = "Dress";
//		final String query2 = "T-shirt";
//		final LandingPage landingPage = new LandingPage(driver);
//		landingPage.visit();
//		landingPage.searchFor(query1);
//		final String oldTipText = landingPage.getFirstTipText();
//		// When
//		landingPage.searchFor(query2, oldTipText);
//		// Then
//		final String newTipText = landingPage.getFirstTipText();
//		assertAll(() -> Assert.assertThat(newTipText, containsString(query2 + "")),
//				() -> Assert.assertThat(newTipText, containsString(query2)),
//				() -> Assert.assertThat(newTipText, containsString(query2 + "")));
	}
}