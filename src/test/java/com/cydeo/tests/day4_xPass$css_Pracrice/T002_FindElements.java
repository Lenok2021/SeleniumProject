package com.cydeo.tests.day4_xPass$css_Pracrice;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T002_FindElements {

    public static void main(String[] args) {

        /*
         //TC #4: FindElements Task
        //1- Open a Chrome browser

        //Providing extra wait time for our driver before it throws NoSuchElementException

        //2- Go to: https://practice.cydeo.com/abtest

        //3- Locate all the links in the page.
        //4- Print out the number of the links on the page.
        //4- Print out the number of the links on the page.
        //6- Print out the HREF attribute values of the links
         */



        WebDriver  driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get(" https://practice.cydeo.com/abtest ");

        //3- Locate all the links in the page.
        List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
        // short cuts: Windows : alt + enter

        //4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());

        //4- Print out the number of the links on the page.
        for(WebElement each : allLinks){
            System.out.println("Text of link: " + each.getText());
        }





    }
}
