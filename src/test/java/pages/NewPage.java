package pages;

import helpers.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPage {

    public static String projectFolder = System.getProperty("user.dir") + System.getProperty("file.separator");
    private String targetURL = "file:///" + projectFolder + "src/test/resources/WebPages/myPage.html";
    private WebDriver driver;

    public NewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadUrl() {
        loadUrl(targetURL);
    }

    public void loadUrl(String url) {
        BaseClass.loadUrl(driver, url);
    }

    public void clickCheckBox() {
        BaseClass.clickOnElement(driver, By.id("firstcheck"));
        BaseClass.takeScreenshot(driver);
    }

    public void enterTextToInputField(String text) {
        BaseClass.enterTextToElement(driver, By.tagName("input"), text);
    }

}
