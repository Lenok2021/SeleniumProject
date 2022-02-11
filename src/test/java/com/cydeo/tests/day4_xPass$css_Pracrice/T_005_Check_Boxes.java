package com.cydeo.tests.day4_xPass$css_Pracrice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T_005_Check_Boxes {
    public static void main(String[] args) {
        //Practice: Checkboxes
        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/checkboxes");

        // we have  to locate  check boxes
        WebElement checkbox1 = driver.findElement(By.xpath(" //input[@name = 'checkbox1']  "));
        WebElement checkbox2 = driver.findElement(By.xpath(" //input[@name = 'checkbox2'] "));

        System.out.println("checkbox1.isEnabled() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //2. Confirm checkbox #1 is NOT selected by default 3. Confirm checkbox #2 is SELECTED by default.


        //4. Click checkbox #1 to select it.
        //5. Click checkbox #2 to deselect it.
        //6. Confirm checkbox #1 is SELECTED.
        //7. Confirm checkbox #2 is NOT selected.

    }


}
