package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenericLocators;
import utils.WebDriverManager;

import java.time.Duration;

public class PrivathaftpflichtPage {

    private WebDriverManager webDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;

    private GenericLocators genericLocators;

    Select familienstandOptions;


    @FindBy(name = "situationGroup")
    private WebElement familienstand;

    @FindBy(name = "age")
    private WebElement alter;

   // @FindBy(css = "button.page-button")
    //private WebElement jetzVergleichenButton;


    public PrivathaftpflichtPage(WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.wait = webDriverManager.getWait();
        this.genericLocators = new GenericLocators(webDriverManager);


        PageFactory.initElements(driver, this);

    }

    public void selectFamilienStand( String familyType)
    {
        if(familienstandOptions == null) {
            wait.until(ExpectedConditions.visibilityOf(familienstand));
            familienstandOptions = new Select(familienstand);
        }

            familienstandOptions.selectByVisibleText(familyType);
    }
    public void enterAlter(String age)
    {
        wait.until(ExpectedConditions.visibilityOf(alter));
        alter.clear();
        alter.sendKeys(age);
    }

    public void clickJetzVergleichenButton(String buttonText)
    {
        WebElement button = genericLocators.getButtonByText(buttonText);
    }

}



