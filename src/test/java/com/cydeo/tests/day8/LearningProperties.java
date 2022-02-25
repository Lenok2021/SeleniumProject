package com.cydeo.tests.day8;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void testName() {

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));

    }
}
