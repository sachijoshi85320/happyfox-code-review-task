package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

    @FindBy(id = "profileLink")
    WebElement profileLnk;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePage() {
        if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
            throw new IllegalStateException("Not on the home page");
        }
    }

    public void navigateToProfile() {
        profileLnk.click();
    }
}