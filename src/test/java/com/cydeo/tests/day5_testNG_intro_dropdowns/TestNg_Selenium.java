package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNg_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //Do browser driver setup
        //Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //Maximize the page
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



  @AfterMethod public void closeBrowser(){
        driver.close();
  }


    @Test
    public void selenium_test(){

        //Get "https://google.com"
        driver.get("https://google.com");

        //Assert: title is  "Google"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle,expectedTitle, "Title is  matching here." );

    }
}
