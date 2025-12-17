package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer//interface provide by testng-reexecute the failed test cases
{
	int counter=0;
	int retrylimit=1;//count of rerun
	public boolean retry(ITestResult result)//interface;result-reference variable;based on status;status pass-no execution,status fail-automatically srats.
	{
		if(counter<retrylimit) {
			counter++;
			return true;//re execution
		}
		return false;//stops execution
	}

}
