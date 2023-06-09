package com.automation.testcases;

import com.ebay.LoginFeatures;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
    LoginFeatures loginFeature = new LoginFeatures();

    @Test(dataProvider = "invalidData")
    public void verifyLoginUnsuccessfulWithInvalidCredentials(String username, String password) {
        //Test Data
        //String username = "Chirag", password = "admin@123";
        //Testing the Method with Test Data
        boolean result = loginFeature.doLogin(username, password);
        //Checking the output
        Assert.assertEquals(result, false);
    }
        @DataProvider(name = "invalidData")
        public Object[][] getInvalidData(){
        String[][] credentials = {
                {"admin","admin@123"},
                {"admin","admin123"},
                {"admin123","admin123"},
                {"chirag","admin123"},
                {"admin","@123"},
                {"devx","devx@123"},
                {"",""},
                {"","admin123"}

        };
        return credentials;
        }
    }

