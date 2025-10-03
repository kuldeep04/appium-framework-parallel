package org.AutomateMobile.baseTest;

import io.appium.java_client.AppiumDriver;
import org.AutomateMobile.driverManager.AppDriver;
import org.AutomateMobile.driverManager.DriverManager;
import org.AutomateMobile.driverManager.androidDriver.AndroidDriverFactory;
import org.testng.annotations.*;

import java.io.IOException;



public class BaseTest {

    protected AndroidDriverFactory androidDriverManager;
    public static AppiumDriver driver;

    public BaseTest(){
        this.androidDriverManager = new AndroidDriverFactory();
    }

    @BeforeTest
    public void setup() throws IOException {
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
        driver = AppDriver.getInstance().getDriver();
    }

    @AfterTest
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }

}
