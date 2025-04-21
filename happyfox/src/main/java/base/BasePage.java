package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestUtil;

public class BasePage {
    static WebDriver driver;
    private static final int TIMEOUT = 30;
    public long IMPLICIT_WAIT = 30;
    private WebDriverWait wait;
    static Properties prop;

    public BasePage(WebDriver driver) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            PageFactory.initElements(driver, this);
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/happyfox/qa/config/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}