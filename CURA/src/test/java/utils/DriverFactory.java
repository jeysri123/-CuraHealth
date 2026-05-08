package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments(
                    "--disable-save-password-bubble");

            options.addArguments(
                    "--disable-notifications");

            options.addArguments(
                    "--disable-popup-blocking");

            options.addArguments(
                    "--incognito");

            options.addArguments(
                    "--disable-blink-features=AutomationControlled");

            options.setExperimentalOption(
                    "prefs",
                    new java.util.HashMap<String, Object>() {{
                        put("credentials_enable_service", false);
                        put("profile.password_manager_enabled", false);
                    }});

            driver =
                    new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.get(
                    ConfigReader.getBaseUrl());
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}