import constants.FrameworkConstants;
import listeners.TestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

/**
 * Common methods which should be executed before and after each test, test set, test suite, etc. can be placed here
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class BaseTest {


    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    /**
     * The following method would perform clean-up process, for now it deletes the data from Map after test execution is completed.
     *
     */
    @AfterSuite
    public void cleanUp(){
        FrameworkConstants.setPropertyMap(null);
    }

    public static void logData(String message){
        Reporter.log(message);
        logger.info(message);
    }


}
