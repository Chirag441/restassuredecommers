package runnerfile;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/FeatureFile",glue = "StepDefination",tags = "@test")
public class TestRunner extends AbstractTestNGCucumberTests {
}
