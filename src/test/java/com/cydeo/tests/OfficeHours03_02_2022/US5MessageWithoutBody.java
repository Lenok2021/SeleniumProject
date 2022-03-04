package com.cydeo.tests.OfficeHours03_02_2022;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US5MessageWithoutBody {

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
    public void testName() {
        //click on message button
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();

        // click on sent  button
        driver.findElement(By.id("blog-submit-button-save")).click();

        // verify title
        WebElement text = driver.findElement(By.xpath("//span[.  = 'The message title is not specified']"));

        String actualText = text.getText();
        String expectedText = "The message title is not specified";

        Assert.assertEquals(actualText,expectedText);



    }
}
