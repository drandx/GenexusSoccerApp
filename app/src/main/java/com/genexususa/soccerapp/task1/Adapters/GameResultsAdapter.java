package com.genexususa.soccerapp.task1.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.Model.Game;
import com.genexususa.soccerapp.task1.Model.GameParticipant;
import com.genexususa.soccerapp.task1.Model.Team;
import com.genexususa.soccerapp.task1.R;
import com.genexususa.soccerapp.task1.Utils.ImageProccesing;
import com.genexususa.soccerapp.task1.Utils.TournamentObserver;

import java.util.List;

/**
 * Created by juangarcia on 4/21/15.
 */
public class GameResultsAdapter extends BaseAdapter implements TournamentObserver {

    Context context;
    List<Game> rowItem;

    public GameResultsAdapter(Context context, List<Game> rowItem) {
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
        Game gameRow = rowItem.get(position);
        ImageView localLogo = (ImageView) convertView.findViewById(R.id.iconLocal);
        ImageView visitorLogo = (ImageView) convertView.findViewById(R.id.iconVisitor);

        Team localTeam = null;
        Team visitorTeam = null;
        GameParticipant localParticipant = gameRow.getLocalParticipant();
        GameParticipant visitorParticipant = gameRow.getVisitorParticipant();

        if(localParticipant != null) {
            localTeam = TournamentManager.getInstance().getTeamById(localParticipant.getTeamId());
        }
        if(visitorParticipant != null){
            visitorTeam = TournamentManager.getInstance().getTeamById(visitorParticipant.getTeamId());
        }

        if(localTeam != null){
            Drawable d = ImageProccesing.getDrawable(localTeam.getLogoFile().substring(0, localTeam.getLogoFile().lastIndexOf('.')), context);
            Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
            bitmap = ImageProccesing.eraseBG(bitmap, -1);
            localLogo.setImageBitmap(bitmap);
        }
        if(visitorTeam != null){
            Drawable d = ImageProccesing.getDrawable(visitorTeam.getLogoFile().substring(0, visitorTeam.getLogoFile().lastIndexOf('.')), context);
            Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
            bitmap = ImageProccesing.eraseBG(bitmap, -1);
            visitorLogo.setImageBitmap(bitmap);
        }

        return convertView;

    }

    public void update()
    {
        this.rowItem = TournamentManager.getInstance().getGames();
        this.notifyDataSetChanged();
    }

}
