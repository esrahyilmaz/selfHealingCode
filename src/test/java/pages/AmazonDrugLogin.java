package pages;

import helpers.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class AmazonDrugLogin extends BaseClass {

    private By clientId = By.name("accountnumber");
    private By loginBtn = By.id("login-button");
    private By fUser = By.name("Sign in name");
    private By fPass = By.name("Password");
    private By btnSignIn = By.xpath("//button[@id='Next']");
    //    private By btnSignIn = By.id("Next");
    private By btnMenu = By.id("menu-btn");

    private EventFiringWebDriver eventFiringWebDriver;

    public AmazonDrugLogin(EventFiringWebDriver driver) {
        this.eventFiringWebDriver = driver;
    }

    public void openAmazonDrugTestUrl(String url) {
        loadUrl(eventFiringWebDriver, url);
    }

    public void clickLoginButton() {
        isDisplayed(eventFiringWebDriver, loginBtn, 10);
        clickOnElement(eventFiringWebDriver, loginBtn);
        wait(3);
    }

    public void enterUserName(String userName) {
        isDisplayed(eventFiringWebDriver, fUser, 10);
        setAttribute(eventFiringWebDriver, fUser, "name", "Sign In Name");
//        if (isDisplayed(eventFiringWebDriver, fUser))
//            enterTextToElement(eventFiringWebDriver, fUser, userName);
//        else
        enterTextToElement(eventFiringWebDriver, fUser, userName);
    }

    public void enterUserPassword(String pass) {
        setAttribute(eventFiringWebDriver, fPass, "name", "password");
//        if (isDisplayed(eventFiringWebDriver, fPass))
//            enterTextToElement(eventFiringWebDriver, fPass, pass);
//        else
        enterTextToElement(eventFiringWebDriver, fPass, pass);

    }

    public void clickSignInButton() {
        clickOnElement(eventFiringWebDriver, btnSignIn);
    }
}
