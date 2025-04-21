package com.happyfox.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.happyfox.base.BasePage;
import com.happyfox.pages.HappyFoxLoginPage;
import com.happyfox.pages.HomePage;

public class TestCase102_happyFoxLogin extends BasePage {
    HappyFoxLoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new HappyFoxLoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyLoginFunctionality() {
        driver.get("https://www.happyfox.com");
        loginPage.login("username", "password");
        Assert.assertEquals(homePage.verifyHomePage(), "Home Page is not displayed.");
        homePage.navigateToProfile();
    }
}
