package com.genexususa.soccerapp.task1.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class GameResultListActivity extends ActionBarActivity{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameresult_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d("onCreate", "Before loading data from manager...");
        TournamentManager.getInstance().InitData();
        Log.d("onCreate", "...After  loading data from manager");

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
