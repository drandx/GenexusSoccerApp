package com.genexususa.soccerapp.task1.test;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import com.genexususa.soccerapp.task1.Activities.GameResultListActivity;
import com.genexususa.soccerapp.task1.Fragments.GameResultListFragment;
import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.Networking.Responses.GameResult;
import com.genexususa.soccerapp.task1.R;

import java.util.List;

/**
 * Created by juangarcia on 4/24/15.
 */
public class GameResultListActivityTest extends ActivityInstrumentationTestCase2<GameResultListActivity> {

        private GameResultListActivity activity;

        public GameResultListActivityTest() {
            super(GameResultListActivity.class);
        }

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            setActivityInitialTouchMode(false);
            activity = getActivity();
        }

    public void testDataInitialization() {
        try {
            getInstrumentation().wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<GameResult> resultTest = TournamentManager.getInstance().getGamesResults();
        assertTrue(resultTest.size()>0);
        assertTrue(true);
    }

    private Fragment startFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.gameresult_list, fragment, "tag");
        transaction.commit();
        getInstrumentation().waitForIdleSync();
        Fragment frag = activity.getSupportFragmentManager().findFragmentById(R.id.gameresult_list);
        return frag;
    }

    public void testFragment() {
        GameResultListFragment fragment = new GameResultListFragment() {

        };
        GameResultListFragment frag = (GameResultListFragment)startFragment(fragment);
        assertTrue(frag.getAdapter().getCount()>0);
    }


}
