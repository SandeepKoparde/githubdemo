package teap.testsuite;

import org.junit.platform.runner.JUnitPlatform;
//import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("demo.tests")
//@SelectClasses( demo.tests.DemoTestcase.class )
//@SelectClasses({teap.tests.Testcase_POC.class, teap.tests.Testcase2.class } )
//@SelectPackages({"Test1","teap.tests"})
//@SelectPackages("Test1");
public class Testcase_CasecsRegression {

}
