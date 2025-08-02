package org.ElbablyAcademy.pages.apidemos;

import io.appium.java_client.android.AndroidDriver;
import org.ElbablyAcademy.utilities.Actions;

public class BasePage {
    protected AndroidDriver driver;
    protected Actions actions;
    public BasePage(AndroidDriver driver){
        this.driver =driver;
        this.actions = new Actions(driver);
    }
}
