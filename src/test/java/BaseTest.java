import constants.FrameworkConstants;
import org.testng.annotations.AfterTest;

/**
 * Common methods which should be executed before and after each test, test set, test suite, etc. can be placed here
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class BaseTest {

    @AfterTest
    public void cleanUp(){
        FrameworkConstants.setPropertyMap(null);
    }


}
