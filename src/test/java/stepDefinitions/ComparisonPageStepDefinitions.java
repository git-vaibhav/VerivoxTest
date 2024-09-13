package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PrivathaftpflichtDataEntryPage;
import pages.PrivathaftpflichtPage;
import pages.RecommendationResultPage;
import utils.WebDriverManager;

public class ComparisonPageStepDefinitions {

    private WebDriverManager webDriverManager;
    private WebDriver driver;

    private RecommendationResultPage recommendationResultPage;

        public ComparisonPageStepDefinitions(WebDriverManager webDriverManager)
        {
            this.webDriverManager = webDriverManager;
            this.driver = webDriverManager.getDriver();
            this.recommendationResultPage = new RecommendationResultPage(webDriverManager);
        }

    @Then("I should see a page that lists the available tariffs for my selection")
    public void i_should_see_a_page_that_lists_the_available_tariffs_for_my_selection() throws InterruptedException {
            recommendationResultPage.verifyIfProductListLoaded();

    }

    @And("I should see the total number of available tariffs listed above all the result list")
    public void iShouldSeeTheTotalNumberOfAvailableTariffsListedAboveAllTheResultList() {
            recommendationResultPage.verifySummaryPresentOnResultPage();
    }

    @When("I scroll to the end of the result list page")
    public void iScrollToTheEndOfTheResultListPage() {

    }

    @Then("I should see only the first {int} tariffs displayed")
    public void iShouldSeeOnlyTheFirstTariffsDisplayed(int arg0) {
            recommendationResultPage.verifyOnly20TariffDisplayedOnFirstPage(arg0);
    }

    @When("I click on the button labeled {int} weitere Tarife laden")
    public void iClickOnTheButtonLabeledWeitereTarifeLaden(int arg0) {
            recommendationResultPage.loadNext20Products();

    }

    @Then("I should see the next {int} tariffs displayed")
    public void iShouldSeeTheNextTariffsDisplayed(int arg0) {
        recommendationResultPage.verify20ResultsDisplayedwhenUserClickOnLoad20More();
    }

    @And("I can continue to load any additional tariffs until all tariffs have been displayed")
    public void iCanContinueToLoadAnyAdditionalTariffsUntilAllTariffsHaveBeenDisplayed() {
            recommendationResultPage.loadAllProductsandVerifyTotalCount();

    }
}
