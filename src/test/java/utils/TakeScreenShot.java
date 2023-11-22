package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot extends BasePage{
    public TakeScreenShot(WebDriver driver) {
        super(driver);
    }

    public void takeScreenShot(Scenario scenario)
    {
        //BasePage basePage = new BasePage(Clients.browser);

        if (scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}
