package utils;

import services.FetchAccessToken;

public class TokenManager {

    public synchronized static String getToken(){
        FetchAccessToken fetchAccessToken = new FetchAccessToken();
        return fetchAccessToken.fetchAccessToken();
    }
}
