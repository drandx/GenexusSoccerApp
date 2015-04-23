package com.genexususa.soccerapp.task1.Common;

import android.app.Application;
import android.content.Context;

/**
 * Created by juangarcia on 4/23/15.
 */
public class AppContext extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() { return context; }
}

