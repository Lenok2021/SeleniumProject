package com.cydeo.Akbur_videos;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class day46_Actions_Scroll_Up_Scroll_Down {

   /*
    /*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method

    */

    @Test
    public void testName() {

        // two  ways  from Actions Class:
        //***  we can use moveToElement() method
        //*** we can sendKeys(Keys.PAGE_UP)
        //*** we can sendKeys(Keys.PAGE_DOWN)

        Driver.getDriver().get(" https://practice.cydeo.com/");

        //Scroll down to “Powered by CYDEO”
        //Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.moveToElement(cydeoLink).perform();


        //Scroll back up to “Home” link using PageUP button
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        BrowserUtils.sleepMethod(3);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

       // Driver.closeDriver();

    }
}
