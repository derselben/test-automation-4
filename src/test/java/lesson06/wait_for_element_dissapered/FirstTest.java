package lesson06.wait_for_element_dissapered;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyFirstTip() throws TimeoutException {
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(), containsString("Dress"));

        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");

        waitForElementDissapering(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"),5000L);
        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(), containsString("T-shirt"));
    }

    void waitForElementDissapering(By by, long timeout) throws TimeoutException {

        long initialTime = System.currentTimeMillis();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        boolean hp = false;
        while (true) {
            if (System.currentTimeMillis() - initialTime > timeout) {
                hp = true;
                break;
            }
            if (driver.findElements(by).isEmpty()) {
                 break;
            }
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            if (hp)
                throw new TimeoutException("Element is still present");
        }
    }
}