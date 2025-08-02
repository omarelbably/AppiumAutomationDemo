package org.ElbablyAcademy.pages.apidemos.firstactivity.preference.preferencedependencies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ElbablyAcademy.pages.apidemos.BasePage;
import org.openqa.selenium.By;

public class PreferenceDependenciesPage extends BasePage {
    private final By wifiCheckBox = AppiumBy.id("android:id/checkbox");
    private final By wifiSettingsBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]");
    private final By wifiNameField = AppiumBy.id("android:id/edit");
    private final By okBtn = AppiumBy.id("android:id/button1");

    public PreferenceDependenciesPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnWifiCheckBoxBtn(){
        actions.click(wifiCheckBox);
    }
    public void clickOnWifiSettingsBtn(){
        actions.click(wifiSettingsBtn);
    }
    public void setWifiName(String wifiName){
        actions.sendTextToElement(wifiNameField, wifiName);
    }
    public void clickOnOkBtn(){
        actions.click(okBtn);
    }
}
