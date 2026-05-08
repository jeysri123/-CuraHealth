package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends BasePage {

    By historyHeading =
            By.xpath("//h2");
    By table =
            By.tagName("table");
    public HistoryPage(WebDriver driver) {

        super(driver);
    }

    public String getHeading() {

        return find(historyHeading)
                .getText();
    }
    public String getTableText() {

        return find(table)
                .getText();
    }
}