package com.happyfox.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.happyfox.utils.TestUtil;

public class BasePage {
    public static WebDriver driver;
    private static final int TIMEOUT = 30;
    public static Properties prop;
    public WebDriverWait wait;
    static {
        prop = new Properties();
        try (FileInputStream ip = new FileInputStream("src/main/java/com/happyfox/config/config.properties")) {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BasePage() {
        if (driver == null) {
            initialization();
        }
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static void initialization() {
        if (driver == null) {
            String browserName = prop.getProperty("browser");
            if (browserName.equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
            } else {
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitUntilElementVisible(WebElement elementPath) {
        try{
            wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementPath));
        }
        catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught: " + e.getMessage());
        }
	}

	public void waitUntilElementIsClickable(WebElement elementPath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(9000));
		wait.until(ExpectedConditions.elementToBeClickable(elementPath));

	}
}
