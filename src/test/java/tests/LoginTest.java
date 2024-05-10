package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageElements.HomePageWebElements;
import pageElements.LogonPasswordPage;
import pageElements.LogonUsernamePage;
import utils.JsonTestDataFetcher;

import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;



    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //open the url
        driver.get("https://www.amazon.in/");
    }

    @Test(dataProvider = "userData")
    public void performLoginFromJsonData(String userId, String password) throws InterruptedException {
        Actions actions = new Actions(driver);

        HomePageWebElements homePage = new HomePageWebElements(driver,actions);
        homePage.hoverOnAccountsAndLists();
        if (homePage.isSignButtonDisplayed()){
            homePage.clickSignInButton();
        }

        LogonUsernamePage usernamePage = new LogonUsernamePage(driver);
        usernamePage.isContinueButtonDisplayed();
        usernamePage.enterUserId(userId);
        usernamePage.clickContinueButton();

        LogonPasswordPage pwdPage = new LogonPasswordPage(driver);
        pwdPage.isSignInButtonDisplayed();
        pwdPage.enterPassword(password);
        pwdPage.clickSignInButton();
    }

    @DataProvider(name = "userData")
    public Object[][] provideData() {
        return JsonTestDataFetcher.fetchTestData();
    }

    @AfterMethod
    public void tearDown(){

        if (driver != null) {
            driver.quit();
        }

    }
}
