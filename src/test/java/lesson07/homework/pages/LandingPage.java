package lesson07.homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LandingPage {

    WebDriver driver;

    String accountPageTitle = "My Store";

    @FindBy (className = "login")
    WebElement singInLink;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
    WebElement firstTip;

    void searchFor(String query){
        searchField.clear();
        searchField.sendKeys(query);
    }

    public LoginPage goToLogIn(){
        singInLink.click();
        return new LoginPage(driver);
    }

    public LandingPage(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        this.driver = driver;
    }
}
