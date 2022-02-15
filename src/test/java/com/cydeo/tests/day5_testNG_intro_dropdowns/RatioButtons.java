package com.cydeo.tests.day5_testNG_intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RatioButtons {

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(1000);
        hockeyButton.click();
        System.out.println("hockeyButton.isSelected() = " + hockeyButton.isSelected());
        System.out.println("hockeyButton.isDisplayed() = " + hockeyButton.isDisplayed());
        System.out.println("hockeyButton.isEnabled() = " + hockeyButton.isEnabled());

        System.out.println("=========================================================");

        //  locate blue button
        WebElement blueButton = driver.findElement(By.xpath(" //div[@class = 'radio']/input[@id = 'blue']"));
        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("blueButton.isDisplayed() = " + blueButton.isDisplayed());
        System.out.println("blueButton.isEnabled() = " + blueButton.isEnabled());

        System.out.println("===========================================================");
        //locate green button

        WebElement greenButton = driver.findElement(By.xpath(" //input[@id = 'green']"));
        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());
        System.out.println("greenButton.isDisplayed() = " + greenButton.isDisplayed());
        System.out.println("greenButton.isSelected() = " + greenButton.isSelected());

        // verify  is  label is == green

        WebElement label = driver.findElement(By.xpath(" //div[@class = 'radio']//label[.='Green']"));
        String actualLabel = label.getText();
        String expectedLabel = "Green";
        if(actualLabel.equalsIgnoreCase(expectedLabel)){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }



        // driver.close();



    }
}


/*
driver.close?
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

 */