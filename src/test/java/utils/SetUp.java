package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SetUp {
    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;
    private static String browserName;

    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            browserName = "chrome";

            if (chromeDriver == null) {
                initializeChromeDriver();
            }

            return chromeDriver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            browserName = "firefox";

            if (firefoxDriver == null) {
                initializeFirefoxDriver();
            }

            return firefoxDriver;
        }

        return null;
    }

    public static String getBrowserName() {
        return browserName;
    }

    private static void initializeChromeDriver() {
        String os = System.getProperty("os.name");
        System.setProperty("webdriver.chrome.driver", (os.contains("Windows")) ?
                ConstantData.chromeDriverPathWindows : ConstantData.chromeDriverPathLinux);

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setCapability("browserVersion", "114.0.5735.90");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);
    }

    private static void initializeFirefoxDriver() {
        String os = System.getProperty("os.name");
        System.setProperty("webdriver.gecko.driver", (os.contains("Windows")) ?
                ConstantData.geckoDriverPathWindows : ConstantData.geckoDriverPathLinux);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxDriver = new FirefoxDriver(firefoxOptions);
    }

    public static void quitDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome") && chromeDriver != null) {
            chromeDriver.quit();
            chromeDriver = null;
        } else if (browser.equalsIgnoreCase("firefox") && firefoxDriver != null) {
            firefoxDriver.quit();
            firefoxDriver = null;
        }
    }
}
