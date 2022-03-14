package com.cydeo.tests.day13Recap;

import com.cydeo.pages.DynamicControlPages;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {
    DynamicControlPages dynamicControlPages;


    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");


    }


    @Test
    public void remove_button_test() {

        // 3- Click to “Remove” button
        dynamicControlPages = new DynamicControlPages();

        dynamicControlPages.button.click();

        // 4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPages.loadingBar));

        // 5- Verify:
        // a. Checkbox is not displayed

        try {
            Assert.assertTrue(!(dynamicControlPages.checkbox.isDisplayed()));
            Assert.assertFalse(dynamicControlPages.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);

        }
        // b. “It’s gone!” message is displayed.

        Boolean isDisplayed = dynamicControlPages.message.isDisplayed();
        System.out.println("isDisplayed = " + isDisplayed);

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