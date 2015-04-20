package com.genexususa.soccerapp.task1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.genexususa.soccerapp.task1.Fragments.GameResultDetailFragment;
import com.genexususa.soccerapp.task1.Fragments.GameResultListFragment;
import com.genexususa.soccerapp.task1.Networking.Responses.TournamentsResponse;
import com.genexususa.soccerapp.task1.R;

import com.genexususa.soccerapp.task1.Networking.RestClient;
import com.genexususa.soccerapp.task1.Networking.Responses.WeatherResponse;


import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * An activity representing a list of GamesResults. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link GameResultDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link com.genexususa.soccerapp.task1.Fragments.GameResultListFragment} and the item details
 * (if present) is a {@link com.genexususa.soccerapp.task1.Fragments.GameResultDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link com.genexususa.soccerapp.task1.Fragments.GameResultListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class GameResultListActivity extends FragmentActivity
        implements GameResultListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameresult_list);
        Log.i("**** Before The Call", "....");

        /*
        RestClient.get().getWeather("California", new Callback<WeatherResponse>() {
            @Override
                public void success(WeatherResponse weatherResponse, Response response) {
                    // success!
                    Log.i("App", weatherResponse.getBase());
                    //Log.i("App", weatherResponse.getWeather().getMain());
                    //Log.i("App", weatherResponse.getWeather().getDescription());
                    // you get the point...
                }

                @Override
                public void failure(RetrofitError error) {
                    // something went wrong
                }
            });*/


        RestClient.get().getGamesResults("{\"include\": [{\"groups\": {\"games\":\"gameParticipant\"}}]}", new Callback<List<TournamentsResponse>>() {
            @Override
                public void success(List<TournamentsResponse> tournamentsResponse, Response response) {
                    // success!
                    Log.i("Number of Tournaments: ", "--->"+tournamentsResponse.size());
                    //Log.i("App", weatherResponse.getWeather().getMain());
                    //Log.i("App", weatherResponse.getWeather().getDescription());
                    // you get the point...
                }

                @Override
                public void failure(RetrofitError error) {
                    // something went wrong
                }
            });


        if (findViewById(R.id.gameresult_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((GameResultListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.gameresult_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link GameResultListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(GameResultDetailFragment.ARG_ITEM_ID, id);
            GameResultDetailFragment fragment = new GameResultDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.gameresult_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, GameResultDetailActivity.class);
            detailIntent.putExtra(GameResultDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
