package com.funcgames.app.func;

import android.content.Context;

import java.util.ArrayList;

public class PlayLab {

    private ArrayList<Play> mPlays;

    private static PlayLab sPlayLab;
    private Context mAppContext;

    private PlayLab(Context appContext){
        mAppContext = appContext;
        mPlays = new ArrayList<Play>();

        Friend f = new Friend();
        f.setName("Yo Man");

        Play play = null;
        for(int i = 0; i < 7; i++){
            play = new Play();
            play.setId(i);
            play.setFriend(FriendLab.get(mAppContext).getFriends().get(i));
            play.setGame(GameLab.get(mAppContext).getGames().get(i));
            mPlays.add(play);
        }
    }

    public static PlayLab get(Context c){
        if(sPlayLab == null)
            sPlayLab = new PlayLab(c.getApplicationContext());
        return sPlayLab;
    }

    public ArrayList<Play> getPlays(){
        return mPlays;
    }

    public Play getPlay(int id){
        for(Play play : mPlays){
            if(play.getId() == id)
                return play;
        }
        return null;
    }

}
