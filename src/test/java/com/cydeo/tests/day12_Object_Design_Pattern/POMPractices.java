package com.cydeo.tests.day12_Object_Design_Pattern;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {


    @Test
    public void verify_userName_password_required() {

        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com/
        Driver.getDriver().get("https://library1.cydeo.com/");
        //3- Do not enter any information
        //4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed: Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
/*
TC #1: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com/
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.

NOTE: FOLLOW POM DESIGN PATTERN

 */

    }

    @Test
    public void test_invalidFormat_error_message() {
/*
TC #2: Invalid email format error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.

NOTE: FOLLOW POM DESIGN PATTERN
 */

        Driver.getDriver().get("https://library1.cydeo.com ");
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.inputUsername.sendKeys("1111");

        libraryLoginPage.signInButton.click();


        //Enter invalid email format
        //Verify expected error is displayed:
        //Expected: Please enter a valid email address

        String actualResult = libraryLoginPage.enterValidEmailErrorMessage.getText();
        String expectedResult = "Please enter a valid email address.";
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void testing_negative_login() {

      /*
        TC #3: Library negative login
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter incorrect username or incorrect password
4- Verify title expected error is displayed:
Expected: Sorry, Wrong Email or Password

NOTE: FOLLOW POM DESIGN PATTERN
       */

        Driver.getDriver().get("https://library1.cydeo.com ");
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("cross");
        libraryLoginPage.inputPassword.sendKeys("111");
        libraryLoginPage.signInButton.click();

        String actualWrongMessage = libraryLoginPage.wrongEmailOrPasswordErrorMessage.getText();
        String expectedWrongMessage = "Sorry, Wrong Email or Password";
        Assert.assertEquals(expectedWrongMessage,actualWrongMessage);
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }
}





