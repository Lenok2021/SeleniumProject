package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selectors1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");
        
        //1.  locate input for userName
        WebElement userName = driver.findElement(By.id("inputEmail"));
        boolean a = userName.isDisplayed();
        System.out.println("a = " + a);
        System.out.println("------------------------------------------");

        //2. located input for password  by className
        WebElement password = driver.findElement(By.className("form-control"));
        boolean b = password.isDisplayed();
        System.out.println("b = " + b);
        System.out.println("-------------------------------------------------");







    }
}
