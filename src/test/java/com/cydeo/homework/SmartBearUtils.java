package com.cydeo.homework;

import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmartBearUtils {

      public static void SmartBearLogin(WebDriver driver) {

            WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
            userName.sendKeys(ConfigurationReader.getProperty("userNameBear"));

            WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
            password.sendKeys(ConfigurationReader.getProperty("passwordBear"));

            WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
            loginButton.click();

            }


   /*

    Mini-Task: CREATE A CLASS à SmartBearUtils
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
    */


      }

