package stepDefinition;

import helpers.DriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AmazonDrugLogin;

public class AmazonDrugTestSteps {

    AmazonDrugLogin amazonDrugLogin = new AmazonDrugLogin(DriverHelper.getEventDriver());

    @Given("Open Amazon drug test url")
    public void openAmazonDrugTestUrl(DataTable dataTable) {
        amazonDrugLogin.openAmazonDrugTestUrl(dataTable.values().get(0));
    }

    @When("I Click Login Button")
    public void clickLoginButton() {
        amazonDrugLogin.clickLoginButton();
    }

    @When("I Enter User Name")
    public void enterUserName(DataTable dataTable) {
        amazonDrugLogin.enterUserName(dataTable.values().get(0));
    }

    @And("I Enter User Password")
    public void enterUserPassword(DataTable dataTable) {
        amazonDrugLogin.enterUserPassword(dataTable.values().get(0));
    }

    @And("I Click Sign In button")
    public void clickSignInButton() {
        amazonDrugLogin.clickSignInButton();
    }
}
