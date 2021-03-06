package com.cydeo.tests.day13Recap;

import com.cydeo.pages.DynamicControlPages;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {
    DynamicControlPages dynamicControlPages;

    @BeforeMethod
    public void setupMethod() {

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlPages = new DynamicControlPages();

    }

    @Test
    public void remove_button_test() {
        //3- Click to “Remove” button
        dynamicControlPages.button.click();

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlPages.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed


        try {
            //assertFalse method will pass the test if the boolean value returned is: false
            Assert.assertTrue(!dynamicControlPages.checkbox.isDisplayed());
            Assert.assertFalse(dynamicControlPages.checkbox.isDisplayed());
        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlPages.message.isDisplayed());
        Assert.assertTrue(dynamicControlPages.message.getText().equals("It's gone!"));
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

    }

    @Test
    public void testing_is_enabled() {
        //3- Click to “Enable” button

        //System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
        //        + dynamicControlsPage.inputBox.isEnabled());

        dynamicControlPages.enableButton.click();

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlPages.inputBox.isEnabled());


        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlPages.loadingBar);

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlPages.inputBox.isEnabled());

        //5- Verify:
        //a. Input box is enabled.

        Assert.assertTrue(dynamicControlPages.inputBox.isEnabled());
        //b. “It's enabled!” message is displayed.

        Assert.assertTrue(dynamicControlPages.message.isDisplayed());

        String expectedMessage = "It's enabled!";
        String actualMessage = dynamicControlPages.message.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }
}



