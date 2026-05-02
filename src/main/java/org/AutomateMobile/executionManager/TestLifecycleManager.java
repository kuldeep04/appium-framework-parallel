package org.AutomateMobile.executionManager;

import org.AutomateMobile.Utils.LoggerUtils;
import org.AutomateMobile.driverManager.AppDriver;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class TestLifecycleManager extends LoggerUtils {

    @BeforeSuite
    public void beforeSuiteSetUp() {
        log.info("Starting Suite Execution");
    }

    @AfterSuite
    public void afterSuiteTearDown(){
        log.info("Finished Suite Execution");
        if(AppDriver.getService() != null){
            AppDriver.getService().stop();
        }
    }

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){

    }

    @BeforeMethod
    public void beforeMethod() throws IOException {

    }

    @AfterMethod
    public void afterMethod(){

    }

    @BeforeTest
    public abstract void beforeTestSetup() throws IOException;

    @AfterTest
    public abstract void afterTestTearDown();
}
