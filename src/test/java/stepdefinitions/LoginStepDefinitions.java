package stepdefinitions;
//tp3
import org.junit.jupiter.api.Assertions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinitions {

    private LoginPage loginPage;

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(TestBase.getDriver());
        }
        return loginPage;
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        getLoginPage().openLoginPage();
    }

    @When("the user enters a username")
    public void userEntersUsername() {
        getLoginPage().enterUsername("aa");
    }

    @And("the user enters a password")
    public void userEntersPassword() {
        getLoginPage().enterPassword("SuperSecretPassword");
    }

    @And("clicks on the login button")
    public void clicksOnLoginButton() {
        getLoginPage().clickLoginButton();
    }

    @Then("the user should see a successful login message")
    public void userShouldSeeSuccessfulLoginMessage() {
        String actualMessage = getLoginPage().getSuccessMessage();
        Assertions.assertTrue(actualMessage.contains("You logged into a secure area!"),
                "Expected successful login message to contain the secure area login text.");
    }
}
