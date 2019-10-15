package teap.testsuite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
//import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({teap.tests.Testcase_POC.class, Test1.Testcase1.class } )
//@SelectPackages({"Test1","teap.tests"})
public class Testcase_CasecsRegression {

}
