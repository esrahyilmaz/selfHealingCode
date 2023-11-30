package helpers;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.testng.Assert.fail;


public class BaseClass {
    public static final Logger log = Logger.getLogger(BaseClass.class.getName());
    public static String projectFolder = System.getProperty("user.dir") + System.getProperty("file.separator");
    public static EventFiringWebDriver eventFiringWebDriver;
    public static String testName;
    // for test report

    public static String screenshotPath = ReportHelper.reportFolder + "screenshots/screenshot.png";
    public static String reportFile;
    public static String runnerName;
    public static String[] optionsTags;
    public static String env;
    public static String browser;
    static String targetURL = "file:///" + projectFolder + "src/test/resources/WebPages/myPage.html";

    /**
     * @return env info from system variable or property file
     */
    public static String getEnv() {
        if (System.getProperty("env") != null) {
            env = System.getProperty("env");
            log.info("Environment " + env + " selected from command line");
        } else {
            env = PropertyHelper.getProperty("env");
            log.info("Environment " + env + " selected from property file");
        }
        return env;
    }

    public static String getBrowser() {
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
            log.info("Environment " + browser + " selected from command line");
        } else {
            env = PropertyHelper.getProperty("browser");
            log.info("Environment " + browser + " selected from property file");
        }
        return env;
    }

    /**
     * Create custom log in spark and cucumber report
     *
     * @param message
     */
    public void customLog(String message) {
        ReportHelper.customLogInfo(message);
    }

    public static void loadUrl(WebDriver driver, String url) {
        try {
            driver.get(url);
            log.info("Open URL: " + url);
            ReportHelper.customLogSuccess("Open URL: " + url);
        } catch (Exception e) {
            log.error("Unable to open URL:" + url + " by error: " + e);
            fail();
        }

    }

    /**
     * Waiting, should be restricted to use
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            log.info("Waited for " + seconds + " seconds");

        } catch (Exception e) {
            log.warn("Failed - Error in function wait(): " + e.getMessage());
        }
    }

    public static boolean isExistElement(WebDriver driver, By by, int sec) {
        boolean exist = false;

        for (int i = 0; i < sec; i++) {
            try {
                WebElement element = driver.findElement(by);
                if (element != null) {
                    exist = true;
                    log.info("Element " + by + " exists");
                    break;
                } else {
                    log.info("Element " + by + " not exists");
                    wait(1);
                }
            } catch (Exception e) {
                log.info("Element: " + by + " not found");
                wait(1);
            }
        }
        return exist;
    }

    public boolean isExistElement(WebDriver driver, By by) {
        return isExistElement(driver, by, 1);
    }

    public static boolean isDisplayed(WebDriver driver, By by, int sec) {
        boolean displayed = false;
        for (int i = 0; i < sec; i++) {
            try {
                WebElement element = driver.findElement(by);
                if (element != null && element.isDisplayed()) {
                    displayed = true;
                    log.info("Element: " + by + " displayed");
                    break;
                } else {
                    log.info("Element: " + by + " not displayed");
                    wait(1);
                }
            } catch (Exception e) {
                log.info("Element: " + by + " not found");
                wait(1);
            }
        }
        return displayed;
    }

    public boolean isDisplayed(WebDriver driver, By by) {
        return isDisplayed(driver, by, 1);
    }

    public static void clickOnElement(WebDriver driver, By by) {
        try {
            driver.findElement(by).click();
            log.info("Click on element: " + by);
            ReportHelper.customLogSuccess("Click on element: " + by);
        } catch (NoSuchElementException e) {
            log.error("Unable click on element: " + by + " cause of element not found: " + e);
            By altBy = WebElementHelper.getAlternativeLocators(DriverHelper.getEventDriver(), by);
            clickOnElement(driver, altBy);
        } catch (Exception e) {
            log.error("Unable click on element: " + by + " cause of error: " + e);
            fail();
        }
    }

    public static void enterTextToElement(WebDriver driver, By by, String text) {
        try {
            WebElement ele = driver.findElement(by);
            ele.clear();
            ele.sendKeys(text);
            log.info("Enter text: " + text + " to element: " + by);
            ReportHelper.customLogSuccess("Enter text: " + text + " to element: " + by);
        } catch (NoSuchElementException e) {
            log.error("Unable to enter text to element:" + by + " cause of element not found: " + e);
            By altBy = WebElementHelper.getAlternativeLocators(DriverHelper.getEventDriver(), by);
            enterTextToElement(driver, altBy, text);
        } catch (Exception e) {
            log.error("Unable to enter text to element:" + by + " cause of error: " + e);
            fail();
        }
    }

    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            ReportHelper.getScenario().attach(screenshot, "image/png", "Screenshot");
            log.info("Screenshot attached to report ");
        } catch (Exception e) {
            log.error("Unable to attach screenshot: " + e);
        }
    }

    public static void setAttribute(WebDriver driver, By by, String attrName, String attrValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = driver.findElement(by);
        js.executeScript("arguments[0].setAttribute('" + attrName + "', '" + attrValue + "')", ele);
    }
}
