package stepdefinitions;

import org.junit.jupiter.api.Assertions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormPage;

public class FormStep {

    private FormPage formPage;

    private FormPage getFormPage() {
        if (formPage == null) {
            formPage = new FormPage(TestBase.getDriver());
        }
        return formPage;
    }

    @Given("the user is on the form page")
    public void userIsOnFormPage() {
        getFormPage().openFormPage();
    }

    @When("the user fills the form")
    public void userFillsTheForm() {
        getFormPage().enterText("Amina");
        getFormPage().enterPassword("bonjour");
        getFormPage().enterTextArea("THIS IS FOR TEST ...");
    }

    @And("the user interacts with form elements")
    public void userInteractsWithFormElements() {
        getFormPage().clickLinkAndReturn();
        getFormPage().selectDropdownByIndex(1);
        getFormPage().enterDatalist("San Francisco");
        getFormPage().uploadFile("assets/image.png");

        getFormPage().uncheckCheckbox1();
        getFormPage().checkCheckbox2();
        getFormPage().selectRadioButton();

        getFormPage().setColor("#ff0000");
        getFormPage().setDate("2026-02-24");
    }

    @And("submits the form")
    public void submitsTheForm() {
        getFormPage().submitForm();
    }

    @Then("the user should see a success message")
    public void userShouldSeeSuccessMessage() {
        String message = getFormPage().getSuccessMessage();
        Assertions.assertTrue(message.contains("Received!"),
                "Expected confirmation message to contain 'Received!'");
    }
}