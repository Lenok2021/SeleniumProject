package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //1. create private Constructor = we close access to the Object outside the Class.
    private Driver() {
    }

    /*2. we make Webdriver private, because we want to close access outside the class.
    we make it static because we will use it in a static method.
     */
    private static WebDriver driver;

    /*
    create a reusable utility  method which will
   return same driver instance when we will call that
   */
    public static WebDriver getDriver() {

        if (driver == null) {  // if driver ==  null go here and create a new WebDriver instance
                          /*
             we get browser type from configuration property file
             we can control which browser is opened from outside of code,
             from configuration properties file
             */
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            Depending on the browserType that will be return from configuration.properties
            file switch statement  will determine the
             */

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;  //  if the Driver is not null ==> return me the existing one
    }

}
