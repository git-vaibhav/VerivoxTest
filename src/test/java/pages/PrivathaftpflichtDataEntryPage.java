package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GenericLocators;
import utils.WebDriverManager;

public class PrivathaftpflichtDataEntryPage {


    private WebDriverManager webDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;

    private GenericLocators genericLocators;

    @FindBy(id = "prestep_insureGroup-select")
    private WebElement familienStand;

    @FindBy(css = "input[placeholder='TT.MM.JJJJ']")
    private WebElement dobInput;

    @FindBy(id = "prestep_postcode-input")
    private WebElement postCode;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement jetztvergleichenButton;



        // Constructor
        public PrivathaftpflichtDataEntryPage(WebDriverManager webDriverManager) {

            this.webDriverManager = webDriverManager;
            this.driver = webDriverManager.getDriver();
            this.wait = webDriverManager.getWait();
            PageFactory.initElements(driver, this);
        }

//        public void validateFamilienStad()
//        {
//            wait.until(ExpectedConditions.visibilityOf(familienStand));
//            String familienStandText = familienStand.getText();
//            System.out.println(familienStandText);
//            Assert.assertEquals(familienStandText, "Single ohne Kinder");
//
//        }

        public void enterDateOfBirth(String dateOfBirth)
        {
            wait.until(ExpectedConditions.visibilityOf(dobInput));
            dobInput.clear();
            dobInput.sendKeys(dateOfBirth);
        }

        public void enterPostCode(String zipCode)
        {
            wait.until(ExpectedConditions.visibilityOf(postCode));
            postCode.sendKeys(zipCode);

        }

        public void clickjetztvergleichenButton(String buttonText)
        {
            WebElement button = genericLocators.getButtonByText(buttonText);
            button.click();
        }

}
