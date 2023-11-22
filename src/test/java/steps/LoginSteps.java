package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.SetUp;

public class LoginSteps {
    private final WebDriver chromeDriver = SetUp.getDriver("chrome");
    private final WebDriver firefoxDriver = SetUp.getDriver("firefox");
    private final LoginPage loginPage1 = new LoginPage(chromeDriver);
    private final LoginPage loginPage2 = new LoginPage(firefoxDriver);

    @When("^type the username (.*) with password (.*)$")
    public void typeCredentials(String user, String password) {
        loginPage1.writeCredentials(user, password);
        loginPage2.writeCredentials(user, password);
    }

    @And("^press the login button$")
    public void pressLoginButton() {
        loginPage1.clickLoginButton();
        loginPage2.clickLoginButton();
    }

    @Then("^verify that the user successfully logged in$")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage1.getValidLoginElements().get("cart_icon"));
        Assert.assertTrue(loginPage1.getValidLoginElements().get("drop_down"));
        Assert.assertTrue(loginPage2.getValidLoginElements().get("cart_icon"));
        Assert.assertTrue(loginPage2.getValidLoginElements().get("drop_down"));
    }

    @Then("^verify user login was not successful$")
    public void invalidLogin() {
        Assert.assertTrue(loginPage1.getInvalidLoginElements().get("login_button"));
        Assert.assertTrue(loginPage1.getInvalidLoginElements().get("error_message"));
        Assert.assertEquals(loginPage1.getErrorMessageText(), "Epic sadface: Username and password do not match " +
                "any user in this service");
        Assert.assertTrue(loginPage2.getInvalidLoginElements().get("login_button"));
        Assert.assertTrue(loginPage2.getInvalidLoginElements().get("error_message"));
        Assert.assertEquals(loginPage2.getErrorMessageText(), "Epic sadface: Username and password do not match " +
                "any user in this service");
        //System.out.print("Element present: " + loginPage.getValidLoginElements().get("cart_icon"));
        //Assert.assertFalse("Cart icon not present", loginPage.getPresentElements().get("cart_icon"));
        //Assert.assertFalse("Dropdown not present", loginPage.getPresentElements().get("drop_down"));
    }
}
