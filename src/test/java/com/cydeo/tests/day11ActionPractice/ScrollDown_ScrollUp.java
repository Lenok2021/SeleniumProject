package com.cydeo.tests.day11ActionPractice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollDown_ScrollUp {

    @Test
    public void task_4and_5_test() {

        Driver.getDriver().get("https://practice.cydeo.com/ ");


        //Scroll down to “Powered by CYDEO”
        //Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.moveToElement(cydeoLink).perform();


        //Scroll back up to “Home” link using PageUP button
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        // in  the interview you can say  how to scroll down or scroll up

       // Driver.getDriver().quit();

        // 1. when  I  use quite  method,  it  terminates Driver,  killed the session
        // Session ID is null. Using WebDriver after calling quit()?

        //2. when you use close()
        //org.openqa.selenium.NoSuchSessionException: invalid session id
        Driver.closeDriver();

    }

    @Test
    public void test2() {

        Driver.getDriver().get("https://practice.cydeo.com/ ");



    }
}


/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */