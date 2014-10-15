package pt.forkit.androidlx_2014.rest;

import pt.forkit.androidlx_2014.rest.constants.Urls;
import retrofit.RequestInterceptor;

/**
 
 */
public class AuthorizationInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestInterceptor.RequestFacade requestFacade) {
        requestFacade.addEncodedQueryParam("client_id", Urls.SOUNDCLOUD_CLIENT_ID);
    }

}