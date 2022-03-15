package com.cydeo.Akbur_videos;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class day46Actions_Demo_KeyboardAction {

    @Test
    public void test_keyBoard_Actions() {

        Driver.getDriver().get("https://google.com");
        // click on the element
        // hold down to the shift and enter text
        // release the shift and enter text
        // hold down to Command on mac , Control on windows enter A to select all
        // send keys backspace
        // pause 1 seconds in between actions

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        Actions actions = new Actions(Driver.getDriver());


        actions.click(searchBox).pause(2000)
                .keyDown(Keys.SHIFT)
                .sendKeys("typing by holding down to shift").pause(2000)
                .keyUp(Keys.SHIFT)
                .sendKeys("typing after releasing shift").pause(2000)
                .keyDown(Keys.CONTROL).sendKeys("A")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();

        Driver.closeDriver();




    }
}
