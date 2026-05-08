package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.LoginPage;

public class HistoryTest extends BaseTest {

    @Test
    public void historyPageLoadTest() {
        HomePage landingPage =
                new HomePage(driver);

        landingPage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        HomePage navigationMenu =
                new HomePage(driver);

        navigationMenu.openMenu();
        navigationMenu.clickHistory();

        HistoryPage historyPage =
                new HistoryPage(driver);

        Assert.assertEquals(
                historyPage.getHeading(),
                "History");
    }

    @Test
    public void verifyRecentAppointmentInHistoryTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        AppointmentPage appointmentPage =
                new AppointmentPage(driver);

        appointmentPage.bookAppointment(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "History Check");

        homePage.openMenu();

        homePage.clickHistory();

        HistoryPage historyPage =
                new HistoryPage(driver);

        String historyText =
                driver.getPageSource();

        Assert.assertTrue(
                historyText.contains(
                        "Tokyo CURA Healthcare Center"));

        Assert.assertTrue(
                historyText.contains(
                        "20/05/2026"));
    }
    @Test
    public void verifyHistoryTableHeadersTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        AppointmentPage appointmentPage =
                new AppointmentPage(driver);

        appointmentPage.bookAppointment(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "Header Test");

        homePage.openMenu();

        homePage.clickHistory();

        String historyText =
                driver.findElement(
                                org.openqa.selenium.By.tagName("body"))
                        .getText();

        Assert.assertTrue(
                historyText.contains(
                        "Tokyo CURA Healthcare Center"));

        Assert.assertTrue(
                historyText.contains(
                        "20/05/2026"));
    }
    @Test
    public void multipleAppointmentsTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        AppointmentPage appointmentPage =
                new AppointmentPage(driver);

        appointmentPage.bookAppointment(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "First Appointment");

        driver.get(
                "https://katalon-demo-cura.herokuapp.com/#appointment");

        appointmentPage.bookAppointment(
                "Hongkong CURA Healthcare Center",
                "25/05/2026",
                "Second Appointment");

        homePage.openMenu();

        homePage.clickHistory();

        String historyText =
                driver.findElement(
                                org.openqa.selenium.By.tagName("body"))
                        .getText();

        Assert.assertTrue(
                historyText.contains(
                        "Tokyo CURA Healthcare Center"));

        Assert.assertTrue(
                historyText.contains(
                        "Hongkong CURA Healthcare Center"));

        Assert.assertTrue(
                historyText.contains(
                        "20/05/2026"));

        Assert.assertTrue(
                historyText.contains(
                        "25/05/2026"));
    }
    @Test
    public void verifyAppointmentsSortedByDateTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        AppointmentPage appointmentPage =
                new AppointmentPage(driver);

        appointmentPage.bookAppointment(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "First Appointment");

        driver.get(
                "https://katalon-demo-cura.herokuapp.com/#appointment");

        appointmentPage.bookAppointment(
                "Hongkong CURA Healthcare Center",
                "25/05/2026",
                "Second Appointment");

        homePage.openMenu();

        homePage.clickHistory();

        String historyText =
                driver.findElement(
                                org.openqa.selenium.By.tagName("body"))
                        .getText();

        int firstDate =
                historyText.indexOf("25/05/2026");

        int secondDate =
                historyText.indexOf("20/05/2026");

        Assert.assertTrue(
                firstDate < secondDate);
    }
    @Test
    public void emptyDateValidationTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.clickMakeAppointment();

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "John Doe",
                "ThisIsNotAPassword");

        AppointmentPage appointmentPage =
                new AppointmentPage(driver);

        appointmentPage.bookAppointment(
                "Tokyo CURA Healthcare Center",
                "",
                "Date Empty Test");

        String pageSource =
                driver.getPageSource();

        Assert.assertFalse(
                pageSource.contains(
                        "Appointment Confirmation"));
    }
}
