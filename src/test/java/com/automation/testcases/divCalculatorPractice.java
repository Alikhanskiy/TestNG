package com.automation.testcases;

import com.ebay.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class divCalculatorPractice {
    Calculator cal;
    @BeforeClass
    public void setUp(){
    cal = new Calculator();
    }
    public int div(int a, int b){
        return a/b;
    }
    @Test(dataProvider = "testingWithZero")
    public void divTest(int a, int b){
        int actual = cal.div(a,b);
        int expected = a/b;
        Assert.assertEquals(actual,expected);
    }
    @DataProvider(name = "testingWithZero")
    public Object[][] data(){
        Object[][] digits = new Object[][]{
                {10, 2},
                {20, -5},
                {3, 0},
                {0, 5},

        };
        return digits;
    }
    @Test(dataProvider ="testingWithZero" )
    public void divTesting(int a, int b){
        if(b==0){
            try{
                cal.div(a,b);
                Assert.fail("Not throwing exception");
            }
            catch (Exception e) {
                String actualMessage = e.getMessage();
                String expectedMessage = "/by zero";
                Assert.assertEquals(actualMessage,expectedMessage);
                Assert.assertTrue(actualMessage.equals(expectedMessage));
            }
        }
    }


}
