package com.genexususa.soccerapp.task1.test;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import com.genexususa.soccerapp.task1.Activities.GameResultListActivity;
import com.genexususa.soccerapp.task1.Fragments.GameResultListFragment;
import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.Networking.Responses.GameResult;
import com.genexususa.soccerapp.task1.R;

import java.util.List;

/**
 *  functionality: Class that tests data initialization and correctness in UI components creation.
 *  created:       2015-04-23
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
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

    /**
     *  functionality: This method tests the right initialization of the data
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/
    public void testDataInitialization() {
        SystemClock.sleep(3000);
        List<GameResult> resultTest = TournamentManager.getInstance().getGamesResults();
        assertTrue(resultTest.size()>0);
        assertTrue(true);
    }

    /**
     *  functionality: This method sets up the activity that contains the fragment
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/
    private Fragment startFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.gameresult_list, fragment, "tag");
        transaction.commit();
        getInstrumentation().waitForIdleSync();
        Fragment frag = activity.getSupportFragmentManager().findFragmentById(R.id.gameresult_list);
        return frag;
    }

    /**
     *  functionality: This method tests the initialization of the fragment
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/
    public void testFragment() {
        GameResultListFragment fragment = new GameResultListFragment() {

        };
        GameResultListFragment frag = (GameResultListFragment)startFragment(fragment);
        assertTrue(frag.getAdapter().getCount()>0);
    }


}
