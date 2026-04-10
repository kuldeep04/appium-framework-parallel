package org.AutomateMobile.tests;

import org.AutomateMobile.baseTest.BaseTest;
import org.AutomateMobile.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.AutomateMobile.driverManager.AppDriver.getDriver;

public class PlayStoreLoginTestCase extends BaseTest {

    @Test
    public void testPlayStoreLogin(){
        HomePage gpsHomePage = new HomePage(getDriver());
        Assert.assertTrue(gpsHomePage.isHomePageDisplayed(), "Home page is not displayed");
    }

    @Test
    public void testPlayStoreLogin1(){
        HomePage gpsHomePage = new HomePage(getDriver());
        Assert.assertTrue(gpsHomePage.isHomePageDisplayed(), "Home page *****1***** is not displayed");
    }

    @Test
    public void testPlayStoreLogin2(){
        HomePage gpsHomePage = new HomePage(getDriver());
        Assert.assertTrue(gpsHomePage.isHomePageDisplayed(), "Home page *****2***** is not displayed");
    }

}
