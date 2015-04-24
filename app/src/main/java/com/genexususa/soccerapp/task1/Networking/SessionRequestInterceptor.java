package com.genexususa.soccerapp.task1.Networking;

import retrofit.RequestInterceptor;

/**
 *  functionality: This is an HTTP filter or interceptor.
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class SessionRequestInterceptor implements RequestInterceptor {
    private static final String TAG = SessionRequestInterceptor.class.getSimpleName();

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Content-Type", "application/json");//you can add header here if you need in your api
    }
}