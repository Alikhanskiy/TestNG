package com.automation.testcases;

import com.ebay.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivDDTest {
    Calculator cal;
    @BeforeMethod
    public void setUp(){
        cal = new Calculator();
    }
    @Test(dataProvider = "Data")

    public void divTest(int a, int b, int expected){
        int actual = cal.div(a, b);
        Assert.assertEquals(actual,expected);
    }
    @DataProvider(name = "Data")
    public Object [][] getData(){
        Integer[][] nums = {
                {10, 5, 2},
                {-20, 4, -5},
                {100, -2, -50},
                {-2000, -50, 40},
                {5 , 13, 0},
                {0 , 9 , 0},
        };
        return nums;
    }
    @Test(dataProvider = "datawithexception")
    public void divWithZeroTest(int a ,int b){
        if(b==0){
            try{
                cal.div(a,b);
                Assert.fail("Expected exception but there's no exception");
            }
            catch(Exception e){
                String actMessage = e.getMessage();
                String expMessage = "/ by zero";
                Assert.assertEquals(actMessage, expMessage);
            }
        }
    }
    @DataProvider(name = "datawithexception")
    public Object [][] divByZero(){
        Integer[][] withZero = {
                {7 , 0},
                {0 , 0},
        };
        return withZero;
    }


}
