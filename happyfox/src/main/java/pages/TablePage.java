package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TablePage extends BasePage {

    @FindBy(xpath = "//table[@id='dataTable']/tbody/tr")
    List<WebElement> rows;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowTxt = row.getText();
            System.out.println("Row " + i + " Text: " + rowTxt);
        }
    }
}