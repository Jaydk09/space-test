import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        strict = true,
        monochrome = true,
        tags = "@spaceX_feature"
)
public class RunCukesTest {
}
