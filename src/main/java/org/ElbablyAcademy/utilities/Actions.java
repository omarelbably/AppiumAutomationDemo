package org.ElbablyAcademy.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions {
    private final WebDriverWait wait;
    private final AndroidDriver driver;
    public Actions(AndroidDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.driver = driver;
    }

    public void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public void sendTextToElement(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void longPressAction(By locator){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId()
        ));
    }
    public void scrollToElement(By locator, String upOrDown){
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 2500,
                "direction", upOrDown.toLowerCase(),
                "percent", 3.0
        ));
    }
    public void swipeToElement(By locator){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId(),
                "direction", "right",
                "percent", 0.01
        ));
    }
    public void pressBackBtn(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void dragAndDrop(By locator, int endX, int endY){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
}
