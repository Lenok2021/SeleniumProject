package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selectors2 {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://library2.cybertekschool.com/login.html
        driver.navigate().to("https://practice.cydeo.com");

        //1  try  to locate element by linkText locator
        //  after that get text
        // compare text with expected result:  Home

        WebElement homeElement = driver.findElement(By.linkText("Home"));
        boolean a = homeElement.isDisplayed();
        System.out.println("a = " + a);
        String expectedResult = "Home";
        String actualResult = homeElement.getText();
        if (actualResult.equals(expectedResult)) {
            System.out.println("PASSED !!!!");
        } else {
            System.out.println("FAILED !!!");
        }
        System.out.println("--------------------------------------------");

        // locate notification messages link  as partialLinkText

        WebElement notification = driver.findElement(By.partialLinkText("Notification"));
        boolean b = notification.isDisplayed();
        System.out.println("b = " + b);
        // get text
        String text = notification.getText();
        System.out.println("Text is " + text);
        System.out.println("-------------------------------------------");

        // locate elements by tag
        // let's verify, that  when we locate element by using tag, we pass a parameter
        // as a tag, we go through HTML and returns the first matching result
        WebElement FirstMatchingElement = driver.findElement(By.tagName("a"));
        String result = FirstMatchingElement.getText();
        System.out.println("result = " + result);
        // as a result  we provide  the  Home , BC  HOME  is  a first  element which  has a tag





    }


}
