package org.ElbablyAcademy.pages.apidemos.firstactivity.views;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ElbablyAcademy.pages.apidemos.BasePage;
import org.openqa.selenium.By;

public class ViewsPage extends BasePage {
    private final By dragAndDropBtn = AppiumBy.accessibilityId("Drag and Drop");


    public ViewsPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickOnDragAndDropBtn(){
        actions.click(dragAndDropBtn);
    }
}
