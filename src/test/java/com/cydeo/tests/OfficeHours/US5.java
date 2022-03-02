package com.cydeo.tests.OfficeHours;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env"));

        CRM_Utilities.crm_login(driver);

    }

    @Test
    public void sendingMessagesTest(){

//        Users are on the homepage
//        Users click the MESSAGE tab
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();

//        Users write test message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        WebElement msgFrame=driver.findElement(By.tagName("body"));
        msgFrame.sendKeys("Hello!");

//        Users click the SEND button
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();

//        Verify the message is displayed on the feed
        WebElement feed= driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        Assert.assertEquals(feed.getText(),"Hello!","Message did not appear!");

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}

}

/*
//Test cases #1
//Description: Users send text messages successfully
//Environment: https://login2.nextbasecrm.com/
//Steps:: Users are on the homepage
//Users click the MESSAGE tab
//Users write test message
//Users click the SEND button
//Verify the message is displayed on the feed

 */