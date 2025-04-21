package com.happyfox.pages;

import com.happyfox.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "profileLink")
    WebElement profileLnk;
    
    public HomePage(WebDriver driver) {
        super();
    }

    public boolean verifyHomePage() {
        wait.until(driver -> driver.getCurrentUrl().contains("/home"));
        return driver.getCurrentUrl().equals("https://www.happyfox.com/home");
    }

    public void navigateToProfile() {
        waitUntilElementIsClickable(profileLnk);
        profileLnk.click();
    }
}
