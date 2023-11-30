package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.nio.file.Path;

public class DriverHelper extends BaseClass {

    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<EventFiringWebDriver> threadEventDriver = new ThreadLocal<>();

    public static void quit() {
        if (threadEventDriver.get() != null) {
            threadEventDriver.get().quit();
            threadEventDriver.remove();
        }
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

    public static synchronized WebDriver getDriver() {
        return threadDriver.get();
    }

    public static synchronized EventFiringWebDriver setEventDriver() {
        threadEventDriver.set(new EventFiringWebDriver(setDriver(PropertyHelper.getProperty("browser"))));
        setEventListener(getEventDriver());
        return getEventDriver();
    }

    public static synchronized EventFiringWebDriver getEventDriver() {
        return threadEventDriver.get();
    }

    public static void setEventListener(EventFiringWebDriver eventFiringWebDriver) {
        // Create an instance of your event listener class
        EventListener eventListener = new EventListener();

        // Register the event listener
        eventFiringWebDriver.register(eventListener);
    }

    public static WebDriver setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            threadDriver.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadDriver.set(new FirefoxDriver());
        } else {
            log.info("Browser was not specified, set browser chrome");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            threadDriver.set(new ChromeDriver(options));
        }
        threadEventDriver.set(new EventFiringWebDriver(getDriver()));
        log.info("Set browser: " + browser);
        return getDriver();
    }

    /**
     * This method initializes the FirefoxOptions
     *
     * @param profileName
     * @param geckoPath
     * @param firefoxPath
     * @return FirefoxOptions
     */
    public static FirefoxOptions initializeFirefoxOptions(String profileName, Path geckoPath, Path firefoxPath) {
        System.setProperty("webdriver.gecko.driver", geckoPath.toString());
        FirefoxBinary binary = new FirefoxBinary(firefoxPath.toFile());
        FirefoxProfile myProfile = new ProfilesIni().getProfile(profileName);
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile(profileName);
        FirefoxOptions options = new FirefoxOptions().setProfile(myprofile).setBinary(binary);
        return new FirefoxOptions().setProfile(myProfile).setBinary(binary);
    }


    public static void closeEventDriver() {
        getEventDriver().close();
    }

    public static void setWebDriver(String browser) {
        setDriver(browser);
    }
}