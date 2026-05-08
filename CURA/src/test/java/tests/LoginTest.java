package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        Assert.assertTrue(appointmentPage.isBookButtonDisplayed());
    }
    @Test
    public void invalidLoginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Joh", "ThisIsPassword");
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Login failed! Please ensure the username and password are valid.");
    }

    @Test
    public void logoutTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        homePage.openMenu();
        homePage.clickLogout();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("CURA Healthcare Service"));
    }
    @Test
    public void emptyLoginValidationTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "",
                "");

        String errorMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                errorMessage,
                "Login failed! Please ensure the username and password are valid.");
    }
    @Test
    public void emptyPasswordValidationTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "");

        String errorMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                errorMessage,
                "Login failed! Please ensure the username and password are valid.");
    }
    @Test
    public void emptyUserValidationTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "",
                "ThisIsNotAPassword");

        String errorMessage =
                loginPage.getLoginErrorMessage();

        Assert.assertEquals(
                errorMessage,
                "Login failed! Please ensure the username and password are valid.");
    }
}