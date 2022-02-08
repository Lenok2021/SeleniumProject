package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_getText_getAttributes {


    public static <Srtring> void main(String[] args) {


        // 1. open  a Chrome browser
        WebDriver  driver = WebDriverFactory.getDriver("chrome");
         //2. get https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3. Verify "remember me" label on this computer
        // expected  "Remember me on this computer

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if(actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("PASSED !!!");
        }else {
            System.out.println("FAILED !!!");
        }

        //4.verify "forgot password Link
        // Expected Forgot your password

        WebElement  forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));


        String expectedForgotPasswordLinkText = "Forgot your password?";
        String actualForgotPasswordLinkText = forgotPasswordLink.getText();

        if(expectedForgotPasswordLinkText.equals(actualForgotPasswordLinkText)){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("actualForgotPasswordLinkText = " + actualForgotPasswordLinkText);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgotPasswordLinkText);
            System.out.println("FAILED !!!");
        }

        //  in this  case  test  did  not pass, BC  lower cases  and lower cases.
        //  we are  not  robot,  ask  your team members


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPasswordLink.getAttribute("href");

        if(actualInHref.contains(expectedInHref)){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }



    }
}
