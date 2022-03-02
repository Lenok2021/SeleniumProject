package com.cydeo.homework;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void smartbearSoftwareLinkVerification() {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        //Print out count of all the links on landing page

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());

        // Print out each link text on this page

        for (WebElement each : links) {
            System.out.println(each.getText());
        }

    }

    @Test
    public void smartBearSoftwareOrderPlacing() {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.SmartBearLogin(driver);

        //Click on Order
        WebElement orderLink = driver.findElement(By.linkText("Order"));
        orderLink.click();

        //Select familyAlbum from product, set quantity to 2
        // dropdown
        Select dropDown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        dropDown.selectByValue("FamilyAlbum");

        WebElement quantityButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityButton.sendKeys("2");

        WebElement calculatorButton = driver.findElement(By.cssSelector("input[onclick = 'productsChanged(); return false;']"));
        calculatorButton.click();

        //Generate faker: name, street, city, state, zip code
        // complete the form
        Faker faker = new Faker();
        String customerName = faker.name().fullName();
        String street = faker.address().streetAddress();
        String city = faker.address().cityName();
        String state = faker.address().stateAbbr();
        String zipCode = faker.address().zipCode();

        WebElement customerNameButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerNameButton.sendKeys(customerName);

        WebElement addressButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        addressButton.sendKeys(street);

        WebElement cityButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        cityButton.sendKeys(city);

        WebElement stateButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        stateButton.sendKeys(state);

        WebElement zipCodeButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCodeButton.sendKeys(zipCode);

        // click on Visa
        //Generate card number using JavaFaker
        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visa.click();
        String cardNumber = faker.business().creditCardNumber();

        WebElement enterNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        enterNumber.sendKeys(cardNumber);

        String  cardDate = "10/24";
        WebElement cardExpDateInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        cardExpDateInput.sendKeys(cardDate);

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

    }
}


/*
TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page

Mini-Task: CREATE A CLASS à SmartBearUtils
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter

TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”


 */