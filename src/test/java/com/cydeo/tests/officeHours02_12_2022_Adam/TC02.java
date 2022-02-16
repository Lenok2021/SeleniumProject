package com.cydeo.tests.officeHours02_12_2022_Adam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC02 {

    public static void main(String[] args) {

       /*
        TC:2 As a user I should be able to see About is displayed

        //1-open a chrome browser
        //2-goto https://vytrack.com/
        //3-verify About us is displayed
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://vytrack.com/ ");
        driver.findElement(By.xpath(" //ul[@id = 'top-menu']/li[@id = 'menu-item-844']/a"));

        WebElement aboutUsElement =  driver.findElement(By.xpath(" //ul[@id = 'top-menu']/li[1]/a"));
        if(aboutUsElement.isDisplayed()){
            System.out.println(aboutUsElement.getText());
            System.out.println(" PASSED !!!");
        }else{
            System.out.println(aboutUsElement.getText());
            System.out.println(" FAILED !!!");
        }


    }
}
