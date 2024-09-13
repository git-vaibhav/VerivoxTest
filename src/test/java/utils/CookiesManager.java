package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesManager {
    WebDriverManager webDriverManager;
    WebDriver driver;

    GenericLocators genericLocators;

    WebDriverWait wait;

    public CookiesManager(WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.wait = webDriverManager.getWait();
        this.genericLocators = new GenericLocators(webDriverManager);
    }

    public void handleCookieConsent() throws InterruptedException {
        Thread.sleep(2000);

        WebElement acceptCookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uc-btn-accept-banner")));

        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        if (acceptCookiesButton.isDisplayed() && acceptCookiesButton.isEnabled()) {
            acceptCookiesButton.click();
            System.out.println("Cookie consent accepted.");
        }
    }
}
