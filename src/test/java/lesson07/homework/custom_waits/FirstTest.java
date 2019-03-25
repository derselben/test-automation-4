package lesson07.homework.custom_waits;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Ignore
    @Test
    public void verifyNthTipToBeWithQueriedText(){

        String query = "Dress";
        LandingPage landingPage = new LandingPage();
        landingPage.visit();

        landingPage.searchFor(query);

        (new WebDriverWait(driver,10))
                .until(CustomExpectedConditions
                        .listNthElementHasText(landingPage.tipsLocator,2,query));
    }
    @Ignore
    @Test
    public void verifyPageWasLoaded(){

        LandingPage landingPage = new LandingPage();
        landingPage.visit();

        (new WebDriverWait(driver,10))
                .until(CustomExpectedConditions
                        .pageIsLoaded(landingPage.url,landingPage.title));
    }
    @Ignore
    @Test
    public void verifyElementDisappeared(){

        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage();
        landingPage.visit();

        landingPage.searchFor(query1);

        (new WebDriverWait(driver,10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(landingPage.firstTipLocator));

        landingPage.searchFor(query2);
        (new WebDriverWait(driver, 10))
                .until(CustomExpectedConditions
                        .stalenessOfElement(landingPage.$(landingPage.firstTipLocator)));
    }

    class LandingPage {

        // Don't do so
        // WebElement searchField = driver.findElement(By.id("search_query_top"));

        String title = "My Store";
        String url = "http://automationpractice.com/index.php";

        By searchFieldLocator = By.id("search_query_top");
        By tipsLocator = By.xpath("//*[@id=\"index\"]/div[2]/ul/li");
        By firstTipLocator = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

        void searchFor(String query){
            $(searchFieldLocator).clear();
            $(searchFieldLocator).sendKeys(query);
        }

        void visit(){
            driver.get(url);
        }

        WebElement $(By locator) {
            return driver.findElement(locator);
        }
    }
}