package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StaleElementsRefEx {

    public static void main(String[] args) throws InterruptedException {
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to https://practice.cydeo.com/add_remove_elements/

        driver.get("https://practice.cydeo.com/add_remove_elements/  ");

        // 3. Click to “Add Element” button

        WebElement addElementButton = driver.findElement(By.xpath("//div//button[.='Add Element'] "));
        Thread.sleep(1000);
        addElementButton.click();


        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath(" //button[@class = 'added-manually']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        deleteButton.click();

        //  we got StaleElementReferenceException!!!!!!!!!!!!!!!!!!!

        //6. Verify “Delete” button is NOT displayed after clicking.
        try{
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch(StaleElementReferenceException e){
            System.out.println("--> StaleElementReferenceException is thrown.");
            System.out.println("--> This means webElement was deleted from  the page.");
            System.out.println("--> The webElement is not displayed.");
        }



    }
}


/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

 */