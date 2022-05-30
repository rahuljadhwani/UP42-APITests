package utils;

import services.FetchAccessToken;

/**
 * This class will be called from all APIs when they require a token
 *
 * TO-DO: Logic can be added to not generate a new Token if Old is still valid(as validity is 5 minutes)
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class TokenManager {

    public synchronized static String getToken(){
        FetchAccessToken fetchAccessToken = new FetchAccessToken();
        return fetchAccessToken.fetchAccessToken();
    }
}
