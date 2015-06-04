package com.funcgames.app.func;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {

    private List<Game> gameList;
    private Context context;

    public GameListAdapter(List<Game> gameList, Context context) {
        this.gameList = gameList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    @Override
    public void onBindViewHolder(GameViewHolder gameViewHolder, int i) {
        Game game = gameList.get(i);
        gameViewHolder.gameName.setText(game.getName());
        gameViewHolder.position = i;

    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_list_item, viewGroup, false);
        CardView card = (CardView)itemView.findViewById(R.id.game_card);
        card.setCardBackgroundColor(context.getResources().getColor(android.R.color.white));
        return new GameViewHolder(itemView, i);
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        protected TextView gameName;
        protected int position;

        public GameViewHolder(View v, int pos) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Game game = GameLab.getGame(position);
                    Intent i = new Intent(v.getContext(), GameActivity.class);
                    Pair<View, String> p1 = Pair.create(v.findViewById(R.id.image), "game_image");
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)v.getContext(), p1);
                    i.putExtra("game_id", game.getId());
                    v.getContext().startActivity(i, options.toBundle());
                }
            });
            gameName =  (TextView) v.findViewById(R.id.game_name);
        }
    }

}
