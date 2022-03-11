package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //1. initialize the driver instance and Object of the class

    public LibraryLoginPage() {  //  we created constructor
        //2.  call method from Selenium
        //this line initialize the Driver Object, and Object of this Class
        // initElement method will create connection in between the current
        //driver session (instance) and the Object of the current class
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //2.  use @FindBy annotation to locate web elements

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;


}