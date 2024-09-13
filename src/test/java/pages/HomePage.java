    package pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import utils.GenericLocators;
    import utils.WebDriverManager;

    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Properties;


    public class HomePage {

        private WebDriverManager webDriverManager;
        private  WebDriver driver;
        private Actions actions;
        private WebDriverWait wait;
        Properties properties = new Properties();
        FileInputStream fileInputStream;

        GenericLocators genericLocators;

        public HomePage(WebDriverManager webDriverManager) throws IOException {
            this.webDriverManager = webDriverManager;
            this.driver = webDriverManager.getDriver();
            this.actions = new Actions(driver);
            this.wait = webDriverManager.getWait();
            this.genericLocators = new GenericLocators(webDriverManager);
            PageFactory.initElements(driver, this);

            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/environment.properties");
            properties.load(fileInputStream);
        }



        public void hoverOnVersicherungen(String linkText)
        {
            WebElement linkElement = genericLocators.getLinkByText(linkText);
            actions.moveToElement(linkElement).perform();
            System.out.println("Navigated to Versicherungen page.");
        }
        public void clickPrivathaftpflicht(String subProductType) {
            WebElement linkElement = genericLocators.getLinkByText(subProductType);
            linkElement.click();
        }

        public void launchVerivoxApplication()
        {
            String url = properties.getProperty("ApplicationURL");
            driver.get(url);
        }

        public  String getHomePageTitle()
        {
           return driver.getTitle();
        }
    }
