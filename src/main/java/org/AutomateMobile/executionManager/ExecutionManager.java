package org.AutomateMobile.executionManager;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class ExecutionManager {

    @BeforeSuite
    public void beforeSuiteSetUp(){

    }

    @AfterSuite
    public void afterSuiteSetup(){

    }

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){

    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @AfterMethod
    public void afterMethod(){

    }

    @BeforeTest
    @Parameters({"udid"})
    public abstract void setup(String udid) throws IOException;

    @AfterTest
    public abstract void cleanUp();
}
