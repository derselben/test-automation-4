package lesson10.a_add_wd_event_listener;

import pages.AccountPage;
import lesson07.homework.pages.LandingPage;
import pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;


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
    @Ignore
    @Test
    public void verifyLoginViaMethodsChain(){

        LoginPage loginPage = new LandingPage(driver).goToLogIn();

        loginPage
                .enterUsername("derselben@gmail.com")
                .enterPassword("qwerty123")
                .clickSubmitLoginBtn();

        Assert.assertThat(driver.getTitle(), is(AccountPage.accountPageTitle));
    }
    @Ignore
    @Test
    public void verifyLoginViaLogInMethod(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .logIn( "derselben@gmail.com",
                        "qwerty123");

        Assert.assertThat(driver.getTitle(), is(AccountPage.accountPageTitle));
    }
    @Ignore
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
