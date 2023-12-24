package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        		
		features="E:\\Java\\Latest Eclipse\\Demo_Workspace\\CucumberAutomation\\Features\\Login.feature",
	    glue = "stepDefinitions",
	    dryRun=false,
	    monochrome=true,
	    plugin= {"pretty","html:test-output"}
	    //tags= "@sanity"
		
		)

  

public class TestRun {
	
	
}
