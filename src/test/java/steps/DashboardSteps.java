package steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utils.SetUp;

public class DashboardSteps {
    private final WebDriver chromeDriver = SetUp.getDriver("chrome");
    private final WebDriver firefoxDriver = SetUp.getDriver("firefox");
    DashboardPage dashboardPage1 = new DashboardPage(chromeDriver);
    DashboardPage dashboardPage2 = new DashboardPage(firefoxDriver);

    @And("sort products from most expensive to cheapest")
    public void sortProduct()
    {
        dashboardPage1.sortDropdown();
        dashboardPage2.sortDropdown();
    }

    @And("add product to the cart")
    public void addProductToCart()
    {
        dashboardPage1.addProduct();
        dashboardPage2.addProduct();
    }
}
