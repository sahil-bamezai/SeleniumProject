package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogonPasswordPage {

    private WebDriver driver;
    public LogonPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//    driver.manage().timeout().implicitlyWaits()

    private By passwordElement = (By.xpath("//input[@id='ap_password']"));
    private By signInSubmit = By.id("signInSubmit");



    public void enterPassword (String password) {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(passwordElement)));
        WebElement passwordInput = driver.findElement(passwordElement);
//        userIDInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton () {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInSubmit)));
        WebElement signInButton = driver.findElement(signInSubmit);
        if (isSignInButtonDisplayed()){
            signInButton.click();
        }

    }

    public boolean isSignInButtonDisplayed() {
        return driver.findElement(signInSubmit).isDisplayed();
    }

}
