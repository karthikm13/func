package com.funcgames.app.func;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendListFragment extends ListFragment{

    private ArrayList<Friend> mFriends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriends = FriendLab.get(getActivity()).getFriends();

        FriendAdapter adapter = new FriendAdapter(getActivity(), mFriends);
        setListAdapter(adapter);

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Friend f = (Friend)(getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(), FriendActivity.class);
//        Pair<View, String> p1 = Pair.create(v.findViewById(R.id.friend_pic), "friend_image");
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this.getActivity(), p1);
        i.putExtra("friend_id", f.getId());
        getActivity().startActivity(i);//, options.toBundle());
    }




}
