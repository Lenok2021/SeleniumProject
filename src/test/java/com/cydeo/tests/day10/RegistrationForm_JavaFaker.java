package com.cydeo.tests.day10;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationForm_JavaFaker {

    @Test
    public void testRegistrationForm() {

        //1. Open browser
        Driver.getDriver();
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //before  that I created Java Faker Class
        Faker faker = new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name = 'firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name = 'lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        String user = faker.bothify("helpdesk###");
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name = 'username']"));
        inputUserName.sendKeys(user);


        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name = 'email']"));
        //second solution = concatenate
        inputEmail.sendKeys(user+ "@mail.com");


        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name = 'password']"));
        inputPassword.sendKeys(faker.internet().password());



        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name = 'phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value = 'female']"));
        gender.click();

        //10. Enter date of birth
        WebElement inputDateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name = 'birthday']"));
        inputDateOfBirth.sendKeys("10/22/1983");

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
//TC#1: Registration form confirmation
//Note: Use JavaFaker OR read from configuration.properties file when possible.
//1. Open browser
//2. Go to website: https://practice.cydeo.com/registration_form
//3. Enter first name
//4. Enter last name
//5. Enter username
//6. Enter email address
//7. Enter password
//8. Enter phone number
//9. Select a gender from radio buttons
//10. Enter date of birth
//11. Select Department/Office
//12. Select Job Title
//13. Select programming language from checkboxes
//14. Click to sign up button
//15. Verify success message “You’ve successfully completed registration.” is
//displayed.
//
//
//Note:
//1. Use new Driver utility class and method
//2. User JavaFaker when possible
//3. User ConfigurationReader when it makes sense





