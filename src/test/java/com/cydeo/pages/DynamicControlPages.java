package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPages {


    public  DynamicControlPages(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//button[. = 'Remove']")
    public WebElement button ;

    @FindBy(css = "div#loading")
    public WebElement loadingBar ;

    @FindBy(id = "checkbox")
    public WebElement checkbox ;
    @FindBy (id = "message")
    public WebElement message;




}
