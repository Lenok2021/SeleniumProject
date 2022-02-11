package com.cydeo.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElement {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://yahoo.com");
        WebElement inputBox = driver.findElement(By.id("ybar-sbq"));
        inputBox.sendKeys("Hello");

        Thread.sleep(3000);

        driver.quit();




    }
}
