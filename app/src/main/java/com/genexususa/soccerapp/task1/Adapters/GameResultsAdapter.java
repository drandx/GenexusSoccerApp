package com.genexususa.soccerapp.task1.Adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.genexususa.soccerapp.task1.Managers.TournamentManager;
import com.genexususa.soccerapp.task1.Model.Game;
import com.genexususa.soccerapp.task1.R;
import com.genexususa.soccerapp.task1.Utils.TournamentObserver;

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

       /* ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        RowItem row_pos = rowItem.get(position);
        // setting the image resource and title
        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());*/

        return convertView;

    }

    public void update()
    {
        this.rowItem = TournamentManager.getInstance().getGames();
        this.notifyDataSetChanged();
    }

}
