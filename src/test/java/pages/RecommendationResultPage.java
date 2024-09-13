package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecommendationResultPage {

    private WebDriverManager webDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//product")
    List<WebElement> productListElements;

    @FindBy(xpath = "//a[@class='button load-more-button']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//div[@class='filtered']/filtered-products-hint/span[1]")
    private WebElement tariffSummary;
    public RecommendationResultPage(WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.wait = webDriverManager.getWait();

        PageFactory.initElements(driver, this);
    }

    public void verifyIfProductListLoaded() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//product")));
        System.out.println(productListElements.size());
    }

    public void verifySummaryPresentOnResultPage()
    {
        String summaryText =  getElementText(tariffSummary);
        System.out.println(summaryText);
        String pattern = "\\d+ Tarife von \\d{1,3},\\d{2} € bis \\d{1,3},\\d{2} €";
        Pattern compilePattern = Pattern.compile(pattern);

        Matcher matcher = compilePattern.matcher(summaryText);
        Assert.assertTrue(matcher.matches(), "Text does not match the expected pattern!");
    }

    public String getElementText(WebElement webElement)
    {
       return webElement.getText();
    }

    Boolean firstPage = true;
    int actualProductCount = 0;
    public void verifyOnly20TariffDisplayedOnFirstPage( int arg) {
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));

        if (loadMoreButton.isEnabled()) {
            Assert.assertEquals(productListElements.size(), arg + 1, "Number of Products displayed is incorrect");
            actualProductCount = productListElements.size() - 1;
        } else {
            actualProductCount = actualProductCount + productListElements.size()-1;
        }
    }

    public void verify20ResultsDisplayedwhenUserClickOnLoad20More()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));

        if (loadMoreButton.isEnabled()) {
            actualProductCount = actualProductCount + productListElements.size()-1;
            System.out.println(actualProductCount);
        }

        if (!loadMoreButton.isEnabled())
        {
                actualProductCount = actualProductCount+productListElements.size()-1;
                System.out.println(actualProductCount);
        }

    }


    public void loadNext20Products()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));
        loadMoreButton.click();
    }

    public void loadAllProductsandVerifyTotalCount()
    {
        while(true)
        {
            wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));

            if(loadMoreButton.isEnabled()) {
                loadMoreButton.click();
            }
            actualProductCount = actualProductCount+productListElements.size()-1;
            System.out.println("Actual Count ="+ actualProductCount);

            if(!loadMoreButton.isEnabled())
            {
                break;
            }

        }
    }
    public void later()
    {
        String totalNumberOfProduct = getElementText(tariffSummary).split("Tarif")[0];
        System.out.println(totalNumberOfProduct);
    }

}
