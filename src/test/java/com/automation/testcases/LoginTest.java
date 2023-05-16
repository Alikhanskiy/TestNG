package com.automation.testcases;

import com.beust.jcommander.Parameter;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{
    /*@BeforeSuite
    public void setUp(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void cleanUp(){
        System.out.println("After Suite");
    }*/
    @Test(groups = {"SmokeTest", "ChiragTest"})
    @Parameters("browser")
    public void verifyUserCanLogin(String browser){
        System.out.println("verify login successful");
        System.out.println("Opening browser " + browser);

    }
    @Test(groups = {"ChiragTest", "WIPTest"})
    public void verifyUserCannotLoginWithInvalidCredentials(){
        System.out.println("verify login unsuccessful for invalid credentials");
    }
    @Test(groups = "SmokeTest")
    public void verifyUserCanResetPassword(){
        System.out.println("verify user can reset password");
    }
}


