package com.revest.framework.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static String getDriverPath(String driverFileName) {
        String basePath = System.getProperty("user.dir");
        return basePath + "/src/main/resources/drivers/" + driverFileName;
    }

    public static WebDriver getDriver(String browserName) {
        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", getDriverPath("msedgedriver"));
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browserName + "\" not supported.");
        }

        return driver;
    }
}
