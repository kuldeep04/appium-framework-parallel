package org.AutomateMobile.tests;

import org.AutomateMobile.baseTest.BaseTest;
import org.AutomateMobile.pageObjects.HomePage;
import org.testng.annotations.Test;

public class PlayStoreLoginTest extends BaseTest {

    @Test
    public void testPlayStoreLogin(){
        HomePage gpsHomePage = new HomePage(driver);
        if(gpsHomePage.isHomePageDisplayed()){
            System.out.println("$############ Element found ######################################################");
        }
    }


}
