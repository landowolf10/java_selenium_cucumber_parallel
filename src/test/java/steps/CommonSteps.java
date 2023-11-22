package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.SetUp;
import utils.TakeScreenShot;

public class CommonSteps {
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private LoginPage loginPage1;
    private LoginPage loginPage2;
    private TakeScreenShot screenShot1;
    private TakeScreenShot screenShot2;

    @Before
    public void setUp() {
        chromeDriver = SetUp.getDriver("chrome");
        firefoxDriver = SetUp.getDriver("firefox");
        loginPage1 = new LoginPage(chromeDriver);
        loginPage2 = new LoginPage(firefoxDriver);
        screenShot1 = new TakeScreenShot(chromeDriver);
        screenShot2 = new TakeScreenShot(firefoxDriver);
    }

    @Given("^I navigate to SauceLab demo page")
    public void navigate() {
        loginPage1.navigateToSauceLab();
        loginPage2.navigateToSauceLab();
    }

    @After
    public void closeDriver() {
        SetUp.quitDriver("chrome");
        SetUp.quitDriver("firefox");
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) {
        screenShot1.takeScreenShot(scenario);
        screenShot2.takeScreenShot(scenario);
    }
}
