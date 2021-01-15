package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Login Page Element
    @FindBy(xpath = "//strong[text()='Đăng nhập']")
    private WebElement linkLoginPage;
    @FindBy(xpath = "//input[@id='account']")
    private WebElement inputEmailOrPhoneNumber;
    @FindBy(xpath = "//a[@class='btn btn-blue btn-next btn-login']")
    private WebElement nextBtn;
    @FindBy(xpath = "//iframe[@id='login_box_frame']")
    private WebElement loginPopUpFrame;



    public void openLoginPopUp(String loginUrl){
        driver.navigate().to(loginUrl);
        driver.manage().window().maximize();
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text()='Đăng nhập']")));
        linkLoginPage.click();
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='login_box_frame']")));
        driver.switchTo().frame("login_box_frame");
    }


    public void loginOnPopUp(String EmailOrPhoneNumber){
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='account']")));
        inputEmailOrPhoneNumber.sendKeys(EmailOrPhoneNumber);
        nextBtn.click();
    }
}
