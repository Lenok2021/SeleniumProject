package com.cydeo.tests.day02_02_12_2022_Adam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC03 {

    public static void main(String[] args) {

       // C:3 As a user I should be able to see Contact is displayed

        //1-open a chrome browser

        //2-goto https://vytrack.com/

        //3-verify Contact is displayed and label is "Contact"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://vytrack.com/ ");
        WebElement contactElement = driver.findElement(By.xpath(" //ul[@id = 'top-menu']//*[contains(@href, 'contact')]"));

        if(contactElement.isDisplayed()){
            System.out.println(" PASSED");
        }else{
            System.out.println("FAILED");
        }
driver.close();
    }
}
