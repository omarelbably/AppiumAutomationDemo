package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.ElbablyAcademy.pages.apidemos.firstactivity.ApiDemosPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.preference.PreferencePage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.preference.preferencedependencies.PreferenceDependenciesPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.views.ViewsPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.views.draganddrop.DragAndDropPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.ElbablyAcademy.utilities.readers.ConfigManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {
    private final AppiumDriverLocalService appiumServer;
    protected AndroidDriver driver;
    protected ApiDemosPage apiDemosPage;
    protected PreferencePage preferencePage;
    protected PreferenceDependenciesPage preferenceDependenciesPage;
    protected ViewsPage viewsPage;
    protected DragAndDropPage dragAndDropPage;
    private Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public BaseTest(){
        ConfigManager.initialize();
        this.appiumServer = new AppiumServiceBuilder()
                .withAppiumJS(new File(ConfigManager.getProperty("main.js.path")))
                .withIPAddress(ConfigManager.getProperty("ip.address")).usingPort(Integer.parseInt(ConfigManager.getProperty("port.number"))).build();
    }
    @BeforeClass
    public void initAppiumServer(){
        if (appiumServer.isRunning()){
            logger.info("The server is running");
        }else {
            appiumServer.start();
        }
    }
    @BeforeMethod
    public void startDriver() throws URISyntaxException, MalformedURLException {
        createDriver();
        createObjects();
    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
    @AfterClass
    public void closeAppiumServer(){
        appiumServer.stop();
    }
    public void createDriver() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(ConfigManager.getProperty("device.name"));
        options.setApp(ConfigManager.getProperty("app.path"));

        driver = new AndroidDriver(new URI(ConfigManager.getProperty("appium.url")).toURL(),options);
    }
    public void createObjects(){
        this.apiDemosPage = new ApiDemosPage(driver);
        this.preferencePage = new PreferencePage(driver);
        this.preferenceDependenciesPage = new PreferenceDependenciesPage(driver);
        this.viewsPage = new ViewsPage(driver);
        this.dragAndDropPage = new DragAndDropPage(driver);
    }
}
