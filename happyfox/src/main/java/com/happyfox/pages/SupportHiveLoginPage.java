package com.happyfox.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.happyfox.base.BasePage;

public class SupportHiveLoginPage extends BasePage {

    @FindBy(id = "username")
	WebElement userNameTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "btn-submit")
    WebElement loginBtn;

    @FindBy (className = "rc-anchor-invisible-text")
    WebElement captchaTxt;

    public SupportHiveLoginPage(WebDriver driver) {
        super();
    }

    public void login(String username, String password) {

        userNameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }

    public void verifyCaptcha() {
        if (captchaTxt.isDisplayed()) {
            System.out.println("Captcha is displayed");
        } else {
            System.out.println("Captcha is not displayed");
        }
    }
}