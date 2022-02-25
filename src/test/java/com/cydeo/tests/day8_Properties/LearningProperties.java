package com.cydeo.tests.day8_Properties;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void testName() {
        //we provide (pass) key  we get value
        // key = value
        //os.name = Windows 10
        // user.name = cross
        //  you have a key open the door, The key has to be exactly the same to open the door
        // if you don't provide the correct key, you don't get value.

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

    }
}
