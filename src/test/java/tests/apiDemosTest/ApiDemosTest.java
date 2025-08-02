package tests.apiDemosTest;

import org.ElbablyAcademy.pages.apidemos.firstactivity.ApiDemosPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.preference.PreferencePage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.preference.preferencedependencies.PreferenceDependenciesPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.views.ViewsPage;
import org.ElbablyAcademy.pages.apidemos.firstactivity.views.draganddrop.DragAndDropPage;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.apiDemosTest.TestDataModule.WifiTestData;
import utils.ConfigManager;
import utils.JsonUtils;

public class ApiDemosTest extends BaseTest {
    private WifiTestData testData;
    public ApiDemosTest(){
        this.apiDemosPage = new ApiDemosPage(driver);
        this.testData = JsonUtils.getTestData(ConfigManager.getProperty("wifi.testdata"), WifiTestData.class);
    }
    @Test
    public void wifiTest(){
        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName(testData.personalWifiName());
        preferenceDependenciesPage.clickOnOkBtn();
    }
    @Test
    public void companyWifiTest(){
        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName(testData.personalWifiName());
        preferenceDependenciesPage.clickOnOkBtn();
    }
    @Test
    public void dragAndDropTest(){
        apiDemosPage.clickOnViewsBtn();
        viewsPage.clickOnDragAndDropBtn();
        dragAndDropPage.dragFirstDotTo(835,740);
    }
}
