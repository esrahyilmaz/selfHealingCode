package stepDefinition;

import helpers.DriverHelper;
import helpers.ReportHelper;
import helpers.WebElementHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Page;

import static org.testng.Assert.assertTrue;


public class CommonSteps {

    Page page = new Page(DriverHelper.getEventDriver());

    @When("Initialize driver")
    public void initializeDriver(DataTable dataTable) {
        dataTable.values().forEach(browser -> DriverHelper.setWebDriver((browser)));
    }

    @When("Initialize driver with event listener")
    public void initDriverWithEventListener(DataTable dataTable) {
        DriverHelper.setDriver(dataTable.values().get(0));
        DriverHelper.setEventDriver();
    }

    @When("Open url")
    public void openUrl() {
        page.loadUrl();
        System.out.format("Thread ID - %2d - %s .\n",
                Thread.currentThread().getId(), ReportHelper.getScenario().getName().trim());
    }

    @And("Set record mode as true")
    public void setRecordModeAs() {
        WebElementHelper.setRecordMode();
    }

    @And("Click and verify elements")
    public void clickAndVerifyElements() {
        page.enterText("Input text");
        page.clickOnCheckbox();
        page.clickOnCheckbox2();
        page.isDisplayedHeading();
//        page.clickAndVerifyElements();
//        assertTrue(false);
    }

//    @And("Store element info")
//    public void StoreElementInfo() throws IOException {
//        WebElementHelper.writeMap();
//    }


    @Given("Set Page")
    public void setPage(DataTable dataTable) {
        WebElementHelper.setPage(dataTable.values().get(0));
        if (!WebElementHelper.getRecordMode()) {
            WebElementHelper.retrieveExistingMapFromFile();
        }
    }

    @And("Enter text")
    public void enterText(DataTable dataTable) {
        page.enterText(dataTable.values().get(0));
        Hooks.attachScreenshot(ReportHelper.getScenario());
    }

    @And("Click on checkbox")
    public void clickOnCheckbox() {
        page.clickOnCheckbox();
        Hooks.attachScreenshot(ReportHelper.getScenario());
    }


    @And("Click on checkbox2")
    public void clickOnCheckbox2() {
        page.clickOnCheckbox2();
    }

    @And("Load custom url")
    public void loadCustomUrl(DataTable dataTable) {
        page.loadCustomUrl(dataTable.values().get(0));
    }

    @And("Scenario fail")
    public void scenarioFail() {
        assertTrue(false);
    }

    @And("Wait\\({int})")
    public void wait(int arg0) throws InterruptedException {
        Thread.sleep(1000*arg0);
    }
}