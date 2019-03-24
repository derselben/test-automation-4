package lesson07.homework.pages;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;

import static org.hamcrest.CoreMatchers.*;


public class TestClass {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
    }

    @Before
    public void openLoginPage(){
        new LandingPage(driver).goToLogIn();
    }

    @After
    public void logOutIfNeeded(){
        if (!driver.getTitle().equals(LoginPage.loginPageTitle)){
        new AccountPage(driver).signOut();
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyLoginViaMethodsChain(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("derselben@gmail.com")
                .enterPassword("qwerty123")
                .clickSubmitLoginBtn();

        Assert.assertThat(driver.getTitle(), is(AccountPage.accountPageTitle));
    }

    @Test
    public void verifyLoginViaLogInMethod(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .logIn( "derselben@gmail.com",
                        "qwerty123");

        Assert.assertThat(driver.getTitle(), is(AccountPage.accountPageTitle));
    }

    @Test
    public void verifyLogOut(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .logIn( "derselben@gmail.com",
                        "qwerty123")
                .signOut();

        Assert.assertThat(driver.getTitle(), is(LoginPage.loginPageTitle));
    }
}
