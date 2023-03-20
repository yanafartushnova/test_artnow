package Users;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import SetUp.Screenshot;
public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result){
        Screenshot.makeScreen();
    }
}
