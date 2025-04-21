package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
	WebElement userNameTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "loginButton")
    WebElement loginBtn;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLnk;

    public LoginPage(WebDriver driver) {
        super(driver);
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