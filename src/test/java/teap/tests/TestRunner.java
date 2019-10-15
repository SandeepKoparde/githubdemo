package teap.tests;

import java.util.List;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestRunner 
{
	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) 
	{   
			final LauncherDiscoveryRequest request = 
					LauncherDiscoveryRequestBuilder.request().selectors(selectClass(Testcase_POC.class)).build();

	        final Launcher launcher = LauncherFactory.create();
	        final SummaryGeneratingListener listener = new SummaryGeneratingListener();

	        launcher.registerTestExecutionListeners(listener);
	        launcher.execute(request);

	        TestExecutionSummary summary = listener.getSummary();
	        System.out.println("Total Testcases - " + summary.getTestsFoundCount());
	        System.out.println("Testcase Succeeded - " + summary.getTestsSucceededCount());
	        System.out.println("Testcase Failed - " + summary.getTestsFailedCount());
	        System.out.println("Total Testcase Failed - " + summary.getTotalFailureCount());
	        
	        List<Failure> failures = summary.getFailures();
	        failures.forEach(failure -> System.out.println("failure - " + failure.getException()));
   }

}
