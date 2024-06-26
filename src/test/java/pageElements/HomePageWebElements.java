package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePageWebElements {

    private WebDriver driver;
    private Actions actions;
    public HomePageWebElements(WebDriver driver){
        this.driver = driver;
    }

    public HomePageWebElements(WebDriver driver, Actions action){
        this.driver = driver;
        this.actions = action;
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    private By accountAndLists = By.xpath("//a[@id='nav-link-accountList']");
    private By signInButton = (By.cssSelector(".nav-action-signin-button"));
    private By helloElement = By.id("nav-link-accountList-nav-line-1");
    private By searchBar = By.id("#twotabsearchtextbox");

    private By allSearchDropdownButton = By.id("#searchDropdownBox");
    private By allButton = By.id("nav-hamburger-menu");
    private By searchButton = By.id("nav-search-submit-button");



    public void clickAccountsAndLists () {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(accountAndLists)));
        WebElement accountAndList = driver.findElement(accountAndLists);
        accountAndList.click();
    }

    public void hoverOnAccountsAndLists () {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(accountAndLists)));
        WebElement accountAndList = driver.findElement(accountAndLists);
        actions.moveToElement(accountAndList).build().perform();

    }

    public void clickSignInButton () {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButton)));
        WebElement signIn = driver.findElement(signInButton);
        signIn.click();
    }

    public boolean isSignButtonDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButton)));
        return driver.findElement(signInButton).isDisplayed();
    }

    public boolean isLoggedIn() {
        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(helloElement), "Hello, Sahil") );
//        return driver.findElement(helloElement).isDisplayed();
    }
}
