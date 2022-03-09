package com.cydeo.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardActions {


    @Test
    public void test_keyBoard_action() {

        Driver.getDriver().get("https://www.google.com/");

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        // click on element
        // hold down the shift and enter text
        // release to the shift and enter the text
        // hold down the CONtrol enter A to select all
        // send keys backspace

        Actions actions = new Actions(Driver.getDriver());

        actions.click(searchBox).pause(2000).keyDown(Keys.SHIFT)
                .sendKeys("typing by holding the shift").pause(2000)
                .keyUp(Keys.SHIFT)
                .sendKeys("typing after realising shift").pause(1000)
                .keyDown(Keys.CONTROL).sendKeys("A").pause(2000)
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();




    }
}
