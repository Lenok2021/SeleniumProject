package com.cydeo.tests.day13Recap;

import com.cydeo.pages.DynamicControlPages;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @Test
    public void remove_button_test() {

        // 3- Click to “Remove” button
        DynamicControlPages dynamicControlPages = new DynamicControlPages();
        Actions actions = new Actions(Driver.getDriver()) ;

        actions.moveToElement(dynamicControlPages.button).click().perform();

        // 4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);



        // 5- Verify:
        // a. Checkbox is not displayed
        // b. “It’s gone!” message is displayed.

    }

}


/*
TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.

NOTE: FOLLOW POM
 */