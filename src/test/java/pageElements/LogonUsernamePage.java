package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogonUsernamePage {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    private By firstNameInput = (By.xpath("//input[@id='ap_email']"));
    private By continueButton = (By.xpath("//input[@id='continue']"));

    public LogonUsernamePage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserId (String userID) {

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstNameInput)));
        WebElement userIDInput = driver.findElement(firstNameInput);
        userIDInput.clear();
        userIDInput.sendKeys(userID);
    }

    public void clickContinueButton () {
        WebElement continueButton1 = driver.findElement(continueButton);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton1));
        if (isContinueButtonDisplayed()){
            continueButton1.click();
        }

    }

    public boolean isContinueButtonDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueButton)));
        return driver.findElement(continueButton).isDisplayed();
    }

}
