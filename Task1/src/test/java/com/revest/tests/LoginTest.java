package com.revest.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.revest.pages.HomePage;
import com.revest.pages.LoginPage;
import com.revest.pages.SecurePage;
import com.revest.framework.utility.BrowserFactory;
import com.revest.framework.utility.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SecurePage securePage;
    private ExtentTest test;

    @BeforeTest
    public void setUpTest() {
        ExtentReportManager.setupExtentReport();
    }

    @BeforeMethod
    public void setUp() {
        ExtentReportManager.startTest("LoginTest", "Test to login and logout of The Internet");
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        test = ExtentReportManager.getTest();
    }

    @Test
    public void testLogin() {
        test.info("Clicking Form Authentication");
        loginPage = homePage.clickFormAuthentication();
        test.info("Entering username and password");
        loginPage.enterUsername("tomsmith").enterPassword("SuperSecretPassword!");
        test.info("Clicking login button");
        securePage = loginPage.clickLoginButton();

        test.info("Verifying success message");
        String message = securePage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        test.pass("Login test passed");

        test.info("Clicking logout button");
        homePage = securePage.clickLogout();
        test.pass("Logout test passed");
    }

    @AfterMethod
    public void tearDownMethod() {
        ExtentReportManager.endTest();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ExtentReportManager.getTest().info("Test completed");
        ExtentReportManager.endTest();
    }
}



