package com.cydeo.tests.day01_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {


        //1- Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        // This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // this line will maximize the browser size
        driver.manage().window().maximize();

        // driver.manage().window().fullscreen();
        // works only for Mac, same as maximize browser size


        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // get Tesla URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        //Stop code execution for 3 seconds
        Thread.sleep(3000);


        // use selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to():
        driver.navigate().to("https://www.google.com");

        // get the current title after getting tesla page
        currentTitle = driver.getTitle();


        //System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("currentTitle = " + currentTitle);


        //get GOOGLE  URL by using Selenium
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //  every time when we use same codes but different values we get
        // different output, BC  we have different pages


        // close all opened  windows, closes browser
        driver.quit();

        // will close only the currently opened browser
        // if we have only one opened window only current window
        // will be closed
        driver.close();


    }
}
