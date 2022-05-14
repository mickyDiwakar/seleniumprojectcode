package TestRunners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
			features="src/resource/java/features",
			glue="stepDefs",
			dryRun=false,
			strict=true,
			monochrome=true,
			plugin= {"pretty","html:target/cucumber-reports/cucumber-pretty",
					"json:target/cucumber-reports/cucumberTestReport.json","rerun:target/rerun.txt"},
			tags= {"@restget"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	// {"@sokeetest","@regTEst"}== means run tc conatins both tag
		// {"@sokeetest,@regTEst"}== means run tc conatins either of the tag
		// {"~@sokeetest","@regTEst"} ==meanss exculde somketest
		  private TestNGCucumberRunner testNGcucumberRuner;
		  
		  @BeforeClass(alwaysRun=true) 
		  public void setUpClass() {
			 
			  testNGcucumberRuner=new TestNGCucumberRunner(this.getClass()); 
		  }
	/*
	 * @BeforeTest()
	 * 
	 * @Parameters({"browser"}) public void browserSelection(String browserName){
	 * 
	 * }
	 */
		  
		  @Test(dataProvider="features")  
		  public void  feature(PickleEventWrapper eventWrapper,CucumberFeatureWrapper cucumberFeature) throws  Throwable
		  { testNGcucumberRuner.runScenario(eventWrapper.getPickleEvent());
		  
		  }
		  
		  @DataProvider(parallel=false )
		  public Object[][] features(){ 
			 
			  return testNGcucumberRuner.provideScenarios();
			  }
			  
		  @AfterClass(alwaysRun=true)
		  public void teardownClass() {
				testNGcucumberRuner.finish(); 
		  }

}
