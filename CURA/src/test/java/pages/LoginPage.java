package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By menuButton = By.id("menu-toggle");
    By loginLink = By.linkText("Login");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginButton = By.id("btn-login");
    By loginError = By.cssSelector(".text-danger");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String user,
                      String pass) {
        click(menuButton);
        click(loginLink);
        type(username, user);
        type(password, pass);
        click(loginButton);
    }
    public String getLoginErrorMessage() {
        return find(loginError)
                .getText();
    }
}