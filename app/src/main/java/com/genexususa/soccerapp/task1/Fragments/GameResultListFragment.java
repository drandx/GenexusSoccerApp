package com.genexususa.soccerapp.task1.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.genexususa.soccerapp.task1.Adapters.GameResultsAdapter;
import com.genexususa.soccerapp.task1.Managers.TournamentManager;
/**
 *  functionality: This class represents the code behind the List that shows the games results
 *  created:       2015-04-23
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class GameResultListFragment extends ListFragment{

    GameResultsAdapter adapter;

    private static final String STATE_ACTIVATED_POSITION = "activated_position";


    private int mActivatedPosition = ListView.INVALID_POSITION;


    public GameResultListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new GameResultsAdapter(getActivity(), TournamentManager.getInstance().getGamesResults());
        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }

    public GameResultsAdapter getAdapter() {
        return adapter;
    }
}
