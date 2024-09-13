package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericLocators {

    private WebDriverManager webDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;

    public GenericLocators(WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.wait = webDriverManager.getWait();

    }

    public WebElement getLinkByText(String linkText)
    {
        By linkLocator = By.linkText(linkText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(linkLocator));
    }

    public WebElement getButtonByText( String buttonName)
    {
        //By buttonLocator = By.xpath("//button[.='"+buttonName+"']");
        By buttonLocator = By.xpath("//button[normalize-space()='"+buttonName+"']");

        //button[normalize-space()='Jetzt vergleichen']

        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));

    }

}
