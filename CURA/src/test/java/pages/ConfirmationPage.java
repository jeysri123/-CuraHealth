package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {

    By facility =
            By.id("facility");

    By hospitalReadmission =
            By.id("hospital_readmission");

    By visitDate =
            By.id("visit_date");
    By comment =
            By.id("comment");

    public ConfirmationPage(WebDriver driver) {

        super(driver);
    }

    public String getFacility() {

        return find(facility).getText();
    }

    public String getHospitalReadmission() {

        return find(hospitalReadmission)
                .getText();
    }

    public String getVisitDate() {

        return find(visitDate).getText();
    }
    public String getComment() {

        return find(comment)
                .getText();
    }
}