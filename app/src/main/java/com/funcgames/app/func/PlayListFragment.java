package com.funcgames.app.func;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayListFragment extends ListFragment{

    private ArrayList<Play> mPlays;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlays = PlayLab.get(getActivity()).getPlays();

        PlayAdapter adapter = new PlayAdapter(mPlays);
        setListAdapter(adapter);


    }

    private class PlayAdapter extends ArrayAdapter<Play> {

        public PlayAdapter(ArrayList<Play> plays){
            super(getActivity(), 0, plays);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.play_list_item, null);
            }
            Play p = getItem(position);

            TextView playerNameTextView = (TextView) convertView.findViewById(R.id.player_name);
            playerNameTextView.setText("with " + p.getFriend().getName());

            TextView gameNameTextView = (TextView) convertView.findViewById(R.id.game_name);
            gameNameTextView.setText(p.getGame().getName());

            ImageView playerPicture = (ImageView) convertView.findViewById(R.id.player_pic);
            playerPicture.setImageDrawable(getResources().getDrawable(R.drawable.user));

            return convertView;
        }
    }

}
