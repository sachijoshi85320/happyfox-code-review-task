
package com.happyfox.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.happyfox.base.BasePage;
import com.happyfox.pages.SupportHiveLoginPage;
import com.happyfox.pages.TicketPage;

public class TestCase101_supporthive extends BasePage {
        SupportHiveLoginPage loginPage;
        TicketPage ticketPage;

        @BeforeMethod
        public void setUp() {
                initialization();
                loginPage = new SupportHiveLoginPage(getDriver());
                ticketPage = new TicketPage(getDriver());
        }

        @Test
        public void testLogin() {
                loginPage.login("Agent", "Agent@123");
                loginPage.verifyCaptcha();
                try {
                        ticketPage.createStatus();
                        ticketPage.makeDefaultStatus();
                        ticketPage.createPriority();
                        ticketPage.deletePriority();
                        ticketPage.doFinalClick();
                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                }


        
        }
}