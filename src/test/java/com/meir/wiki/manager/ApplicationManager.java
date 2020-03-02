package com.meir.wiki.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    AppiumDriver driver;
    ArticleHelper article;


    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa22_class");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app",
                "D:/QA_22/Automat_QA/GitHub/Wiki_mob/src/test/resources/apk/wikipedia.apk");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        article = new ArticleHelper(driver);


    }

    public ArticleHelper getArticle() {
        return article;
    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    public void skipWelcomePage() {
        driver.findElement(By.xpath(
                "//android.widget.TextView[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']"))
                .click();
    }
}
