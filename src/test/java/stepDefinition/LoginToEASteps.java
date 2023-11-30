package stepDefinition;

import helpers.DriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageEA;

import static org.testng.Assert.assertTrue;

public class LoginToEASteps {
    LoginPageEA loginPageEA = new LoginPageEA(DriverHelper.getEventDriver());


    @Given("I open url")
    public void iOpenUrl(DataTable dataTable) throws InterruptedException {
        loginPageEA.openUrl(dataTable.values().get(0));

    }

    @When("Enter Client ID")
    public void enterClientID(DataTable dataTable) {
        loginPageEA.enterClientID(dataTable.values().get(0));
    }

    @And("Enter User ID")
    public void enterUserID(DataTable dataTable) {
        loginPageEA.enterUserID(dataTable.values().get(0));
    }

    @And("Enter Password")
    public void enterPassword(DataTable dataTable) {
        loginPageEA.enterPassword(dataTable.values().get(0));
    }

    @And("Click Sign In button")
    public void clickSignInButton() {
        loginPageEA.clickSignInButton();
    }

    @And("Click Proceed button")
    public void clickProceedButton() {
        loginPageEA.clickProceedButton();
    }

    @And("Enter Answer")
    public void enterAnswer(DataTable dataTable) {
        loginPageEA.enterAnswer(dataTable.values().get(0));
    }

    @And("Click Submit button")
    public void clickSubmitButton() {
        loginPageEA.clickSubmitButton();
    }

    @And("Click I Agree button")
    public void clickIAgreeButton() {
        loginPageEA.clickAgreeBtn();
    }

    @Then("EA Home Page displays")
    public void eaHomePageDisplays() {
        assertTrue(loginPageEA.isDisplayedEaHomePage(), "EA home page not displays");
    }

    @When("Enter User")
    public void enterUser(DataTable dataTable) {
        loginPageEA.enteruser(dataTable.values().get(0));
    }

    @And("Click Login")
    public void clickLogin() {
            loginPageEA.clickLogin();
        }

    @And("Click Continue Button")
    public void clickContinueButton() {
        loginPageEA.clickContinueBtn();
    }
}

