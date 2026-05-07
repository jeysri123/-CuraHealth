package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentPage extends BasePage {
    By visitDate = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By bookButton =
            By.id("btn-book-appointment");
    public AppointmentPage(WebDriver driver) {
        super(driver);
    }
    public void bookAppointment(String date,
                                String comments) {
        type(visitDate, date);
        type(comment, comments);
        click(bookButton);
    }
}