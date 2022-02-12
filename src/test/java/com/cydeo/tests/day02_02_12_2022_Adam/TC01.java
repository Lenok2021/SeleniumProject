package com.cydeo.tests.day02_02_12_2022_Adam;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) {
      /*
      Acceptance criteria:1 As a user I should be able to see Home is displayed

        //1-open a chrome browser

        //2-goto https://vytrack.com/
        //3-verify Home is displayed

       */
        //  thorough AC  we are going to create  out TC
        // in real work Env.  we test function MANUALLY,  after  that  we do automation testing

          //1-open a chrome browser
       /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        */

       WebDriver driver =  WebDriverFactory.getDriver("chrome");

        //2-goto https://vytrack.com/

       // driver.get(" https://vytrack.com/");
        driver.navigate().to(" https://vytrack.com/  ");

        //IQ  what's the difference between  get  and navigate methods?

        //  find Home webElement:
       WebElement homeElement =  driver.findElement(By.xpath(" //ul[@id = 'top-menu']/li[1]/a"));
        if(homeElement.isDisplayed()){
            System.out.println(" PASSED !!!");
        }else{
            System.out.println(" FAILED !!!");
        }

        // " //ul[@id = 'top-menu']/li[1]/a"
        // why  we put  li[1]  BC  when you change from 1 to 6
        // you can find each element from ul
        // if you delete 1 in li  you can find all elements
        // css selector ul[id='top-menu'] >li >a

driver.close();
    }
}
