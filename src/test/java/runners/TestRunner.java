package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@regression",
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json"},
        glue = {"steps"},
        dryRun = false
    )
public class TestRunner {}