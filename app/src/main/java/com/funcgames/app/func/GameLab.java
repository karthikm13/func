package com.funcgames.app.func;

import android.content.Context;

import java.util.ArrayList;

public class GameLab {

    private static ArrayList<Game> mGames;

    private static GameLab sGameLab;
    private Context mAppContext;

    private GameLab(Context appContext){
        mAppContext = appContext;
        mGames = new ArrayList<Game>();
        Game game = null;
        for(int i = 0; i < 17; i++){
            game = new Game();
            game.setId(i);
            game.setName("Game" + i);
            game.setType("Type" + i);
            mGames.add(game);
        }
    }

    public static GameLab get(Context c){
        if(sGameLab == null)
            sGameLab = new GameLab(c.getApplicationContext());
        return sGameLab;
    }

    public static  ArrayList<Game> getGames(){
        return mGames;
    }

    public static Game getGame(int id){
        for(Game game : mGames){
            if(game.getId() == id)
                return game;
        }
        return null;
    }
}
