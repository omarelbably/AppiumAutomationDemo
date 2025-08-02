package org.ElbablyAcademy.pages.apidemos.firstactivity.preference;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ElbablyAcademy.pages.apidemos.BasePage;
import org.openqa.selenium.By;

public class PreferencePage extends BasePage {
    private final By preferenceDependenciesBtn = AppiumBy.accessibilityId("3. Preference dependencies");

    public PreferencePage(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnPreferenceDependenciesBtn(){
        actions.click(preferenceDependenciesBtn);
    }
}
