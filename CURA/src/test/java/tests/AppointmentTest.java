package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;

    public class AppointmentTest extends BaseTest {
        @Test
        public void bookAppointmentTest() {

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
                    "15/01/1999",
                    "General Checkup");
        }
        }
