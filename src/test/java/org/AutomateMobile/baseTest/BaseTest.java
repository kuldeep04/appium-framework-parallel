package org.AutomateMobile.baseTest;

import org.AutomateMobile.driverManager.AppDriver;
import org.AutomateMobile.driverManager.DriverManager;
import org.testng.annotations.*;

import java.io.IOException;
import static org.AutomateMobile.driverManager.AppDriver.getDriver;


public class BaseTest {

    public BaseTest(){}

    @Parameters({"deviceIndex"})
    @BeforeTest
    public void setup(int index) throws IOException {
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver(index);
    }

    @AfterTest
    public void cleanUp(){
        if(getDriver() != null){
            getDriver().quit();
        }

        if(AppDriver.getService() != null){
            AppDriver.getService().stop();
        }
    }

}
