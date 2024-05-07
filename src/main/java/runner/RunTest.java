package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //Where you save your features file
        glue = "stepDef", //Your step Definition
        tags = "@RegressionLogin", //What Scenario you want to run
        plugin = {"pretty", "html:target/RegressionReport.html"} // to generate report
)
public class RunTest {

}