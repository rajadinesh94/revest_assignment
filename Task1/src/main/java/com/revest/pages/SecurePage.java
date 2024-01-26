package com.revest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private WebDriver driver;
    private By successMessage = By.id("flash");
    private By logoutButton = By.xpath("//*[@id='content']/div/a/i");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public HomePage clickLogout() {
        driver.findElement(logoutButton).click();
        return new HomePage(driver); // Returns a new instance of the HomePage class
    }
}
