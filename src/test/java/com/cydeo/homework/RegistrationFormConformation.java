package com.cydeo.homework;


import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegistrationFormConformation {

    // WebDriver driver;

    @Test
    public void registrationForm() {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get("https://practice.cydeo.com/registration_form ");

        Faker faker = new Faker();

        //3. Enter first name
        String firstName = faker.name().firstName();
        WebElement firstNameButton = Driver.getDriver().findElement(By.xpath("//input[@name = 'firstname']"));
        firstNameButton.sendKeys(firstName);


        //4. Enter last name
        String lastName = faker.name().lastName();
        WebElement lastNameButton = Driver.getDriver().findElement(By.xpath("//input[@name = 'lastname']"));
        lastNameButton.sendKeys(lastName);

        //5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name = 'username']"));
        userName.sendKeys(ConfigurationReader.getProperty("usernameRegistrationForm"));

        // 6. Enter email address
        String eMail = faker.internet().emailAddress();
        WebElement emailButton = Driver.getDriver().findElement(By.xpath("//input[@name = 'email']"));
        emailButton.sendKeys(eMail);

        // 7. Enter password
        WebElement passwordButton = Driver.getDriver().findElement(By.xpath("//input[@name = 'password']"));
        passwordButton.sendKeys(ConfigurationReader.getProperty("passwordRegistrationForm"));

        // 8. Enter phone number
        String phoneNumber = faker.numerify("571-###-####");
        WebElement phone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(phoneNumber);


        //9. Select a gender from radio buttons
        WebElement radioButton = Driver.getDriver().findElement(By.xpath("//input[@value= 'other']"));
        radioButton.click();

        //10. Enter date of birth
        String birthDay = "10/22/1983";
        WebElement DOB = Driver.getDriver().findElement(By.xpath("//input[@name = 'birthday']"));
        DOB.sendKeys(birthDay);

        //11. Select Department/Office
        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name = 'department']")));
        department.selectByVisibleText("Department of Engineering");

        // 12. Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name = 'job_title']")));
        jobTitle.selectByVisibleText("Manager");


        //13. Select programming language from checkboxes
        WebElement languageButton = Driver.getDriver().findElement(By.cssSelector("#inlineCheckbox2"));
        languageButton.click();

        //14. Click to sign up button
        WebElement sighIn = Driver.getDriver().findElement(By.id("wooden_spoon"));
        sighIn.click();

        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
        WebElement message = Driver.getDriver().findElement(By.tagName("p"));
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = message.getText();

        Assert.assertEquals(expectedMessage, actualMessage, "Passed");

    }
}


/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */