package runners;


import helpers.BaseClass;
import helpers.CalendarHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/"
        , glue = {"stepDefinition"}
        , plugin = {"pretty"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"}
        , tags = "@login_02"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        BaseClass.runnerName = this.getClass().getSimpleName();
        BaseClass.reportFile = CalendarHelper.getTime() + "_" + BaseClass.runnerName + ".html";
        getTags();
    }

    @AfterSuite
    public void generateReport() throws Exception {
        System.out.println("Report generation started, reportFile: " + BaseClass.reportFile);
    }


    private void getTags() {
        if (System.getProperty("cucumber.filter.tags") != null && !System.getProperty("cucumber.filter.tags").isEmpty()) {
            BaseClass.optionsTags = System.getProperty("cucumber.filter.tags").split("or");
        } else {
            CucumberOptions co = this.getClass().getAnnotation(CucumberOptions.class);
            BaseClass.optionsTags = co.tags().split("or");
        }
    }

}
