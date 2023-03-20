package org.example;

import Pages.HomePage;
import SetUp.OpenClose;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Users.TestListener;

@Listeners({TestListener.class})
public class BasicTest extends OpenClose {
    @Test
    public void firstTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        HomePage homePage = new HomePage(driver, webDriverWait);
        homePage.checkSettings();
    }
}
