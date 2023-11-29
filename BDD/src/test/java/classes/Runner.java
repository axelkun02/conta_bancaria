package classes;
import org.junit.runner.RunWith;	
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/java/arquivo_teste.feature", tags = "@tag", glue = "classes")
public class Runner {

}
