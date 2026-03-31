package stepdefinitions;
//tp2
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginStepTest extends TestBase {

    private LoginPage loginPage;

    @BeforeEach
    public void initPage() {
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void testLoginSuccess() {
        loginPage.openLoginPage();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        String actualMessage = loginPage.getSuccessMessage();
        Assertions.assertTrue(actualMessage.contains("You logged into a secure area!"),
                "Expected success message to contain the secure area login text.");
    }
}
