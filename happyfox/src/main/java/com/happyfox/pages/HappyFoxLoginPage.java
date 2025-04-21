package com.happyfox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.happyfox.base.BasePage;

public class HappyFoxLoginPage extends BasePage {

    @FindBy(id = "username")
	WebElement userNameTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "loginButton")
    WebElement loginBtn;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLnk;

    public HappyFoxLoginPage(WebDriver driver) {
        super();
    }

    public void login(String username, String password) {
        userNameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }

    public void forgotPassword() {
        forgotPasswordLnk.click();
    }
}
