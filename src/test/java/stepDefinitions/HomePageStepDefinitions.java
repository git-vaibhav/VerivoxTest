package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.WebDriverManager;

import java.io.IOException;

public class HomePageStepDefinitions {
    private WebDriverManager webDriverManager;
    private WebDriver driver;

    HomePage homePage;


    public HomePageStepDefinitions(WebDriverManager webDriverManager) throws IOException {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.homePage = new HomePage(webDriverManager);
        PageFactory.initElements(driver, this);
    }

    @When("^I navigate to (.+) and select (.+)")
    public void i_navigate_to_versicherungen_and_select_privathaftpflicht(String productType, String subProductType) {
        homePage.hoverOnVersicherungen(productType);
        homePage.clickPrivathaftpflicht(subProductType);
    }
}
