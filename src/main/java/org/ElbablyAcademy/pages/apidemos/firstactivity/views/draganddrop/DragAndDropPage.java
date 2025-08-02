package org.ElbablyAcademy.pages.apidemos.firstactivity.views.draganddrop;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ElbablyAcademy.pages.apidemos.BasePage;
import org.openqa.selenium.By;

public class DragAndDropPage extends BasePage {
    private final By firstRedDot = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

    public DragAndDropPage(AndroidDriver driver) {
        super(driver);
    }

    public void dragFirstDotTo(int x, int y){
        actions.dragAndDrop(firstRedDot,x,y);
    }
}
