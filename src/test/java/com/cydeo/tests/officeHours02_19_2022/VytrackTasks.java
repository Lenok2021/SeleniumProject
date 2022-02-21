package com.cydeo.tests.officeHours02_19_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackTasks {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://vytrack.com/");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void TC01_verifying_header_labels() {


    }

    @Test
    public void TC2_verify_labels_under_our_approach() {



    }



    /*
    /*
TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our Approach”,” Products and Services”,” Contact”,”LOGIN”]
1- Open a Chrome browser
2- Go to “https://vytrack.com/”
3- Verify that [“Home”,”About us”,”Our Approach”,” Products and Services”,” Contact”,” LOGIN”] is displayed
*/

/*
/*
TC 2- As a user I should be able to see the labels [“Our Mission and Vision”,” Car Fleet Management”,” Newest Technologies”,””] under Our Approach
1- Open a Chrome browser
2- Go to “https://vytrack.com/”
3- Verify that [“Our Mission and Vision”,” Car Fleet Management”] is displayed
*/


}
