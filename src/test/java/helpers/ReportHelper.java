package helpers;

import io.cucumber.java.Scenario;
import pages.Page;

public class ReportHelper extends BaseClass {
    public static Page page;
    public static String scenarioName;

    public static String projectFolder = System.getProperty("user.dir") + System.getProperty("file.separator");
    public static String targetFolder = projectFolder + "target" + System.getProperty("file.separator");
    public static String reportFolder = targetFolder + "reports" + System.getProperty("file.separator");

    public static ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();

    public static synchronized Scenario getScenario() {
        return scenarioThreadLocal.get();
    }

    public static Scenario setScenario(Scenario scenario) {
        scenarioThreadLocal.set(scenario);
        return getScenario();
    }

    public static void customLogInfo(String message) {
        getScenario().log("<span class='m'><b>&#10132; Info : </b>" + message + "<span>");
    }

    public static void customLogError(String message) {
        getScenario().log("<span class='error m'><b>&#10006; </b> " + message + "<span>");
    }

    public static void customLogSuccess(String message) {
        getScenario().log("<span class='success m'>&#10003; " + message + "<span>");
    }

    public static void customLogSeleniumError(String message) {
        getScenario().log("<pre class='seleniumError m'>" + message + "</pre>");
    }

}
