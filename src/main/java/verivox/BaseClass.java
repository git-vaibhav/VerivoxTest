package verivox;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {


    public static void acceptCookiesIfPresent(WebDriver driver) {
        try {
            // Attempt to find and click the cookie consent button
            WebElement acceptButton = driver.findElement(By.id("uc-btn-accept-banner")); // Replace with actual locator
            acceptButton.click();
            System.out.println("Cookie consent accepted.");
        } catch (NoSuchElementException e) {
            // If the button is not found, proceed without any action
            System.out.println("No cookie consent banner present, continuing with the next step.");
        }

    }

}
