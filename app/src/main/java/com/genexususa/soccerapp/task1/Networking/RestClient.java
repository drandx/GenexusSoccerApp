package com.genexususa.soccerapp.task1.Networking;


import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;


/**
 *  functionality:
 *  created:       2015-04-20
 *  @author:       Juan Garcia
 *  changes:
 **/

public class RestClient {

    private static Restapi REST_CLIENT;
    private static String ROOT = "http://104.43.136.168:3000/api";

    static {
        setupRestClient();
    }

    public static Restapi get() {
        return REST_CLIENT;
    }



    /**
     *  functionality:
     *  @author:
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/

    private static void setupRestClient() {


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ROOT)
                .setClient(new OkClient(new OkHttpClient()))
                .setRequestInterceptor(new SessionRequestInterceptor())
                .build();

        REST_CLIENT = restAdapter.create(Restapi.class);
    }
}