package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage {

    By facility =
            By.id("combo_facility");

    By hospitalReadmission =
            By.id("chk_hospotal_readmission");

    By medicare =
            By.id("radio_program_medicare");

    By visitDate =
            By.id("txt_visit_date");

    By comment =
            By.id("txt_comment");

    By bookButton =
            By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver) {

        super(driver);
    }

    public void bookAppointment(
            String facilityName,
            String date,
            String comments) {

        Select select =
                new Select(find(facility));

        select.selectByVisibleText(
                facilityName);

        click(hospitalReadmission);

        click(medicare);

        type(visitDate, date);

        type(comment, comments);

        click(bookButton);
    }
    public boolean isBookButtonDisplayed() {

        return find(bookButton)
                .isDisplayed();
    }
}