package com.genexususa.soccerapp.task1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genexususa.soccerapp.task1.R;

/**
 * A fragment representing a single GameResult detail screen.
 * This fragment is either contained in a {@link com.genexususa.soccerapp.task1.Activities.GameResultListActivity}
 * in two-pane mode (on tablets) or a {@link com.genexususa.soccerapp.task1.Activities.GameResultDetailActivity}
 * on handsets.
 */
public class GameResultDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GameResultDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gameresult_detail, container, false);

        return rootView;
    }
}
