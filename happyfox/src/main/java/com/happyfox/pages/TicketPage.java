package com.happyfox.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.happyfox.base.BasePage;

public class TicketPage extends BasePage {

    Actions action;

    public TicketPage(WebDriver driver) {
        super();
        this.action = new Actions(driver);
    }

    @FindBy(id = "ember29")
    WebElement tickets;

    @FindBy(linkText = "Statuses")
    WebElement statuses;

    @FindBy(xpath = "/html/body/div[3]/div/section/section/div/header/button")
    WebElement addStatusBtn;

    @FindBy(tagName = "input")
    WebElement inputSumbmitBtn;

    @FindBy(xpath = "//div[@class='sp-replacer sp-light']")
    WebElement colorPicker;

    @FindBy(xpath = "//input[@class='sp-input']")
    WebElement colorInput;

    @FindBy(xpath = "//a[@id='first-link']")
    WebElement firstLink;

    @FindBy(xpath = "//a[@id='second-link']")
    WebElement secondLink;

    @FindBy(tagName = "textarea")
    WebElement description;

    @FindBy(xpath = "//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']")
    WebElement addCreate;

    @FindBy(xpath = "//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']")
    WebElement moveTo;

    @FindBy(xpath = "//div[contains(text(),'Issue Created')]")
    WebElement issueCreated;

    @FindBy(linkText = "Make Default")
    WebElement makeDefault;

    @FindBy(linkText = "Priorities")
    WebElement priorities;

    @FindBy(xpath = "//header/button[1]")
    WebElement addPriorityBtn;

    @FindBy(css = "button[data-test-id='add-priority']")
    WebElement prioritySubmit;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")
    WebElement priorityRowToDelete;

    @FindBy(linkText = "Delete")
    WebElement deleteLink;

    @FindBy(css = "button[data-test-id='delete-dependants-primary-action']")
    WebElement confirmDelete;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")
    WebElement finalClick;

    public void createStatus() throws AWTException, InterruptedException {
        action.moveToElement(tickets).perform();
        statuses.click();
        addStatusBtn.click();
        inputSumbmitBtn.sendKeys("Issue Created");

        colorPicker.click();
        colorInput.clear();
        colorInput.sendKeys("#47963f");

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        waitUntilElementVisible(firstLink);
        waitUntilElementIsClickable(firstLink);

        firstLink.click();
        secondLink.click();
        description.sendKeys("Status when a new ticket is created in HappyFox");
        addCreate.click();
    }

    public void makeDefaultStatus() throws InterruptedException {
        waitUntilElementVisible(moveTo);
        waitUntilElementIsClickable(moveTo);
        action.moveToElement(moveTo).perform();
        moveTo.click();
        waitUntilElementVisible(issueCreated);
        waitUntilElementIsClickable(issueCreated);
        action.moveToElement(issueCreated).perform();
        makeDefault.click();
    }

    public void createPriority() {
        priorities.click();
        addPriorityBtn.click();
        inputSumbmitBtn.sendKeys("Assistance required");
        description.sendKeys("Priority of the newly created tickets");
        prioritySubmit.click();
    }

    public void deletePriority() throws InterruptedException {
        waitUntilElementVisible(tickets);
        waitUntilElementIsClickable(tickets);
        action.moveToElement(tickets).perform();
        priorities.click();
        waitUntilElementVisible(priorityRowToDelete);
        waitUntilElementIsClickable(priorityRowToDelete);
        priorityRowToDelete.click();
        deleteLink.click();
        confirmDelete.click();
    }

    public void doFinalClick() throws InterruptedException {
        waitUntilElementVisible(finalClick);
        waitUntilElementIsClickable(finalClick);
        finalClick.click();
    }
}
