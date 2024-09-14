package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    WebDriverManager webDriverManager;
    WebDriver driver;

    public Hooks( WebDriverManager webDriverManager)
    {
        this.webDriverManager = webDriverManager;
        this.driver = webDriverManager.getDriver();
    }

    @After
    public void quiteBrowser()
    {
     driver.quit();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
           File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent = FileUtils.readFileToByteArray(src);

           scenario.attach(fileContent, "image/png", "image");

        }
    }

    @Before
    public void beforeScenariosTest()
    {
        System.out.println("Starting with Cucumber Scenarios");
    }
}
