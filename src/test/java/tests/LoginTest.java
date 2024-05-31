package tests;

import core.BaseTest;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageElements.HomePageWebElements;
import pageElements.LogonPasswordPage;
import pageElements.LogonUsernamePage;
import utils.ExtentReport;
import utils.JsonSearchDataFetcher;
import utils.JsonTestDataFetcher;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private static WebDriver driver;

    @BeforeTest(groups="SmokeSuite")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //open the url
        driver.get("https://www.amazon.in/");

    }

    @Test(dataProvider = "userData" ,groups="SmokeSuite")

    public void performLoginFromJsonData(String userId, String password) {
        ExtentReport.extentlog = ExtentReport.extentreport.
                startTest("performLoginFromJsonData","Login Test ");
        Actions actions = new Actions(driver);
        HomePageWebElements homePageWithActions = new HomePageWebElements(driver,actions);
        HomePageWebElements homePage = new HomePageWebElements(driver);
        LogonUsernamePage usernamePage = new LogonUsernamePage(driver);
        LogonPasswordPage pwdPage = new LogonPasswordPage(driver);

//        HomePageWebElements homePage = new HomePageWebElements(driver,actions);
        homePageWithActions.hoverOnAccountsAndLists();
        if (homePage.isSignButtonDisplayed()){
            homePage.clickSignInButton();
        }

        usernamePage.isContinueButtonDisplayed();
        usernamePage.enterUserId(userId);
        usernamePage.clickContinueButton();

        pwdPage.isSignInButtonDisplayed();
        pwdPage.enterPassword(password);
        pwdPage.clickSignInButton();
//        Thread.sleep(5000);

        homePage.isLoggedIn();

    }

    @Test(dataProvider = "searchData", groups="SmokeSuite")
    public void performSearchFromJsonData(String text) throws InterruptedException {


//        performLoginFromJsonData();
//        Actions actions = new Actions(driver);
//        HomePageWebElements homePageWithActions = new HomePageWebElements(driver,actions);
//        HomePageWebElements homePage = new HomePageWebElements(driver);
//        LogonUsernamePage usernamePage = new LogonUsernamePage(driver);
//        LogonPasswordPage pwdPage = new LogonPasswordPage(driver);


        ExtentReport.extentlog = ExtentReport.extentreport.startTest("performSearchFromJsonData","performSearchFromJsonData for - "+text );
        System.out.println(text);
        Thread.sleep(5000);
    }

    @DataProvider(name = "userData")
    public Object[][] provideData() {
        return JsonTestDataFetcher.fetchTestData();
    }

    @DataProvider(name = "searchData")
    public Object[] provideSearchData() {
        return JsonSearchDataFetcher.fetchTestData();
    }

    @AfterTest
    public void tearDown(){

        if (driver != null) {
            driver.quit();
        }

    }
}
