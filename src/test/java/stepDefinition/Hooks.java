package stepDefinition;

import helpers.BaseClass;
import helpers.DriverHelper;
import helpers.ReportHelper;
import helpers.WebElementHelper;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static helpers.DriverHelper.getEventDriver;
import static helpers.ReportHelper.*;
import static helpers.WebElementHelper.setRecordMode;


public class Hooks {


    private DriverHelper driverHelper;
    public static WebDriver driver;

    public Hooks() {
    }

    @BeforeAll
    public static void beforeAll() {
        getEnv();
        log.info("Runner name: " + runnerName);

    }

    @AfterAll
    public static void afterAll() throws IOException {
        log.info("After ALL");
        DriverHelper.quit();
    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        setRecordMode();
        ReportHelper.setScenario(scenario);

        driverHelper = new DriverHelper();
        driver = driverHelper.setEventDriver();
    }

    @After()
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            attachScreenshot(scenario);
        }
        if (getEventDriver() != null) {
            getEventDriver().quit();
        }
        WebElementHelper.writeMap();
    }

    public static void attachScreenshot(Scenario scenario) {
        try {
            WebElementHelper.takeScreenshot(getEventDriver());
        } catch (Exception e) {
            log.warn("Unable to attach screenshot: " + e);
        }
    }


    @BeforeStep
    public void beforeStep(Scenario scenario) throws ClassNotFoundException {

    }

    @AfterStep
    public void afterStep(Scenario scenario) throws ClassNotFoundException {

    }


}