package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("appointment"));
    }

    @Test
    public void logoutTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        homePage.openMenu();

        homePage.clickLogout();

        String pageSource =
                driver.getPageSource();

        Assert.assertTrue(
                pageSource.contains(
                        "CURA Healthcare Service"));
    }
}