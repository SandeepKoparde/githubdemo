package demo.testsuite;

import org.junit.platform.runner.JUnitPlatform;
//import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("demo.tests")		//See note in the class body below.
//@SelectClasses( demo.tests.DemoTestcase.class )
//@SelectClasses({teap.tests.Testcase_POC.class, teap.tests.Testcase2.class } )
//@SelectPackages({"Test1","teap.tests"})
//@SelectPackages("Test1");
public class Testcase_DemoRegression {
	
	/*
	 * 					IMPORTANT NOTE
	 * 
	 * Its mandatory to have test class names to follow regex pattern ^.*Tests?$. 
	 * It means that test class names MUST end with Test or Tests. 
	 * e.g. UserMgmtTests, DeviceMgmtTest etc.
	 */

}
