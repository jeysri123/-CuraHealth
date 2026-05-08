package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.LoginPage;

public class AppointmentTest extends BaseTest {

    @Test
    public void bookAppointmentTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("Tokyo CURA Healthcare Center", "20/05/2026", "General Checkup");
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getFacility(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(confirmationPage.getHospitalReadmission(), "Yes");
        Assert.assertEquals(confirmationPage.getVisitDate(), "20/05/2026");
    }

    @Test
    public void pastDateValidationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("Hongkong CURA Healthcare Center", "25/05/2020", "Second Appointment");
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("Appointment Confirmation"));
    }
    @Test
    public void verifyConfirmationDetailsTest() {

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
                "General Checkup");

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmationPage.getFacility(),
                "Tokyo CURA Healthcare Center");

        Assert.assertEquals(
                confirmationPage.getVisitDate(),
                "20/05/2026");
    }
    @Test
    public void hospitalAdmissionCheckboxTest() {

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
                "Hospital Admission Test");

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmationPage.getHospitalReadmission(),
                "Yes");
    }
    @Test
    public void longCommentValidationTest() {

        String longComment =
                "India is a rich,ake the country incredible. ures and a rich heritage. It is the seventh-largest country by area and the second-most populous country globally. The peacock is India’s national bird, and the Bengal tiger is the country’s national animal. The national song is named Vande Matram (written by Bankimchandra Chatterji). The Indian national song was first performed at the Indian National Congress in 1896. ‘Jana Gana Mana,’ India’s national anthem, is sung in 52 seconds. The national flag of India is named Tiranga, which is made up of three colours: saffron, white, and green, with the Ashoka Chakra in navy blue in the centre.";

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
                longComment);

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmationPage.getComment(),
                longComment);
    }

}