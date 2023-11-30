package pages;

import helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Page {

    private EventFiringWebDriver eventFiringWebDriver;

    public Page(EventFiringWebDriver driver) {
        this.eventFiringWebDriver = driver;
    }

    public void clickAndVerifyElements() {
        WebElementHelper.enterText(eventFiringWebDriver, By.tagName("input"), "Input text");
        WebElementHelper.clickElement(eventFiringWebDriver, By.id("firstcheck"));
        WebElementHelper.clickElement(eventFiringWebDriver, By.id("secondcheck"));
        //findElement(By.id("radio"));
        WebElementHelper.existsAndDisplayed(eventFiringWebDriver, By.id("heading"));
    }

    public void loadUrl() {
        WebElementHelper.loadUrl(eventFiringWebDriver);
    }

    public void enterText(String text) {
        WebElementHelper.enterText(eventFiringWebDriver, By.tagName("input"), text);
    }

    public void clickOnCheckbox2() {
        WebElementHelper.clickElement(eventFiringWebDriver, By.id("secondcheck"));
    }

    public void clickOnCheckbox() {
        WebElementHelper.clickElement(eventFiringWebDriver, By.id("firstcheck"));
    }

    public void loadCustomUrl(String url) {
        WebElementHelper.targetURL = url;
        WebElementHelper.loadCustomUrl(eventFiringWebDriver,url);
    }

    public void isDisplayedHeading() {
        WebElementHelper.existsAndDisplayed(eventFiringWebDriver, By.id("heading"));
    }
}
