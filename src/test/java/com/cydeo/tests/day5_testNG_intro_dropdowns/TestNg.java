package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg {

    @BeforeClass
    public void setupMethod(){
        System.out.println("---->BeforeClass is running!");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---->AfterClass is running!");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--->BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--->AfterMethod is running!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running...");

        //ASSERT EQUALS :  we compare 2 of same things
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);

    }



    @Test
    public void test2(){
        System.out.println("Test 2 is running...");

        String actual = "apple";
        String expected = "apple";

        Assert.assertTrue(actual.equals(expected));

    }
}
