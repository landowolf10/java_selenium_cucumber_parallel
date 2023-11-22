package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import utils.SetUp;

public class CheckoutSteps
{
    private final WebDriver chromeDriver = SetUp.getDriver("chrome");
    private final WebDriver firefoxDriver = SetUp.getDriver("firefox");
    CheckoutPage checkout1 = new CheckoutPage(chromeDriver);
    CheckoutPage checkout2 = new CheckoutPage(firefoxDriver);

    @And("checkout information")
    public void checkoutInfo()
    {
        checkout1.proceedWithCheckout();
        Assert.assertEquals(checkout1.getItemsSum(), checkout1.getSubtotal());
        checkout1.clickFinishButton();
        checkout2.proceedWithCheckout();
        Assert.assertEquals(checkout2.getItemsSum(), checkout2.getSubtotal());
        checkout2.clickFinishButton();
    }

    @Then("finish checkout")
    public void finishCheckout()
    {
        Assert.assertTrue(checkout1.getCheckoutElements().get("order_title"));
        Assert.assertTrue(checkout1.getCheckoutElements().get("order_message"));
        Assert.assertTrue(checkout1.getCheckoutElements().get("home_button"));
        Assert.assertTrue(checkout2.getCheckoutElements().get("order_title"));
        Assert.assertTrue(checkout2.getCheckoutElements().get("order_message"));
        Assert.assertTrue(checkout2.getCheckoutElements().get("home_button"));
    }
}