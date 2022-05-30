import constants.FrameworkConstants;
import org.testng.annotations.AfterSuite;

/**
 * Common methods which should be executed before and after each test, test set, test suite, etc. can be placed here
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class BaseTest {


    /**
     * The following method would perform clean-up process, for now it deletes the data from Map after test execution is completed.
     *
     */
    @AfterSuite
    public void cleanUp(){
        FrameworkConstants.setPropertyMap(null);
    }


}
