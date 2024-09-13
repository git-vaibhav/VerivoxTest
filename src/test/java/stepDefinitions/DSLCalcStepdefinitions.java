package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.HomePage;
import pages.PrivathaftpflichtDataEntryPage;
import pages.PrivathaftpflichtPage;
import utils.CookiesManager;
import utils.GenericLocators;
import utils.WebDriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class DSLCalcStepdefinitions{

    private WebDriver driver;
    private WebDriverManager webDriverManager;

    private CookiesManager cookiesManager;

    private PrivathaftpflichtPage privathaftpflichtPage;

    private PrivathaftpflichtDataEntryPage privathaftpflichtDataEntryPage;
    private HomePage homePage;

    private GenericLocators genericLocators;
    String expectedPageTitle = "VERIVOX | Tarife vergleichen & stressfrei sparen!";

    public DSLCalcStepdefinitions(WebDriverManager webDriverManager) throws IOException {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
        this.privathaftpflichtPage = new PrivathaftpflichtPage(webDriverManager);
        this.privathaftpflichtDataEntryPage = new PrivathaftpflichtDataEntryPage(webDriverManager);
        this.homePage = new HomePage(webDriverManager);
        this.cookiesManager = new CookiesManager(webDriverManager);
        this.genericLocators = new GenericLocators(webDriverManager);
    }

    @Given("that I can open verivox de")
    public void that_i_can_open_verivox_de() throws InterruptedException, IOException {
        homePage.launchVerivoxApplication();
        cookiesManager.handleCookieConsent();

        Assert.assertEquals(homePage.getHomePageTitle(), expectedPageTitle);





    }

    @When("^I enter my Age (.+) and Family Type(.+)$")
    public void i_enter_my_age_and_family_type_single_ohne_kinder( String age, String familyType) {
        privathaftpflichtPage.selectFamilienStand(familyType);
        privathaftpflichtPage.enterAlter(age);
    }


    @Then("^I go to the Privathaftpflicht personal information page by clicking on (.+)$")
    public void i_go_to_the_privathaftpflicht_personal_information_page( String buttonText) {
        //privathaftpflichtPage.clickJetzVergleichenButton(buttonText);
        System.out.println(buttonText);
        WebElement button = genericLocators.getButtonByText(buttonText);
        button.click();
    }
    @Then("^I enter my Date of Birth(.+)$")
    public void i_enter_my_birth_date(String dateOfBirth) {
       // privathaftpflichtDataEntryPage.validateFamilienStad();
        privathaftpflichtDataEntryPage.enterDateOfBirth(dateOfBirth);

    }
    @Then("^I enter my Zip Code(.+)$")
    public void i_enter_my_zip_code_use(String zipCode) {
        privathaftpflichtDataEntryPage.enterPostCode(zipCode);

    }
    @Then("^I click the Jetzt vergleichen (.+)$")
    public void i_click_the_jetzt_vergleichen_button(String buttonText) {
        //privathaftpflichtDataEntryPage.clickjetztvergleichenButton(buttonText);
       WebElement button =  genericLocators.getButtonByText(buttonText);
       button.click();

    }

}
