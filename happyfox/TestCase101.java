package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/* Overall Code Quality is Poor.
 * Code Formatting Is Missing. Please use Prettier
 * In complete Code, No Validation is done. There is no use of Assertions or Verification of Toast Messages.
 * Thread.sleep is used multiple times. Please avoid using Thread.sleep and use Implicit instead.
 * Absolute XPaths were used in some places due to lack of stable attributes – ideally should be replaced with relative XPaths or CSS Selectors.
 * POM (Page Object Model) is not followed yet. WebElements are directly accessed in the test class. In a real-world project, refactoring into POM would improve scalability and maintainability.
 * Validation/Assertions are missing — adding assertion logic or toast message verification would make it a proper test.
 */

public class Testcase101 {

    public static void main(String[] args) throws InterruptedException, AWTException {
        /* Avoid Using Local FireFoxDriver. Rather Use ChromeOptions to initialize the Driver
         * 
         * FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
         */

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
        
		driver.get("https://interview.supporthive.com/staff/");

        /*
         * Instead of using explicit wait, try using implicit wait.
         */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

        /*
         * Instead of Defining the WebElements in Test Class, follow POM and Create a Page Class for the WebElement.
         * This structure is violating the POM structure and is not maintainable.
         */
		driver.findElement(By.id("id_username")).sendKeys("Agent");
		driver.findElement(By.id("id_password")).sendKeys("Agent@123");
		driver.findElement(By.id("btn-submit")).click();
		WebElement tickets = driver.findElement(By.id("ember29"));

        /*
         * Ideally Interactions with WebElements should be handled in Page Classes and not in Test Classes.
         */
		Actions action = new Actions(driver);

        /*
         * Naming COnventions are Extremely incorrect. We need to have a Btter Name for WebElement.
         * We Should Use Postfixes Link : 
         * Button -> Btn
         * Link -> Lnk
         * TextBox -> TxtBx
         */
		action.moveToElement(tickets).build().perform();
		WebElement statuses = driver.findElement(By.linkText("Statuses"));
		statuses.click();

        /*
         * Avoid Using Absolute Xpath. Rather Use Relative Xpath and Most preffered is to make use of Ids for Better script stability.
         */
		driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();
		driver.findElement(By.tagName("input")).sendKeys("Issue Created");
		WebElement statusColourSelect =
		          driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
		          statusColourSelect.click();

		          WebElement statusColourEnter =
		          driver.findElement(By.xpath("//input[@class='sp-input']"));
		          statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");

                  /*
                   * If possible please use Actions Interaction instead.
                   * Example : 
                   * Actions actions = new Actions(driver); actions.sendKeys(Keys.ESCAPE).perform();
                   */
		          Robot r = new Robot();
		          r.keyPress(KeyEvent.VK_ESCAPE);
	
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();
        

		/*
         * Instead of using tagname, use stable webelement like Css Locators or Ids.
         */
		driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
		WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
	      addCreate.click();

          /*
           * Instead of using Thread.sleep, use WebDriverWait for better stability and performance and reduce Execution time.
           */
	      Thread.sleep(3000);

	      WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	      action.moveToElement(moveTo).build().perform();
	      moveTo.click();
	     
           /*
           * Instead of using Thread.sleep, use WebDriverWait for better stability and performance and reduce Execution time.
           * Please try using Fluent Waits or Explicit Waits.
           */
	      Thread.sleep(9000);
	      
	      WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
			action.moveToElement(issue).build().perform();
			
			
	      WebElement make = driver.findElement(By.linkText("Make Default"));
	      make.click();

          /*
           * The Choice of Locators is Incorrect. Please use the most stable locators like Ids or Css Selectors else script would become flaky after couple of deployments
           */
	      driver.findElement(By.linkText("Priorities")).click();
	      driver.findElement(By.xpath("//header/button[1]")).click();
	      driver.findElement(By.tagName("input")).sendKeys("Assistance required");
	      driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	      WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
	      button.click();
	 
          /*
           * Instead of using Thread.sleep, use WebDriverWait for better stability and performance and reduce Execution time.
           * Please try using Fluent Waits or Explicit Waits.
           */
Thread.sleep(9000);

WebElement tickets2 = driver.findElement(By.id("ember29"));
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
priorities2.click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
/*
 * Remove the Absolute Xpath and use the relative xpath which is more stable and less flaky.
 */
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click();

/*
 * Instead of using Thread.sleep, use WebDriverWait for better stability and performance and reduce Execution time.
 * Please try using Fluent Waits or Explicit Waits.
 */
Thread.sleep(9000);
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();
driver.findElement(By.linkText("Logout")).click();


/*
 * You will Face Compilation Error since Curly Brackets are not closed.
 */

public class PagesforAutomationAssignment {

    public static void main(String[] args) {

        /* 
         * Use ChromeOptions to initialize the driver.
         */
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.happyfox.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        driver.quit();
    }


    static class BasePage {
        protected WebDriver driver;

        /*
         * 
         * To Maintain Clean Code, please create a method called Initialization and initialize the Driver there instead of in constructor.
         * This will help in flexible and easy to configure, allowing changes to the WebDriver setup (such as switching browsers or adding options) without altering the core page object logic.
         * Since User might want to use Firefox or Chrome or any other browser, this will help in easy configuration.
         */
        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {
            /*
             * For Code Readability & Maintainability please  use @FindBy makes your code cleaner and easier to read
             * To avoid duplication of WebElements and improve Reusability please follow Page Factory pattern here. There can be a cases wherein you might need to use the same WebElement in multiple methods. 
             *  Example : 
             * 
             * @FindBy(id = "username")
	WebElement userNameTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    public HappyFoxLoginPage(WebDriver driver) {
        super();
    }

    public void login(String username, String password) {
        userNameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }


             */
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




	}

}