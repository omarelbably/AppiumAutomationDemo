package tests.apiDemosTest;

import org.ElbablyAcademy.pages.apidemos.firstactivity.ApiDemosPage;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.apiDemosTest.TestDataModule.WifiTestData;
import org.ElbablyAcademy.utilities.readers.ConfigManager;
import org.ElbablyAcademy.utilities.readers.JsonUtils;

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
