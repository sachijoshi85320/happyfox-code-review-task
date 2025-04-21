package happyfox.src.main.test.testcases;

import happyfox.src.main.java.pages.LoginPage;

public class TestCase101 extends BasePage {
        LoginPage loginPage;
        public TestCase101() {
                super();
        }

        @BeforeMethod
        public void setUp() {
                initialization();
                loginPage = new LoginPage(getDriver());
        }

        @Test
        public void testLogin() {
                loginPage.login("Agent", "Agent@123");
                loginPage.verifyHomePage();
        }

        public static void main(String[] args) throws InterruptedException, AWTException {
                System.setProperty("webdriver.gecko.driver",
                                "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
                WebDriver driver = new FirefoxDriver();
                driver.get("https://interview.supporthive.com/staff/");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.findElement(By.id("id_username")).sendKeys("Agent");
                driver.findElement(By.id("id_password")).sendKeys("Agent@123");
                driver.findElement(By.id("btn-submit")).click();
                WebElement tickets = driver.findElement(By.id("ember29"));
                Actions action = new Actions(driver);
                action.moveToElement(tickets).build().perform();
                WebElement statuses = driver.findElement(By.linkText("Statuses"));
                statuses.click();
                driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();
                driver.findElement(By.tagName("input")).sendKeys("Issue Created");
                WebElement statusColourSelect = driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
                statusColourSelect.click();

                WebElement statusColourEnter = driver.findElement(By.xpath("//input[@class='sp-input']"));
                statusColourEnter.clear();
                statusColourEnter.sendKeys("#47963f");

                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ESCAPE);

                WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
                firstElement.click();

                WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
                secondElement.click();

                driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
                WebElement addCreate = driver
                                .findElement(By.xpath(
                                                "//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
                addCreate.click();

                Thread.sleep(3000);

                WebElement moveTo = driver
                                .findElement(By.xpath(
                                                "//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
                action.moveToElement(moveTo).build().perform();
                moveTo.click();

                Thread.sleep(9000);

                WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
                action.moveToElement(issue).build().perform();

                WebElement make = driver.findElement(By.linkText("Make Default"));
                make.click();
                driver.findElement(By.linkText("Priorities")).click();
                driver.findElement(By.xpath("//header/button[1]")).click();
                driver.findElement(By.tagName("input")).sendKeys("Assistance required");
                driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
                WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
                button.click();

                Thread.sleep(9000);

                WebElement tickets2 = driver.findElement(By.id("ember29"));
                action.moveToElement(tickets2).build().perform();
                WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
                priorities2.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver.findElement(By.xpath(
                                "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]"))
                                .click();
                driver.findElement(By.linkText("Delete")).click();
                WebElement delete = driver
                                .findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
                delete.click();

                Thread.sleep(9000);
                driver.findElement(
                                By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]"))
                                .click();
                driver.findElement(By.linkText("Logout")).click();

        }
}