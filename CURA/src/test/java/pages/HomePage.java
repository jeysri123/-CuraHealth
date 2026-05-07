package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By makeAppointment =
            By.id("btn-make-appointment");
    By menuButton = By.id("menu-toggle");

    By loginLink = By.linkText("Login");
    By logoutLink = By.linkText("Logout");
    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void clickMakeAppointment() {

        click(makeAppointment);
    }
    public void openMenu() {

        click(menuButton);
    }

    public void clickLogin() {

        click(loginLink);
    }
    public void clickLogout() {

        click(logoutLink);
    }
}