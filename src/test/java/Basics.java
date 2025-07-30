import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Basics {
    AndroidDriver driver;
    WebDriverWait wait;
    public Basics(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void appiumBasics() throws URISyntaxException, MalformedURLException, InterruptedException {
// Path URL appium SERVER, Capabilities/UIautomator
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Omar");
        options.setApp("C:\\Users\\omar_\\IdeaProjects\\AppiumMobileAutomation\\AppiumAuto\\src\\test\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        By preferenceBtn = AppiumBy.accessibilityId("Preference");
        By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiCheckBox = AppiumBy.id("android:id/checkbox");
        By wifiSettingsBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]");
        By wifiNameField = AppiumBy.id("android:id/edit");
        By okBtn = AppiumBy.id("android:id/button1");
        By viewBtn = AppiumBy.accessibilityId("Views");
        By expandableListBtn = AppiumBy.accessibilityId("Expandable Lists");
        By customAdapterBtn = AppiumBy.accessibilityId("1. Custom Adapter");
        By peopleNamesBtn = AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]");
        By switchesBtn = AppiumBy.accessibilityId("Switches");
        By galleryBtn = AppiumBy.accessibilityId("Gallery");
        By photosBtn = AppiumBy.accessibilityId("1. Photos");
        By picTwo = AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[2]");
        By dragAndDropBtn = AppiumBy.accessibilityId("Drag and Drop");
        By firstRedDot = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
//        click(preferenceBtn);
//        click(preferenceDependencies);
//        click(wifiCheckBox);
//        click(wifiSettingsBtn);
//        sendText(wifiNameField, "Omar wifi");
//        click(okBtn);

        click(viewBtn);
        click(expandableListBtn);
        pressBackBtn();
        click(dragAndDropBtn);
        dragAndDrop(firstRedDot,835,740);

//        click(galleryBtn);
//        click(photosBtn);
//        click(expandableListBtn);
//        click(customAdapterBtn);
//        longPressAction(peopleNamesBtn);
//        scrollToElement(switchesBtn,"down");
//        swipeToElement(picTwo);
//        Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(picTwo).getAttribute("focusable"),  "true");
        Thread.sleep(3000);
    }
    public void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public void sendText(By locator, String text){
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
