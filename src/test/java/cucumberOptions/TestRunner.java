package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features="src/test/resources/features", glue="stepDefinitions",
        monochrome=true, dryRun=false , plugin={"pretty","html:target/TestRunResult.html", "json:target/TestRunResult.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},tags = "")
public class TestRunner extends AbstractTestNGCucumberTests {

//    @DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
 //   }
}
