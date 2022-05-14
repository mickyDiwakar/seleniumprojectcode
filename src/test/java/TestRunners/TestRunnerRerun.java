package TestRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="@target/rerun.txt",
		glue= "\\src\\test\\java\\stepDefs", 
		dryRun=false, //check the definiton is define or not if not it will will display the method in console when it is set to true
		strict=true,//check defintion
		monochrome=true,// shwo error in readable format
		plugin= {"pretty","html:target1/cucumber-reports/cucumber-pretty",
				"json:target1/cucumber-reports/cucumberTestReport.json"},
		tags= {"@Demo"}    //{"@sokeetest","@regTEst"}== means run tc conatins both tag
		)
public class TestRunnerRerun extends AbstractTestNGCucumberTests {
		

}
