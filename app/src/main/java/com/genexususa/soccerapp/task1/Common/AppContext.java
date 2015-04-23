package com.genexususa.soccerapp.task1.Common;

import android.app.Application;
import android.content.Context;

import com.genexususa.soccerapp.task1.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by juangarcia on 4/23/15.
 */
public class AppContext extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        context = getApplicationContext();
    }

    public static Context getContext() { return context; }
}

