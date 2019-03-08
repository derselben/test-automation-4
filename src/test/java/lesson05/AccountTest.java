package lesson05;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AccountTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("derselben@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("qwerty123");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @After
    public void goBackToYourAccount(){
            driver.findElement(By.xpath("//*/span[text()[contains(.,'Back')]]/i[@class=\"icon-chevron-left\"]")).click();
    }

    @Test
    public void verifyAvailabilityOf_ORDER_HISTORY_AND_DETAILS(){
        driver.findElement(By.className("icon-list-ol")).click();
        String s = driver.findElement(By.className("page-heading")).getText();

        Assert.assertEquals("Should be equal","ORDER HISTORY",s);
//        driver.findElement(By.linkText("Back to your account.")).click();
    }

    @Test
    public void verifyAvailabilityOf_MY_CREDIT_SLIPS(){
        driver.findElement(By.className("icon-ban-circle")).click();
        String s = driver.findElement(By.className("page-heading")).getText();

        Assert.assertEquals("Should be equal","CREDIT SLIPS",s);
//        driver.findElement(By.linkText("Back to your account.")).click();
    }

    @Test
    public void verifyAvailabilityOf_MY_ADDRESSES(){
        driver.findElement(By.className("icon-building")).click();
        String s = driver.findElement(By.className("page-heading")).getText();

        Assert.assertEquals("Should be equal","MY ADDRESSES",s);
//        driver.findElement(By.linkText("Back to your account.")).click();
    }

    @Test
    public void verifyAvailabilityOf_MY_PERSONAL_INFORMATION(){
        driver.findElement(By.className("icon-user")).click();
        String s = driver.findElement(By.className("page-subheading")).getText();

        Assert.assertEquals("Should be equal","YOUR PERSONAL INFORMATION",s);
//        driver.findElement(By.linkText("Back to your account.")).click();
    }

    @Test
    public void verifyAvailabilityOf_MY_WISHLISTS(){
        driver.findElement(By.className("icon-heart")).click();
        String s = driver.findElement(By.className("page-heading")).getText();

        Assert.assertEquals("Should be equal","MY WISHLISTS",s);
//        driver.findElement(By.linkText("Back to your account.")).click();
    }
}
