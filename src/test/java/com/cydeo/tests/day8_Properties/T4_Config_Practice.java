package com.cydeo.tests.day8_Properties;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {
    /*
    WebDriver driver;
        @BeforeMethod
        public void setUp() {


            //String browserType = ConfigurationReader.getProperty("browser");

            driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }
    */
    @Test
    public void google_search_test() {

        // Driver.getDriver() ==>>>  return Driver
        Driver.getDriver().get("https://google.com");

        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@name = 'q']"));

        googleSearch.sendKeys("apple" + Keys.ENTER);

        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


    }
}

/*

TC #4: Google search
1- Open a Chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search


Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */