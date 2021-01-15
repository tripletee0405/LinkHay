package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CreateNewCustomer extends BaseTest {
    @Test(dataProvider = "test-data")
    public void testCreateNewCustomer(String EmailOrPhoneNumber){

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.openLoginPopUp("https://linkhay.com/");

        loginPage.loginOnPopUp(EmailOrPhoneNumber);

    }
    @DataProvider(name = "test-data")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTableArray("data.xlsx", "b",0,1);
    }
}