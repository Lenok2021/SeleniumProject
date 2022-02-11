package com.cydeo.practiceSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selector_024 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://search.yahoo.com");

        //1.  use css selector  to identify  search box and enter css selector

        //#'yschsp'  -  find by ID
        //input[id='yschsp']
        // input[name = 'p']
        // input[name= 'p'] [class = 'sbq']  or input.sbq[ name = 'p ']
        // div> input [name = 'p']
        // div#sbq-wrap>input[name = 'p']

        WebElement searchBox = driver.findElement(By.cssSelector("input[id='yschsp']"));
        //2. type hello
        searchBox.sendKeys("hello");

        //3. click on x button to clear out the text
        WebElement xButton = driver.findElement(By.cssSelector("span[class='sprite']"));
        xButton.click();

        //4. enter "selenium locators" in search box
        searchBox.sendKeys("selenium locators" + Keys.ENTER);

        // 5. forward back

        driver.navigate().back();

        //6. enter selenium locator again
        WebElement searchBox1 = driver.findElement(By.cssSelector("input[id='yschsp']"));
        searchBox1.sendKeys("selenium locators"+ Keys.ENTER);

        //7. identify search icon and click on it
        WebElement searchButton = driver.findElement(By.cssSelector("span[role = 'ico-syc mag-glass']"));


        driver.close();

    }

}
