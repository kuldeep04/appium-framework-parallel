package org.AutomateMobile.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver){
        this.driver = driver;
    }

    private static final By homePageText = By.xpath("//android.widget.TextView[@text=\"API Demos\"]");

    public boolean isHomePageDisplayed(){
        if(driver != null){
           return driver.findElement(homePageText).isDisplayed();
        }
        return false;
    }

}

