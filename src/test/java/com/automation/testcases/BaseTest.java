package com.automation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseTest {
    WebDriver driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {

           //Scanner sc = new Scanner(System.in);
            //System.out.println("Where do you want to execute your test?");*/
            String platform = "Local";//Cloud
            if(platform.equals("Local")){
                driver = getLocalDriver();
            }
            else {
                driver = getCloudDriver();

            }
            //System.out.println("Opening browser");
            WebDriverManager.chromedriver().setup();

            driver = getCloudDriver();
            driver.get("https://www.google.com");

        }
        public WebDriver getCloudDriver() throws MalformedURLException {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("build", "selenium-build-1E30O");
            sauceOptions.put("name", "<Chrome Browser Parallel execution>");
            browserOptions.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://oauth-alikhanzhan-18619:5db41e2e-4695-45d2-99d8-f6a296100dd9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            WebDriver driver = new RemoteWebDriver(url, browserOptions);
            return driver;
        }
        public WebDriver getLocalDriver(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            return driver;
        }

        @AfterClass
        public void cleanUp() {
            System.out.println("Close browser");
            driver.quit();
        }
    }

