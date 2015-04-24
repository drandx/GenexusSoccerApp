package com.genexususa.soccerapp.task1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.Model.GameParticipant;
import com.genexususa.soccerapp.task1.Model.Team;
import com.genexususa.soccerapp.task1.Networking.Responses.GameResult;
import com.genexususa.soccerapp.task1.R;
import com.genexususa.soccerapp.task1.Utils.TournamentObserver;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *  functionality: This is the data adapter that represents each list row according to the task requirements.
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class GameResultsAdapter extends BaseAdapter implements TournamentObserver {

    Context context;
    List<GameResult> rowItem;

    public GameResultsAdapter(Context context, List<GameResult> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
        TournamentManager.getInstance().addObserver(this);
    }

    @Override
    public int getCount() {
        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.results_list_item, null);
        }
        GameResult gameRow = rowItem.get(position);

        ImageView localLogo = (ImageView) convertView.findViewById(R.id.iconLocal);
        ImageView visitorLogo = (ImageView) convertView.findViewById(R.id.iconVisitor);

        TextView localNameTxt = (TextView) convertView.findViewById(R.id.localTeamNameText);
        TextView visitorNameTxt = (TextView) convertView.findViewById(R.id.visitorTeamTxt);
        TextView localScoreTxt = (TextView) convertView.findViewById(R.id.localScoreTxt);
        TextView visitorScoreTxt = (TextView) convertView.findViewById(R.id.visitorScoreText);
        TextView dayNumberTxt = (TextView) convertView.findViewById(R.id.dayNumberTxt);
        TextView monthNameTxt = (TextView) convertView.findViewById(R.id.monthNameTxt);
        TextView yearNumberTxt = (TextView) convertView.findViewById(R.id.yearNumberTxt);
        TextView hourStringTxt = (TextView) convertView.findViewById(R.id.hourStringTxt);
        TextView resultTitle = (TextView) convertView.findViewById(R.id.resultTitle);
        TextView resultSubTitle = (TextView) convertView.findViewById(R.id.resultSubTitle);

         LinearLayout leftContainer = (LinearLayout) convertView.findViewById(R.id.topLeftContainer);

        GameParticipant localParticipant = gameRow.getLocalParticipant();
        GameParticipant visitorParticipant = gameRow.getVisitorParticipant();
        Team localTeam = localParticipant.getTeam();
        Team visitorTeam = visitorParticipant.getTeam();
        leftContainer.setBackgroundColor(Color.parseColor(gameRow.getTournament().getHexColor()));
        resultTitle.setText(gameRow.getTournament().getName());

        String gameSubTitle = gameRow.getGroup().getName();
        if(!gameRow.getGroup().getName().equals("")) gameSubTitle = gameSubTitle + " - ";
        gameSubTitle = gameSubTitle + "Fecha " + gameRow.getGameNumber();

        resultSubTitle.setText(gameSubTitle);

        if(localParticipant != null) {
            if(localTeam != null){
                localLogo.setImageBitmap(localTeam.getImageBitmap());
                localNameTxt.setText(localTeam.getName());
                localScoreTxt.setText(localParticipant.getScore()+"");
            }

        }
        if(visitorParticipant != null){
            if(visitorTeam != null){
                visitorLogo.setImageBitmap(visitorTeam.getImageBitmap());
                visitorNameTxt.setText(visitorTeam.getName());
                visitorScoreTxt.setText(visitorParticipant.getScore()+"");
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        dayNumberTxt.setText(simpleDateFormat.format(gameRow.getEventDate()).toUpperCase());

        simpleDateFormat = new SimpleDateFormat("MMMM");
        monthNameTxt.setText(simpleDateFormat.format(gameRow.getEventDate()).toUpperCase());

        simpleDateFormat = new SimpleDateFormat("yyyy");
        yearNumberTxt.setText(simpleDateFormat.format(gameRow.getEventDate()).toUpperCase());

        simpleDateFormat = new SimpleDateFormat("HH:mm");
        hourStringTxt.setText(simpleDateFormat.format(gameRow.getEventDate()).toUpperCase() + " hrs");


        return convertView;

    }

    public void update()
    {
        this.rowItem = TournamentManager.getInstance().getGamesResults();
        this.notifyDataSetChanged();
    }

}
