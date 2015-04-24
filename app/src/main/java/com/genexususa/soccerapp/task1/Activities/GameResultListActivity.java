package com.genexususa.soccerapp.task1.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 *  functionality: This is the launcher activity that initializes the ListFragment.
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class GameResultListActivity extends ActionBarActivity{

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
